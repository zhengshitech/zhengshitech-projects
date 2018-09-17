package com.z.tech.rbac.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author H
 */
@RestController
public class TestController {


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        System.out.println("resource: user:" + principal);
        return principal;
    }


    @ResponseBody
    @RequestMapping(value = "/myprivateapi/{msg}", method = RequestMethod.GET)
    public String myprivateapi(@PathVariable("msg") String msg) {
        System.err.println("my private api receive msg:" + msg);

        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "private api ### hello " + msg;
    }


    @ResponseBody
    @RequestMapping(value = "/mypublicapi/{msg}", method = RequestMethod.GET)
    public String mypublicapi(@PathVariable("msg") String msg) {
        System.err.println("my public api receive msg:" + msg);

        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "public api ### hello " + msg;
    }


}
