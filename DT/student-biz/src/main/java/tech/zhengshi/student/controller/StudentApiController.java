package tech.zhengshi.student.controller;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.zhengshi.core.base.controller.DTBaseController;
import tech.zhengshi.core.dt.UpdateObject;
import tech.zhengshi.student.domain.StudentDomain;
import tech.zhengshi.student.dto.StudentDTO;
import tech.zhengshi.student.service.StudentService;
import tech.zhengshi.student.webapi.StudentApi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhengqiang
 * @date 2017/1/10 12:43
 * desc:
 */
@RestController
@RequestMapping(StudentApi.MAPPING)
public class StudentApiController extends DTBaseController<StudentDomain, StudentService> implements StudentApi {


    @Override
    public Long saveOne(@RequestBody StudentDTO studentDTO) {
        Long id = save(toDomain(studentDTO));
        System.out.println("学生数据保存成功,ID:" + id);
        return id;
    }

    @Override
    public Long modifyOne(@RequestBody StudentDTO studentDTO) {

        Long id = modify(toDomain(studentDTO));
        System.out.println("学生数据更新成功,ID:" + id);
        return id;
    }

    @Override
    public Long rollbackModifyOne(@RequestBody UpdateObject oldObject) {
        LinkedHashMap<String, Object> oldDataEntity = (LinkedHashMap<String, Object>) oldObject.getOldDataEntity();
        Long id = rollbackModifyOne(oldDataEntity);
        System.out.println("学生数据更新回滚成功,ID:" + id);
        return id;
    }

    private Long rollbackModifyOne(LinkedHashMap<String, Object> oldDataEntity) {

        Long aLong = updateRollBack(oldDataEntity);
        return aLong;
    }

    @Override
    public StudentDTO getDTOByID(@PathVariable("id") Long id) {
        StudentDomain domain = (StudentDomain) get(id);
        return toDTO(domain);
    }

    private StudentDTO toDTO(StudentDomain domain) {
        StudentDTO dto = new StudentDTO();
        dto.setId(domain.getId());
        dto.setIdnumber(domain.getIdnumber());
        dto.setPhone(domain.getPhone());
        dto.setUserName(domain.getUserName());
        dto.setUserAge(domain.getUserAge());
        return dto;
    }

    private StudentDomain toDomain(StudentDTO dto) {
        StudentDomain domain = new StudentDomain();
        domain.setId(dto.getId());
        domain.setIdnumber(dto.getIdnumber());
        domain.setPhone(dto.getPhone());
        domain.setUserName(dto.getUserName());
        domain.setUserAge(dto.getUserAge());
        return domain;
    }

    @Override
    public List<StudentDTO> getDTOByIDs(@RequestBody List<Long> ids) {

        List<StudentDomain> domains = getByIDs(ids);
        if (CollectionUtils.isEmpty(domains)) {
            return new ArrayList<>(0);
        }
        return domains.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public Long removeById(@PathVariable("id") Long id) {
        Long removeId = remove(id);
        return removeId;
    }


}
