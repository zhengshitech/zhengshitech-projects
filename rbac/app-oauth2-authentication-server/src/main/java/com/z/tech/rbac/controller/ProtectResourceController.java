package com.z.tech.rbac.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author H
 */
@RestController
@RequestMapping("/my")
public class ProtectResourceController {


    @RequestMapping(value = "/get_tag/{tag}", method = RequestMethod.GET)
    public String getTag(@PathVariable("tag") Integer tag) {
        switch (tag) {
            case 1:
                return "cute";
            case 2:
                return "lovely";
            case 3:
                return "high";
            default:
                return "NONE";
        }
    }


}
