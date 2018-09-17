package com.z.tech.rbac.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author H
 */
@RestController("/my")
public class MyController {
    // 添加一个测试访问接口
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Authentication getUser(Authentication authentication) {
        System.out.println("resource: user:" + authentication);
        return authentication;
    }

    @ResponseBody
    @RequestMapping(value = "/test/{msg}", method = RequestMethod.GET)
    public Map<String, Object> test(@PathVariable("msg") String msg) {
        System.err.println("receive msg:" + msg);
        Map<String, Object> map = new HashMap<>(2);
        map.put("receive msg", msg);
        map.put("echo msg", "hello " + msg);
        return map;
    }


}
