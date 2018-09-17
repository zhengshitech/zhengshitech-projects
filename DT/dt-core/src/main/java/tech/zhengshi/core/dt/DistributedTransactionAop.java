package tech.zhengshi.core.dt;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Stack;

/**
 * @author H
 */
@Aspect
@Component
public class DistributedTransactionAop {


    private static final int ROOT_DT_METHOD = 0;
    public static final String INSERT_ROLLBACK = "insertRollback";
    public static final String DELETE_ROLLBACK = "deleteRollback";
    public static final String UPDATE_ROLLBACK = "updateRollback";
    public static final String OBJECT_GET = "getDTOByID";
    public static final String OBJECT_GET_BY_IDS = "getDTOByIDs";

    public static final String TRX_SAVE_METHODS = "save";
    public static final String TRX_MODIFY_METHODS = "modify";
    public static final String TRX_REMOVE_METHODS = "remove";

    static ThreadLocal<Stack<DistributedMethod>> methodInvokeStack = new ThreadLocal<>();
    static ThreadLocal<Stack<DistributedMethod>> transactionHolderStack = new ThreadLocal<>();


    static {
        methodInvokeStack.set(new Stack<>());
        transactionHolderStack.set(new Stack<>());
    }


    @Around("distributedTransactionMethod()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {


        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method m = signature.getMethod();
        Object target = pjp.getTarget();
        Class<?> declaringClass = m.getDeclaringClass();
        Object[] args = getArgs(pjp.getArgs());

        String methodKey = pjp.getSignature().toShortString();

        DistributedMethod currentMethod = new DistributedMethod();
        currentMethod.setId(IDUtil.getTrasanctionID());
        currentMethod.setName(methodKey);
        currentMethod.setExecuteClass(declaringClass);
        currentMethod.setExecuteMethod(m);
        currentMethod.setArgs(args);
        currentMethod.setTarget(target);
        if (m.getName().startsWith(TRX_MODIFY_METHODS)) {
            //modify method,so keep old data here
            setOldEntity(currentMethod);
        }
        currentMethod.setSuccess(true);

        Stack<DistributedMethod> stack = methodInvokeStack.get();
        if (null == stack || stack.size() == 0) {
            stack = new Stack<>();
            currentMethod.setInvokeLevel(ROOT_DT_METHOD);
            stack.push(currentMethod);
            methodInvokeStack.set(stack);
        } else {
            DistributedMethod parent = stack.peek();
            currentMethod.setInvokeLevel(parent.getInvokeLevel() + 1);
            currentMethod.setParent(parent);
            stack.push(currentMethod);
        }
        try {
            return pjp.proceed();
        } catch (Exception e) {
//            e.printStackTrace();
            //事务失败
            currentMethod.setSuccess(false);
            throw new Exception(e.getMessage(), e.getCause());
        } finally {
            if (!currentMethod.isSuccess()) {
                rollBackAll();
            } else {
                DistributedMethod completeMethod = stack.pop();
                if (completeMethod.getInvokeLevel() >= ROOT_DT_METHOD) {
                    Stack<DistributedMethod> method = transactionHolderStack.get();
                    if (null == method) {
                        method = new Stack<>();
                        transactionHolderStack.set(method);
                    }
                    method.push(completeMethod);
                } else if (completeMethod.getInvokeLevel() == ROOT_DT_METHOD) {
                    cleanTransactionHolderStack();
                }
            }
        }
    }

    private Object[] getArgs(Object[] args) {
        if (args == null) {
            return args;
        }
        for (Object arg : args) {
            boolean isIdAware = arg instanceof IDAware;
            if (isIdAware) {
                IDAware idOwner = (IDAware) arg;
                if (StringUtils.isEmpty(idOwner.getId())) {
                    Long newId = IDUtil.getID();
                    System.out.println("为对象生成ID:" + newId);
                    idOwner.setId(newId);
                }
            }
        }

        return args;

    }

    private void rollBackAll() throws InstantiationException {

        Stack<DistributedMethod> stack = transactionHolderStack.get();
        if (null != stack) {
            while (!stack.empty()) {
                DistributedMethod executedMethod = stack.pop();
                Object aClass = executedMethod.getExecuteClass();
                Class targetClz = (Class) aClass;
                if (isNeedRollback(targetClz)) {
//                    System.out.println("回滚方法[" + executedMethod.getName() + "]事务");
                    //需要进行回滚的
                    String name = executedMethod.getExecuteMethod().getName();
                    Object[] args = executedMethod.getArgs();
                    if (name.startsWith(TRX_SAVE_METHODS)) {
                        insertRollback(executedMethod, targetClz, args);
                    } else if (name.startsWith(TRX_MODIFY_METHODS)) {
                        updateRollback(executedMethod, targetClz, args);
                    } else if (name.startsWith(TRX_REMOVE_METHODS)) {
                        deleteRollback(executedMethod, targetClz, args);
                    }
                }
            }
        }

    }

    private void deleteRollback(DistributedMethod executedMethod, Class targetClz, Object[] args) {
        String rollbackMethodName = getRollBackMethodName(executedMethod, DELETE_ROLLBACK);
        insertOrDeleteRollback(executedMethod, targetClz, args, rollbackMethodName);
    }

    private String getRollBackMethodName(DistributedMethod executedMethod, String defaultRollbackMethodName) {
        RollbackMethod annotation = executedMethod.getExecuteMethod().getAnnotation(RollbackMethod.class);
        if (annotation != null) {
            String customRollBackMethodName = annotation.value();
            if (!StringUtils.isEmpty(customRollBackMethodName)) {
                defaultRollbackMethodName = customRollBackMethodName;
            }
        }
        return defaultRollbackMethodName;
    }

    private void updateRollback(DistributedMethod executedMethod, Class targetClz, Object[] args) {
        boolean success = false;
        //updateRollback
        try {
            Object instanceObj = executedMethod.getTarget();
            String rollbackMethodName = getRollBackMethodName(executedMethod, UPDATE_ROLLBACK);
            Method updateRollback = targetClz.getMethod(rollbackMethodName, UpdateObject.class);
            if (args.length == 1) {
                boolean isIDAware = args[0] instanceof IDAware;
                if (isIDAware) {
                    IDAware idOwner = (IDAware) args[0];
                    UpdateObject updateObject = new UpdateObject(idOwner, executedMethod.getOldEntity());
//                    System.out.println("UPDATE REVERT OBJ:" + updateObject);
                    updateRollback.invoke(instanceObj, updateObject);
                } else {
                    System.err.println("NOT SUPPORT OBJECT");
                }
            } else if (args.length > 1) {
                //batch rollback
            }
            success = true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.err.println(e.getMessage());
        } finally {
            printRollbackMsg(executedMethod.getName(), success);
        }

    }

    private void printRollbackMsg(String method, boolean success) {
        String msg = "TRX ROLL BACK RESULT[" + success + "]回滚方法[" + method + "]";
        System.out.println(msg);
    }

    private void insertRollback(DistributedMethod executedMethod, Class targetClz, Object[] args) {
        String rollbackMethodName = getRollBackMethodName(executedMethod, INSERT_ROLLBACK);
        insertOrDeleteRollback(executedMethod, targetClz, args, rollbackMethodName);
    }

    private void insertOrDeleteRollback(DistributedMethod executedMethod, Class targetClz, Object[] args, String rollBackMethodName) {
        boolean success = false;
        //insertRollback
        try {
            Object instanceObj = executedMethod.getTarget();
            Method rollbackMethod = targetClz.getMethod(rollBackMethodName, Long.class);
            if (args.length == 1) {
                boolean isIDAware = args[0] instanceof IDAware;
                if (isIDAware) {
                    IDAware idOwner = (IDAware) args[0];
                    Long id = idOwner.getId();
//                    System.out.println("REMOVE ID:" + id);
                    rollbackMethod.invoke(instanceObj, id);
                } else {
                    Long id = Long.valueOf(args[0].toString());
//                    System.out.println("REMOVE PRIMARY KEY ID:" + id);
                    rollbackMethod.invoke(instanceObj, id);
                }
            } else if (args.length > 1) {
                //batch rollback
                System.out.println("batch rollback");
            }
            success = true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.err.println(e.getMessage());
        } finally {
            printRollbackMsg(executedMethod.getName(), success);
        }
    }

    private boolean isNeedRollback(Class aClass) {
        boolean rollBack = false;
        Class[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            boolean isTarget = Objects.equals(anInterface.getName(), RestfulRollbackAware.class.getName());
            if (isTarget) {
                rollBack = true;
                break;
            }
        }
        return rollBack;
    }


    private void cleanTransactionHolderStack() {
        Stack<DistributedMethod> stack = transactionHolderStack.get();
        if (null != stack) {
            while (!stack.empty()) {
                stack.pop();
            }
        }
    }

    /**
     * 事务切入点
     */

    @Pointcut("execution(public * tech.zhengshi..*.*(..))")
    public void distributedTransactionMethod() {
    }

    public void setOldEntity(DistributedMethod executedMethod) {
        int indx = executedMethod.getName().indexOf("Api.");
        if (indx < 0) {
            //only *Api
            return;
        }
        try {
            Object instanceObj = executedMethod.getTarget();
            Class targetClz = executedMethod.getExecuteClass();
            Object[] args = executedMethod.getArgs();
            if (args.length == 1) {
                boolean isIDAware = args[0] instanceof IDAware;
                if (isIDAware) {
                    IDAware idOwner = (IDAware) args[0];
                    Long id = idOwner.getId();
                    Method getMethod = targetClz.getMethod(OBJECT_GET, Long.class);
                    Object oldEntity = getMethod.invoke(instanceObj, id);
                    if (oldEntity == null) {
                        System.err.println("NOT GET OLD ENTITY DATA");
                    }
                    executedMethod.setOldEntity(oldEntity);
                }
            } else {
                //multi update....
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法信息对象
     */

    class DistributedMethod {

        //执行方法信息
        private Method executeMethod;
        private Object[] args;
        private Class executeClass;
        private Object target;
        private Object oldEntity;

        //名称
        private String id;
        //名称
        private String name;
        //事务执行成功
        private boolean success;
        //调用层级
        private Integer invokeLevel;
        private DistributedMethod parent;


        public Object getOldEntity() {
            return oldEntity;
        }

        public void setOldEntity(Object oldEntity) {
            this.oldEntity = oldEntity;
        }

        Object getTarget() {
            return target;
        }

        void setTarget(Object target) {
            this.target = target;
        }

        Method getExecuteMethod() {
            return executeMethod;
        }

        void setExecuteMethod(Method executeMethod) {
            this.executeMethod = executeMethod;
        }

        Object[] getArgs() {
            return args;
        }

        void setArgs(Object[] args) {
            this.args = args;
        }

        Class getExecuteClass() {
            return executeClass;
        }

        void setExecuteClass(Class executeClass) {
            this.executeClass = executeClass;
        }


        String getId() {
            return id;
        }

        void setId(String id) {
            this.id = id;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        boolean isSuccess() {
            return success;
        }

        void setSuccess(boolean success) {
            this.success = success;
        }

        Integer getInvokeLevel() {
            return invokeLevel;
        }

        void setInvokeLevel(Integer invokeLevel) {
            this.invokeLevel = invokeLevel;
        }

        DistributedMethod getParent() {
            return parent;
        }

        void setParent(DistributedMethod parent) {
            this.parent = parent;
        }
    }

}
