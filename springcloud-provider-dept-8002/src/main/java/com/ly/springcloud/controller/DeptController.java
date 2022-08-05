package com.ly.springcloud.controller;

import com.ly.springcloud.pojo.Dept;
import com.ly.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供Restful服务
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService2;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService2.addDept(dept);
    }

    @RequestMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id) {
        return deptService2.queryById(id);
    }

    @RequestMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService2.queryAll();
    }
}