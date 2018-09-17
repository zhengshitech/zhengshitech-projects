package com.z.tech.rbac.rbac;


import com.z.tech.rbac.ApplicationRBAC;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = TenantController.class, secure = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApplicationRBAC.class)

public class T001_MockTenantTests {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();  //构造MockMvc
        System.out.println("构造MockMvc 完成");
    }


    @Test
    public void addTenant() throws Exception {

        String postJSON = "{  \"name\": \"mockTenant租户测试\",  \"pid\": \"5\"}";

        RequestBuilder request = post("/tenant/add")
                .accept(MediaType.APPLICATION_JSON)
                .content(postJSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultActions perform = mvc.perform(request);
        MvcResult mvcResult = perform.andReturn();
        perform.andExpect(status().isOk());
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getTenant() throws Exception {

//        when(tenantService.getByID(7)).thenReturn(new TenantDTO());

        RequestBuilder request = get("/tenant/get/7")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mvc.perform(request).andReturn();
        System.err.println("content is : " + mvcResult.getResponse().getContentAsString());
//        mvcResult
//                .andExpect(status().isOk())
//                .andExpect(content().string(contains("\"mask\": \"005_001\"")));

    }


}
