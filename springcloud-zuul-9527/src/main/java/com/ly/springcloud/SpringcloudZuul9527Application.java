package com.ly.springcloud;

import com.ly.springcloud.component.RateLimitFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SpringcloudZuul9527Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuul9527Application.class, args);
    }

    // 实例化rateLimitFilter,否则网管不生效
    @Bean
    RateLimitFilter tokenFilter(){
        return new RateLimitFilter();
    }
}
