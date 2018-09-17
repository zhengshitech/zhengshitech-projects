package com.z.tech.rbac.rbac;


import com.z.tech.rbac.ApplicationRBAC;
import com.z.tech.rbac.dto.ApplicationDTO;
import com.z.tech.core.exception.BizCode;
import com.z.tech.core.exception.BizException;
import com.z.tech.rbac.service.ApplicationService;
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
public class T002_ApplicationRBACTests {

    @Autowired
    private ApplicationService applicationService;

    @Test
    public void createApplication() {
        ApplicationDTO application = new ApplicationDTO();
        application.setName("测试应用");
        applicationService.save(application);
    }


    @Test
    public void appKeyExists() {

        String key = "401C91C6C8934F25A0DAC3E7AFB77105";
        boolean exists = applicationService.getByAppKey(key,null);
        Assert.assertTrue(exists);
    }

    @Test
    public void appKeyNotExists() {

        String key = "13812345677";
        boolean exists = applicationService.getByAppKey(key,null);
        Assert.assertFalse(exists);
    }

    @Test
    public void updateApplication() {
        int id = 3;
        ApplicationDTO application = applicationService.getByID(id);
        if (null == application) {
            throw new BizException(BizCode.OPERATION_DATA_NOT_EXIST);
        }
        application.setName("应用名称modify");
        applicationService.modify(application);
    }

    @Test
    public void deleteApplication() {
        int id = 2;
        applicationService.delete(id);
    }

    @Test
    public void searchOneApplication() {
        int id = 1;
        ApplicationDTO application = applicationService.getByID(id);
        System.out.println(application);
    }

    @Test
    public void searchMultiApplication() {
        List<Integer> ids = new ArrayList<>(2);
        ids.add(1);
        ids.add(2);
        List<ApplicationDTO> applications = applicationService.getByIDs(ids);
        System.out.println(applications);
    }
}
