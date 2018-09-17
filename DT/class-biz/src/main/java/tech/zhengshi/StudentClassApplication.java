package tech.zhengshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author H
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
public class StudentClassApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentClassApplication.class, args);
    }
}
