package com.z.tech.rbac.controller;

import com.z.tech.rbac.api.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.z.tech.rbac.api.UserService.USER_WEB_API;

@RestController
@RequestMapping(USER_WEB_API)
public class UserController implements UserService {
    @Override
    public String works() {
        return "test user api";
    }
}
