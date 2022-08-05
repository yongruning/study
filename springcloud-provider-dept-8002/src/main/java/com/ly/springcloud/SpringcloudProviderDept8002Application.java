package com.ly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudProviderDept8002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderDept8002Application.class, args);
    }

}
