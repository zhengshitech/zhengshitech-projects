package tech.zhengshi.student.webapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tech.zhengshi.core.dt.RestfulRollbackAware;
import tech.zhengshi.core.dt.RollbackMethod;
import tech.zhengshi.core.dt.UpdateObject;
import tech.zhengshi.student.dto.StudentDTO;
import tech.zhengshi.student.hystrix.StudentServiceFallbackFactory;

import java.util.List;

/**
 * @author H
 * @date 2017/1/11
 */
@FeignClient(name = "student-api", path = StudentApi.MAPPING, fallbackFactory = StudentServiceFallbackFactory.class)
public interface StudentApi extends RestfulRollbackAware {

    String MAPPING = "/student";

    /**
     * 保存学生
     *
     * @param studentDTO 学生信息
     * @return 学生ID
     */
    @RequestMapping(value = "/saveOne", method = RequestMethod.POST)
    Long saveOne(@RequestBody StudentDTO studentDTO);

    /**
     * 保存学生
     *
     * @param studentDTO 学生信息
     * @return 学生ID
     */
    @RollbackMethod("rollbackModifyOne")
    @RequestMapping(value = "/modifyOne", method = RequestMethod.POST)
    Long modifyOne(@RequestBody StudentDTO studentDTO);


    /**
     * 反修改数据
     *
     * @param oldObject 更新前的原始数据
     * @return
     */
    @RequestMapping(value = "/rollbackModifyOne", method = RequestMethod.POST)
    Long rollbackModifyOne(@RequestBody UpdateObject oldObject);


    @RequestMapping(value = "getDTOByID/{id}", method = RequestMethod.GET)
    StudentDTO getDTOByID(@PathVariable("id") Long id);

    @PostMapping(value = "getDTOByIDs")
    List<StudentDTO> getDTOByIDs(@RequestBody List<Long> ids);

    @PostMapping(value = "removeById/{id}")
    Long removeById(@PathVariable("id") Long id);
}
