package com.ly.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard//开启监控
public class SpringcloudConsumerHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerHystrixDashboardApplication.class, args);
    }

}
