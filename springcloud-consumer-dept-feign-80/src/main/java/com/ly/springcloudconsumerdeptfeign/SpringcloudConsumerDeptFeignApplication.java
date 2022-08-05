package com.ly.springcloudconsumerdeptfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ly.springcloudconsumerdeptfeign.service"})
public class SpringcloudConsumerDeptFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerDeptFeignApplication.class, args);
    }

}
