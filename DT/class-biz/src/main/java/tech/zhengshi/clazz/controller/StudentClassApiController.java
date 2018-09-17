package tech.zhengshi.clazz.controller;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.zhengshi.clazz.domain.StudentClassDomain;
import tech.zhengshi.clazz.dto.StudentClassDTO;
import tech.zhengshi.clazz.service.StudentClassService;
import tech.zhengshi.clazz.webapi.StudentClassApi;
import tech.zhengshi.core.base.controller.DTBaseController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhengqiang
 * @date 2017/1/10 12:43
 * desc:
 */
@RestController
@RequestMapping(StudentClassApi.MAPPING)
public class StudentClassApiController extends DTBaseController<StudentClassDomain, StudentClassService> implements StudentClassApi {

    @Autowired
    private StudentClassService studentClassService;

    @Override
    public Long saveOne(@RequestBody StudentClassDTO studentClass) {
        Long id = save(toDomain(studentClass));
        System.out.println("学生班级数据保存成功,ID:" + id);
//        return id;
        return 0L;
    }

    private StudentClassDomain toDomain(StudentClassDTO dto) {
        StudentClassDomain domain = new StudentClassDomain();
        domain.setId(dto.getId());
        domain.setClassId(dto.getClassId());
        domain.setGradeId(dto.getGradeId());
        domain.setStudentId(dto.getStudentId());
        return domain;
    }

    private StudentClassDTO toDTO(StudentClassDomain domain) {
        StudentClassDTO dto = new StudentClassDTO();
        dto.setId(domain.getId());
        dto.setClassId(domain.getClassId());
        dto.setGradeId(domain.getGradeId());
        dto.setStudentId(domain.getStudentId());
        return dto;
    }

    @Override
    public Boolean removeByStudent(@RequestBody Long studentId) {
        studentClassService.removeByStudent(studentId);
        System.out.println("删除成功,学生ID:" + studentId);
//        if (true) {
//            throw new RuntimeException("roll back test...");
//        }
        return true;
    }

    @Override
    public Boolean rollbackRemoveByStudent(@RequestBody Long studentId) {
        studentClassService.rollbackRemoveByStudent(studentId);
        System.out.println("删除回滚成功,学生ID:" + studentId);
        return true;
    }

    @Override
    public StudentClassDTO getByStudent(@PathVariable("studentId") Long studentId) {
        StudentClassDomain domain = studentClassService.getByStudent(studentId);
        return toDTO(domain);
    }


    @Override
    public StudentClassDTO getDTOByID(@PathVariable("id") Long id) {
        StudentClassDomain domain = (StudentClassDomain) get(id);
        return toDTO(domain);
    }

    @Override
    public List<StudentClassDTO> getDTOByIDs(@RequestBody List<Long> ids) {
        List<StudentClassDomain> domains = getByIDs(ids);
        if (CollectionUtils.isEmpty(domains)) {
            return new ArrayList<>(0);
        }
        return domains.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
