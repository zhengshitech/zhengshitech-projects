package tech.zhengshi.td.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.zhengshi.clazz.dto.StudentClassDTO;
import tech.zhengshi.clazz.webapi.StudentClassApi;
import tech.zhengshi.core.dt.DistributedTransaction;
import tech.zhengshi.student.dto.StudentDTO;
import tech.zhengshi.student.webapi.StudentApi;
import tech.zhengshi.td.dto.AccountDTO;
import tech.zhengshi.td.exception.BizException;

@RestController
public class AccountController {

    @Autowired
    private StudentApi studentApi;
    @Autowired
    private StudentClassApi studentClassApi;


    /**
     * 保存学生及其班级
     *
     * @param account 学生及其班级信息
     * @return 学生ID
     */
    @DistributedTransaction
    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    public String saveAccount(@RequestBody AccountDTO account) {

        Long savedStudentId = studentApi.saveOne(getStudent(account));
        if (savedStudentId < 1) {
            throw new BizException("Biz:保存学生失败");
        }
        StudentClassDTO studentClass = getStudentClass(account);
        studentClass.setStudentId(savedStudentId);
        Long relationId = studentClassApi.saveOne(studentClass);
        if (relationId < 1) {
            throw new BizException("Biz:保存学生班级关联失败");
        }
        return savedStudentId.toString();
    }


    @DistributedTransaction
    @RequestMapping(value = "/modifyAccount", method = RequestMethod.POST)
    public String modifyAccount(@RequestBody AccountDTO account) {

        Long studentId = studentApi.modifyOne(getStudent(account));
        if (studentId < 1) {
            throw new BizException("修改学生失败");
        }

        //先移除学生的班级数据
        Boolean success = studentClassApi.removeByStudent(studentId);
        if (!success) {
            throw new BizException("删除学生班级数据失败");
        }

        //添加新的学生班级数据
        Long relationId = studentClassApi.saveOne(getStudentClass(account));
        if (relationId < 1) {
            throw new BizException("保存学生新的班级关联数据失败");
        }
        return studentId.toString();
    }

    private StudentClassDTO getStudentClass(AccountDTO account) {
        StudentClassDTO studentClass = new StudentClassDTO();
        studentClass.setClassId(account.getClassId());
        studentClass.setGradeId(account.getGradeId());
        studentClass.setStudentId(account.getStudentId());
        return studentClass;
    }

    private StudentDTO getStudent(AccountDTO account) {

        StudentDTO student = new StudentDTO();

        student.setId(account.getId());
        student.setUserAge(account.getUserAge());
        student.setIdnumber(account.getIdnumber());
        student.setUserName(account.getUserName());
        student.setPhone(account.getPhone());

        return student;

    }


    @RequestMapping(value = "/deleteAccount/{id}", method = RequestMethod.POST)
    public boolean deleteAccount(@PathVariable("id") Long studentId) {
        Long deleteStudentId = studentApi.removeById(studentId);
        if (deleteStudentId <= 1L) {
            throw new BizException("删除学生数据失败!");
        }
        Boolean success = studentClassApi.removeByStudent(studentId);
        if (!success) {
            throw new BizException("删除学生班级数据失败!");
        }
        return true;
    }

    @RequestMapping(value = "/getAccount/{id}", method = RequestMethod.GET)
    public AccountDTO getAccount(@PathVariable("id") Long id) {

        AccountDTO account = new AccountDTO();

        StudentDTO student = studentApi.getDTOByID(id);
        if (student == null) {
            return account;
        }

        //学生信息
        account.setUserAge(student.getUserAge());
        account.setId(student.getId());
        account.setUserName(student.getUserName());
        account.setIdnumber(student.getIdnumber());
        account.setPhone(student.getPhone());

        //班级信息
        StudentClassDTO studentClass = studentClassApi.getByStudent(id);
        if (studentClass == null) {
            return account;
        }
        account.setStudentId(studentClass.getStudentId());
        account.setClassId(studentClass.getClassId());
        account.setClassName("高2015级1班");
        account.setGradeId(studentClass.getGradeId());
        account.setType(1);
        account.setStudentMaxNumber(60);
        account.setLocation("A教-3-305");
        return account;
    }

}
