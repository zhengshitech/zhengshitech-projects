package com.z.tech.rbac.rbac;


import com.z.tech.rbac.ApplicationRBAC;
import com.z.tech.rbac.dto.DepartmentDTO;
import com.z.tech.rbac.service.DepartmentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static com.z.tech.rbac.constant.CommonConstants.TREE_ROOT_PID;
import static com.z.tech.rbac.rbac.util.ChinesCharacterUtil.chinese128;
import static com.z.tech.rbac.rbac.util.ChinesCharacterUtil.chinese129;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApplicationRBAC.class)
@DirtiesContext
public class T003_DepartmentTests {
    @Autowired
    private DepartmentService departmentService;

    @Test
    public void createDepartment() {
        mockADepartmentAndSave("测试部门", TREE_ROOT_PID);
    }


    @Test
    public void createChildDepartment() {

        mockADepartmentAndSave("测试5子部门添加", 5);
        mockADepartmentAndSave("测试5子部门添加", 5);
        mockADepartmentAndSave("测试8子部门添加", 8);
        mockADepartmentAndSave("测试9子部门添加", 9);
    }

    private void mockADepartmentAndSave(String departmentName, int pid) {
        DepartmentDTO newDepartment = new DepartmentDTO();
        newDepartment.setName(departmentName);
        newDepartment.setPid(pid);
        newDepartment.setTenantId(22);
        departmentService.save(newDepartment);
    }


    @Test
    public void validateDepartmentNameLength_128() {

        mockADepartmentAndSave(chinese128, TREE_ROOT_PID);
    }

    @Test
    public void validateDepartmentNameLength_129() {

        DepartmentDTO newDepartment = new DepartmentDTO();
        newDepartment.setName(chinese129);
        newDepartment.setTenantId(22);
        boolean lengthIsError = true;
        try {
            departmentService.save(newDepartment);
            lengthIsError = false;
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(lengthIsError);
    }

    @Test
    public void updateDepartment() {
        int id = 8;
        DepartmentDTO department = departmentService.getByID(id);
        department.setName(department.getName() + "modify");
        departmentService.modify(department);
    }

    @Test
    public void deleteDepartment() {
        int id = 2;
        departmentService.delete(id);
    }

    @Test
    public void searchOneDepartment() {
        int id = 1;
        DepartmentDTO department = departmentService.getByID(id);
        System.out.println(department);
    }

    @Test
    public void searchMultiDepartment() {
        List<Integer> ids = new ArrayList<>(2);
        ids.add(1);
        ids.add(2);
        List<DepartmentDTO> departments = departmentService.getByIDs(ids);
        System.out.println(departments);
    }

}
