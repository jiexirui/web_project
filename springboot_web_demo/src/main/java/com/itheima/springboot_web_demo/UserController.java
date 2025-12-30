package com.itheima.springboot_web_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/user")
    public String hello(String gender){
        System.out.println("gender = " + gender);
        return "Hello User";
    }
}
