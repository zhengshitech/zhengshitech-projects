package com.z.tech.rbac.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author H
 */
@RestController
public class UserController {
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Authentication getUser(Authentication authentication) {
        System.out.println("resource: user:" + authentication);
        return authentication;
    }


}
