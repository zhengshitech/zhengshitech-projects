package tech.zhengshi.clazz.hystrix;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tech.zhengshi.clazz.dto.StudentClassDTO;
import tech.zhengshi.clazz.webapi.StudentClassApi;
import tech.zhengshi.core.dt.UpdateObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author H
 */
@Component
public class StudentClassServiceFallbackFactory implements FallbackFactory<StudentClassApi> {
    @Override
    public StudentClassApi create(Throwable cause) {
        return new StudentClassApi() {

            @Override
            public Long saveOne(@RequestBody StudentClassDTO studentClass) {
                System.out.println("服务调用失败:" + cause.getMessage());
                return 0L;
            }


            @Override
            public Boolean removeByStudent(@RequestBody Long studentAccountId) {
                System.out.println("服务调用失败:" + cause.getMessage());
                return false;
            }  @Override
            public Boolean rollbackRemoveByStudent(@RequestBody Long studentAccountId) {
                System.out.println("服务调用失败:" + cause.getMessage());
                return false;
            }

            @Override
            public StudentClassDTO getByStudent(@PathVariable("studentId") Long studentId) {
                System.out.println("服务调用失败:" + cause.getMessage());
                return null;
            }

            @Override
            public boolean insertRollback(@RequestBody Long id) {
                System.out.println("### 失败 ### 插入回滚ID:" + id);
                return false;
            }


            @Override
            public boolean deleteRollback(@RequestBody Long id) {
                System.out.println("### 失败 ### 删除回滚ID:" + id);
                return false;
            }


            @Override
            public boolean updateRollback(@RequestBody UpdateObject object) {
                System.out.println("### 失败 ### 更新回滚ID:" + object.getId());
                return false;
            }


            @Override
            public boolean insertBatchRollback(@RequestBody List<Long> ids) {
                System.out.println("### 失败 ### 批量插入回滚ID:" + getString(ids));
                return false;
            }

            private String getString(List<Long> ids) {
                if (CollectionUtils.isEmpty(ids)) {
                    return "";
                }
                return ids.stream().map(Object::toString).collect(Collectors.joining(","));
            }

            @Override
            public boolean delelteBatchRollback(@RequestBody List<Long> ids) {
                System.out.println("### 失败 ### 批量删除回滚ID:" + getString(ids));
                return false;
            }

            @Override
            public boolean updateBatchRollback(@RequestBody List<UpdateObject> objects) {
                List<Long> ids = objects.stream().map(UpdateObject::getId).collect(Collectors.toList());
                System.out.println("### 失败 ### 批量修改回滚ID:" + getString(ids));
                return false;
            }

            @Override
            public StudentClassDTO getDTOByID(@PathVariable("id") Long id) {
                System.out.println("服务调用失败:" + cause.getMessage());
                return null;
            }

            @Override
            public List<StudentClassDTO> getDTOByIDs(@RequestBody List<Long> ids) {
                System.out.println("服务调用失败:" + cause.getMessage());
                return null;
            }
        };
    }
}
