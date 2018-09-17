package com.z.tech.rbac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author H
 */
@RestController
@RequestMapping("/server")
public class ServerController {

    @RequestMapping(value = "/works",method = RequestMethod.GET)
    public String works(){
        return "It works";
    }

}
