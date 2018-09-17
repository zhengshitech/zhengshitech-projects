package com.z.tech.rbac.rbac;


import com.z.tech.rbac.ApplicationRBAC;
import com.z.tech.rbac.dto.ResourceDTO;
import com.z.tech.rbac.enums.ResourceType;
import com.z.tech.core.exception.BizCode;
import com.z.tech.core.exception.BizException;
import com.z.tech.rbac.service.ResourceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.z.tech.rbac.util.UUIDUtil.randomUUID;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApplicationRBAC.class)
@DirtiesContext
public class T006_ResourceTests {


    @Autowired
    private ResourceService resourceService;

    @Test
    public void createResource() {
        ResourceDTO resource = new ResourceDTO();
        resource.setName("测试资源");
        resource.setResourceKey(randomUUID().toUpperCase());
        resource.setApplicationId(3);
        resource.setType(ResourceType.MENU.getCode());
        resourceService.save(resource);
    }


    @Test
    public void resourceCodeExists() {

        String code = "C4734906BB07455EBC8E5CD97E2D2C34";
        boolean exists = resourceService.getByResourceKeyAndApplication(code, null, 3, ResourceType.MENU.getCode());
        Assert.assertTrue(exists);
    }

    @Test
    public void resourceCodeNotExists() {

        String code = "E2769E4E1D1C";
        boolean exists = resourceService.getByResourceKeyAndApplication(code, null, 3, ResourceType.MENU.getCode());
        Assert.assertFalse(exists);
    }

    @Test
    public void updateResource() {
        int id = 3;
        ResourceDTO resource = resourceService.getByID(id);
        if (null == resource) {
            throw new BizException(BizCode.OPERATION_DATA_NOT_EXIST);
        }
        resource.setName("资源名称modify");
        resourceService.modify(resource);
    }

    @Test
    public void deleteResource() {
        int id = 2;
        resourceService.delete(id);
    }

    @Test
    public void searchOneResource() {
        int id = 1;
        ResourceDTO resource = resourceService.getByID(id);
        System.out.println(resource);
    }

    @Test
    public void searchMultiResource() {
        List<Integer> ids = new ArrayList<>(2);
        ids.add(1);
        ids.add(2);
        List<ResourceDTO> resources = resourceService.getByIDs(ids);
        System.out.println(resources);
    }

}
