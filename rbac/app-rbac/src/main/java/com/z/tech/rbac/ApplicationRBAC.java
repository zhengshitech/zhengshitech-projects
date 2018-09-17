package com.z.tech.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author H
 */
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients({"com.z.tech.rbac.client"})
@EnableDiscoveryClient
public class ApplicationRBAC {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRBAC.class, args);
    }
}
