package com.itheima;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserService1Test {
    private UserService userService;

    @BeforeEach
    void create() {
        userService = new UserService();
    }

    @Test
    void isBeijing() {
        boolean beijing = userService.isBeijing("110101199901011234");
        System.out.println(beijing?"北京":"非北京");
    }

    @Test
    void getAge() {
        int age = userService.getAge("110101199901011234");
        System.out.println("年龄 = " + age);
    }

    @Test
    void getGender() {
        String gender = userService.getGender("110101199901011234");
        System.out.println("性别 = " + gender);
    }

    @Test
    void getYear() {
        String year = userService.getYear("110101199901011234");
        System.out.println("出生年份 = " + year);
    }

    @Test
    void getMonth() {
        String month = userService.getMonth("110101199901011234");
        System.out.println("出生月份 = " + month);
    }
}