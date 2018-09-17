package com.z.tech.rbac.rbac;


import com.z.tech.rbac.ApplicationRBAC;
import com.z.tech.rbac.dto.UserDTO;
import com.z.tech.core.exception.BizCode;
import com.z.tech.core.exception.BizException;
import com.z.tech.rbac.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.z.tech.rbac.rbac.util.Generator.getName;
import static com.z.tech.rbac.rbac.util.Generator.getTel;
import static com.z.tech.rbac.util.MD5Util.doMD5;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApplicationRBAC.class)
@DirtiesContext
public class T004_UserTests {
    @Autowired
    private UserService userService;

    @Test
    public void createUser() {
        UserDTO user = new UserDTO();
        user.setDepartmentId(22);
        user.setTenantId(22);
        String name = getName("", 3);
        user.setName(name);
        String tel = getTel();
        user.setPhone(tel);
        String inputPassword = "123456";
        user.setPassword(doMD5(inputPassword));
        user.setType(1);
        userService.save(user);
    }


    @Test
    public void phoneExists() {

        String phone = "13012345677";
        boolean exists = userService.getByPhone(phone);
        Assert.assertTrue(exists);
    }

    @Test
    public void phoneNotExists() {

        String phone = "13812345677";
        boolean exists = userService.getByPhone(phone);
        Assert.assertFalse(exists);
    }

    @Test
    public void updateUser() {
        int id = 3;
        UserDTO user = userService.getByID(id);
        if (null == user) {
            throw new BizException(BizCode.OPERATION_DATA_NOT_EXIST);
        }
        user.setName("用户姓名修改modify");
        userService.modify(user);
    }

    @Test
    public void deleteUser() {
        int id = 2;
        userService.delete(id);
    }

    @Test
    public void searchOneUser() {
        int id = 1;
        UserDTO user = userService.getByID(id);
        System.out.println(user);
    }

    @Test
    public void searchMultiUser() {
        List<Integer> ids = new ArrayList<>(2);
        ids.add(1);
        ids.add(2);
        List<UserDTO> users = userService.getByIDs(ids);
        System.out.println(users);
    }

}
