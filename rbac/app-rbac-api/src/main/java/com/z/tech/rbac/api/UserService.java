package com.z.tech.rbac.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.z.tech.rbac.api.AppDefinition.MY_API_PREFIX;

public interface UserService {

    String USER_WEB_API = MY_API_PREFIX +"user/";

    @RequestMapping(value = "/testUserApi", method = RequestMethod.GET)
    String works();
}
