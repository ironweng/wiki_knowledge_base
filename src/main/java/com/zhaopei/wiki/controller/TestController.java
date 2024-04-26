package com.zhaopei.wiki.controller;

import com.zhaopei.wiki.entity.Test;
import com.zhaopei.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World2";
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
