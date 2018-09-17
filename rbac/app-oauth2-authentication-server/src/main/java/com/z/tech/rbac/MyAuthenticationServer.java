package com.z.tech.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author H
 */
@SpringBootApplication
@EnableAuthorizationServer
public class MyAuthenticationServer {
    public static void main(String[] args) {
        SpringApplication.run(MyAuthenticationServer.class, args);
    }
}
