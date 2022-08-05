package com.ly.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自定义Ribbon配置的负载均衡类，客户端RibbonConfiguration中已存在的组件与FooConfiguration中的任何组件组成（后者通常会覆盖前者）
//自定义的组件请注意 它不在|程序的上下文的ComponentScan中，所以要放在单独的不重叠的包中
@Configuration
public class RuleConfig {
    @Bean
    public IRule myRule() {
        //默认是轮询，现在我们自定义为DiyRandomRule 自定义负载均衡
        return new DiyRandomRule();
    }
}
