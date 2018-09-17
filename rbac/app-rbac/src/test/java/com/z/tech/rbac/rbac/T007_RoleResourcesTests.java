package com.z.tech.rbac.rbac;


import com.z.tech.rbac.ApplicationRBAC;
import com.z.tech.rbac.dto.ResourceDTO;
import com.z.tech.rbac.dto.RoleResourceDTO;
import com.z.tech.rbac.enums.ResourceType;
import com.z.tech.rbac.service.ResourceService;
import com.z.tech.rbac.service.RoleResourceService;
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
public class T007_RoleResourcesTests {

    @Autowired
    private RoleResourceService roleResourceService;
    @Autowired
    private ResourceService resourceService;

    @Test
    public void createRoleResource() {
        RoleResourceDTO roleResource = new RoleResourceDTO();
        roleResource.setRoleId(3);
        roleResource.setResourceId(3);
        roleResourceService.save(roleResource);
    }

    @Test
    public void createRoleResources() {
        List<ResourceDTO> resources = resourceService.getByApplication(3,ResourceType.MENU.getCode());
        int roleId = 3;
        List<RoleResourceDTO> roleResources = new ArrayList<>(10);
        for (ResourceDTO resource : resources) {
            RoleResourceDTO roleResource = new RoleResourceDTO();
            roleResource.setRoleId(roleId);
            roleResource.setResourceId(resource.getId());
            roleResources.add(roleResource);
        }
        roleResourceService.save(roleResources);
    }


    @Test
    public void deleteByID() {
        int id = 2;
        roleResourceService.delete(id);
    }

    @Test
    public void deleteByResource() {
        int resourceId = 5;
        int affectRows = roleResourceService.deleteByResource(resourceId);
        System.out.println("affectRows:" + affectRows);
    }

    @Test
    public void deleteByRole() {
        int roleId = 3;
        int affectRows = roleResourceService.deleteByRole(roleId);
        System.out.println("affectRows:" + affectRows);
    }


    @Test
    public void selectByRole() {
        int roleId = 3;
        List<RoleResourceDTO> roleResources = roleResourceService.getByRole(roleId);
        System.out.println(roleResources);
    }

    @Test
    public void selectByUser() {
        int resourceId = 5;
        List<RoleResourceDTO> roleResources = roleResourceService.getByResource(resourceId);
        System.out.println(roleResources);
    }

    @Test
    public void searchOneRoleResource() {
        int id = 1;
        RoleResourceDTO roleResource = roleResourceService.getByID(id);
        System.out.println(roleResource);
    }

    @Test
    public void searchMultiRoleResource() {
        List<Integer> ids = new ArrayList<>(2);
        ids.add(1);
        ids.add(2);
        List<RoleResourceDTO> roleResources = roleResourceService.getByIDs(ids);
        System.out.println(roleResources);
    }


}
