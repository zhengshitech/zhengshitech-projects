package tech.zhengshi.clazz.webapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tech.zhengshi.clazz.dto.StudentClassDTO;
import tech.zhengshi.clazz.hystrix.StudentClassServiceFallbackFactory;
import tech.zhengshi.core.dt.RestfulRollbackAware;
import tech.zhengshi.core.dt.RollbackMethod;

import java.util.List;

/**
 * @author H
 * @date 2017/1/11
 */
@FeignClient(name = "student-class-api", path = StudentClassApi.MAPPING, fallbackFactory = StudentClassServiceFallbackFactory.class)
public interface StudentClassApi extends RestfulRollbackAware{

    String MAPPING = "/student-class";

    /**
     * 保存学生班级
     *
     * @param studentClass 学生班级信息
     * @return 学生班级关联ID
     */
    @RequestMapping(value = "/saveOne", method = RequestMethod.POST)
    Long saveOne(@RequestBody StudentClassDTO studentClass);

    /**
     * 保存学生班级
     *
     * @param studentAccountId 学生班级信息
     * @return 学生班级关联ID
     */
    @RollbackMethod("rollbackRemoveByStudent")
    @RequestMapping(value = "/removeByStudent", method = RequestMethod.POST)
    Boolean removeByStudent(@RequestBody Long studentAccountId);

    @RequestMapping(value = "/rollbackRemoveByStudent", method = RequestMethod.POST)
    Boolean rollbackRemoveByStudent(@RequestBody Long studentAccountId);

    @RequestMapping(value = "/getByStudent/{studentId}", method = RequestMethod.GET)
    StudentClassDTO getByStudent(@PathVariable("studentId") Long studentId);

    @RequestMapping(value = "getDTOByID/{id}", method = RequestMethod.GET)
    StudentClassDTO getDTOByID(@PathVariable("id") Long id);

    @PostMapping(value = "getDTOByIDs")
    List<StudentClassDTO> getDTOByIDs(@RequestBody List<Long> ids);
}
