package com.itheima.springboot_mybatis_demo;

import com.itheima.springboot_mybatis_demo.mapper.UserMapper;
import com.itheima.springboot_mybatis_demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.findAll();
        System.out.println(users);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
