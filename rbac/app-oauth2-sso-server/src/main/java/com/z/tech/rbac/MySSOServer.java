package com.z.tech.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author H
 */
@SpringBootApplication
@EnableOAuth2Sso
public class MySSOServer {
    public static void main(String[] args) {
        SpringApplication.run(MySSOServer.class, args);
    }

    @Bean
    @Order(0)
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

}
