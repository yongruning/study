package com.ly.springcloudconsumerdeptfeign.controller;

import com.ly.springcloud.pojo.Dept;
import com.ly.springcloudconsumerdeptfeign.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {
    //Feign面向接口编程

    //springcloud-api-feign 下的service
    @Autowired
    private DeptClientService deptClientService;

    //添加数据
    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return deptClientService.addDept(dept);
    }

    //通过id查询
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.queryById(id);
    }

    //查询所有
    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll() {
        return deptClientService.queryAll();
    }

    //查询所有
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
