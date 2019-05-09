package com.atwyl.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorldController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){

        return "helloWorld";
    }

    //查出用户数据，在页面显示
    @RequestMapping("/success")
    public String success(Model model){
//        map.put("hello","<h1>你好</h1>");
//        map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));

        model.addAttribute("hello","<h1>你好</h1>");
        model.addAttribute("users",Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
