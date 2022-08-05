package com.ly.springcloudconsumerdept80;

import com.ly.myrule.RuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = RuleConfig.class)
public class SpringcloudConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerDept80Application.class, args);
    }

}
