package tech.zhengshi.td;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author H
 */
@SpringBootApplication(scanBasePackages = {"tech.zhengshi"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"tech.zhengshi.student.webapi", "tech.zhengshi.clazz.webapi"})
public class DTApplication {

    public static void main(String[] args) {
        SpringApplication.run(DTApplication.class, args);
    }
}
