package com.itheima.springboot_web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// 表示当前类是一个控制器类
public class HelloController {
    @RequestMapping("/hello")//请求路径
    public String hello(String name) {
        System.out.println("HelloController:" + name);
        return "hello" + name + "~";
    }
}
