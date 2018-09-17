package com.z.tech.rbac.rbac;


import com.z.tech.rbac.ApplicationRBAC;
import com.z.tech.rbac.dto.TenantDTO;
import com.z.tech.rbac.service.TenantService;
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
public class T001_TenantTests {
    @Autowired
    private TenantService tenantService;

    @Test
    public void createTenant() {
        mockATenantAndSave("测试租户", TREE_ROOT_PID);
    }


    @Test
    public void createChildTenant() {

        mockATenantAndSave("测试5子租户添加", 5);
        mockATenantAndSave("测试5子租户添加", 5);
        mockATenantAndSave("测试8子租户添加", 8);
        mockATenantAndSave("测试9子租户添加", 9);
    }

    private void mockATenantAndSave(String tenantName, int pid) {
        TenantDTO newTenant = new TenantDTO();
        newTenant.setName(tenantName);
        newTenant.setPid(pid);
        tenantService.save(newTenant);
    }


    @Test
    public void validateTenantNameLength_128() {

        mockATenantAndSave(chinese128, TREE_ROOT_PID);
    }

    @Test
    public void validateTenantNameLength_129() {

        TenantDTO newTenant = new TenantDTO();
        newTenant.setName(chinese129);
        boolean lengthIsError = true;
        try {
            tenantService.save(newTenant);
            lengthIsError = false;
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(lengthIsError);
    }

    @Test
    public void updateTenant() {
        int id = 1;
        TenantDTO tenant = tenantService.getByID(id);
        tenant.setName(tenant.getName() + "modify");
        tenantService.modify(tenant);
    }

    @Test
    public void deleteTenant() {
        int id = 2;
        tenantService.delete(id);
    }

    @Test
    public void searchOneTenant() {
        int id = 1;
        TenantDTO tenant = tenantService.getByID(id);
        System.out.println(tenant);
    }

    @Test
    public void searchMultiTenant() {
        List<Integer> ids = new ArrayList<>(2);
        ids.add(1);
        ids.add(2);
        List<TenantDTO> tenants = tenantService.getByIDs(ids);
        System.out.println(tenants);
    }


}
