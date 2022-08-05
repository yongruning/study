package com.ly.springcloud.controller;

import com.ly.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    // 理解：消费者，不该有service层
    // RestTemplate.. 里面有方法供我们调用即可，注册到spring中
    //(String url,实体, Class<T> responseType)

    //提供多种便捷访问远程http服务的方法，简单的Restful服务模板
    @Autowired
    private RestTemplate restTemplate;

    //声明提供者的localhost路径
//    private static final String rest_url_prefix = "http://localhost:8001";
    private static final String rest_url_prefix = "http://SPRINGCLOUD-PROVIDER-DEPT";

    //调用8001提供者的控制器=>根据id查询数据
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        // restTemplate.注意和提供者的getmapping或postmapping保持一致
        return restTemplate.getForObject(rest_url_prefix + "/dept/get/" + id, Dept.class);
    }

    //调用8001提供者的控制器=>添加方法
    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept) {
        // restTemplate.注意和提供者的getmapping或postmapping保持一致
        return restTemplate.postForObject(rest_url_prefix + "/dept/add", dept, Boolean.class);
    }

    //调用8001提供者的控制器=>查询所有
    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryall() {
        // restTemplate.注意和提供者的getmapping或postmapping保持一致
        return restTemplate.getForObject(rest_url_prefix + "/dept/list", List.class);
    }
}
