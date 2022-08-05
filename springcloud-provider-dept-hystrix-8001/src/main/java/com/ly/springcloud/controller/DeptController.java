package com.ly.springcloud.controller;

import com.ly.springcloud.pojo.Dept;
import com.ly.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供Restful服务
@RestController
public class DeptController{
    @Autowired
    private DeptService deptService;

    @RequestMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")  //如果失败 去调用Hystrix的备选方案
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept==null){//如果当前id值为空 抛出异常
            throw new RuntimeException("id=> "+ id+"不存在该用户,或者该信息无法找到");
        }
        return dept;
    }

    //如果出现异常 采取Hystrix的备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=> "+id+"没有找到相关信息,null by Hystrix")
                .setDb_source("not found database in mysql");
    }
}
