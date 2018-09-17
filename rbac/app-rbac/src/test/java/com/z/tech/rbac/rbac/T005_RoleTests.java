package com.z.tech.rbac.rbac;


import com.z.tech.rbac.ApplicationRBAC;
import com.z.tech.rbac.dto.RoleDTO;
import com.z.tech.core.exception.BizCode;
import com.z.tech.core.exception.BizException;
import com.z.tech.rbac.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApplicationRBAC.class)
@DirtiesContext
public class T005_RoleTests {


    @Autowired
    private RoleService roleService;

    @Test
    public void createRole() {
        RoleDTO role = new RoleDTO();
        role.setName("测试角色");
        role.setCode("TestRole" + System.currentTimeMillis());
        role.setApplicationId(3);
        roleService.save(role);
    }


    @Test
    public void roleCodeExists() {

        String code = "TestRole1534172401675";
        boolean exists = roleService.getByCodeAndApplication(code, null, 3);
        Assert.assertTrue(exists);
    }

    @Test
    public void roleCodeNotExists() {

        String code = "TestRole";
        boolean exists = roleService.getByCodeAndApplication(code, null, 3);
        Assert.assertFalse(exists);
    }

    @Test
    public void updateRole() {
        int id = 3;
        RoleDTO role = roleService.getByID(id);
        if (null == role) {
            throw new BizException(BizCode.OPERATION_DATA_NOT_EXIST);
        }
        role.setName("角色名称modify");
        roleService.modify(role);
    }

    @Test
    public void deleteRole() {
        int id = 2;
        roleService.delete(id);
    }

    @Test
    public void searchOneRole() {
        int id = 1;
        RoleDTO role = roleService.getByID(id);
        System.out.println(role);
    }

    @Test
    public void searchMultiRole() {
        List<Integer> ids = new ArrayList<>(2);
        ids.add(1);
        ids.add(2);
        List<RoleDTO> roles = roleService.getByIDs(ids);
        System.out.println(roles);
    }
}
