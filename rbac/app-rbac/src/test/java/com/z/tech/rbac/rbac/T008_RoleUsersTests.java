package com.z.tech.rbac.rbac;


import com.z.tech.rbac.ApplicationRBAC;
import com.z.tech.rbac.dto.RoleUserDTO;
import com.z.tech.rbac.dto.UserDTO;
import com.z.tech.rbac.service.RoleUserService;
import com.z.tech.rbac.service.UserService;
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
public class T008_RoleUsersTests {

    @Autowired
    private RoleUserService roleUserService;
    @Autowired
    private UserService userService;

    @Test
    public void createRoleUser() {
        RoleUserDTO roleUser = new RoleUserDTO();
        roleUser.setRoleId(3);
        roleUser.setUserId(3);
        roleUserService.save(roleUser);
    }

    @Test
    public void createRoleUsers() {
        List<UserDTO> users = userService.getByDepartment(22);
        int roleId = 3;
        List<RoleUserDTO> roleUsers = new ArrayList<>(10);
        for (UserDTO user : users) {
            RoleUserDTO roleUser = new RoleUserDTO();
            roleUser.setRoleId(roleId);
            roleUser.setUserId(user.getId());
            roleUsers.add(roleUser);
        }
        roleUserService.save(roleUsers);
    }



    @Test
    public void deleteByID() {
        int id = 2;
        roleUserService.delete(id);
    }

    @Test
    public void deleteByUser() {
        int userId = 5;
        int affectRows = roleUserService.deleteByUser(userId);
        System.out.println("affectRows:" + affectRows);
    }

    @Test
    public void deleteByRole() {
        int roleId = 3;
        int affectRows = roleUserService.deleteByRole(roleId);
        System.out.println("affectRows:" + affectRows);
    }



    @Test
    public void selectByRole() {
        int roleId = 3;
        List<RoleUserDTO> roleUsers = roleUserService.getByRole(roleId);
        System.out.println(roleUsers);
    }

    @Test
    public void selectByUser() {
        int userId = 5;
        List<RoleUserDTO> roleUsers = roleUserService.getByUser(userId);
        System.out.println(roleUsers);
    }

    @Test
    public void searchOneRoleUser() {
        int id = 1;
        RoleUserDTO roleUser = roleUserService.getByID(id);
        System.out.println(roleUser);
    }

    @Test
    public void searchMultiRoleUser() {
        List<Integer> ids = new ArrayList<>(2);
        ids.add(1);
        ids.add(2);
        List<RoleUserDTO> roleUsers = roleUserService.getByIDs(ids);
        System.out.println(roleUsers);
    }


}
