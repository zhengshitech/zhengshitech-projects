package com.z.tech.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author H
 */
@SpringBootApplication
@EnableResourceServer
public class MyResourceServer {


    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }


    public static void main(String[] args) {
        SpringApplication.run(MyResourceServer.class, args);
    }



}
