package com.z.tech.rbac.controller;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.z.tech.rbac.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/")
public class TestController {

    @Autowired
    private UserClient userClient;

    @RequestMapping(method = RequestMethod.GET, value = "testUserClient")
    public String testUserClient() {
        try {
            return userClient.works();
        } catch (HystrixRuntimeException e) {
            e.printStackTrace();
            Throwable fallbackException = e.getFallbackException();
            String message1 = fallbackException.getCause().getMessage();
            String message = fallbackException.getMessage();
            System.out.println(message);
            System.out.println(message1);
            return message1;
        }
    }


}
