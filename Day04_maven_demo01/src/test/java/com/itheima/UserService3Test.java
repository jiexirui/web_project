package com.itheima;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserService3Test {
    private UserService userService;

    @BeforeEach
    void create() {
        userService = new UserService();
    }

    @Test
    void isBeijing() {
        boolean beijing = userService.isBeijing("110101199901011234");
        Assertions.assertTrue(beijing, "北京的测试用例未通过");
        System.out.println(beijing ? "北京人" : "非北京人");
    }

    @Test
    void getAge() {
        int age = userService.getAge("110101199901011234");
        Assertions.assertNotNull(age, "年龄的测试用例未通过");
        System.out.println("年龄 = " + age);
    }

    @Test
    void getGender() {
        String gender = userService.getGender("110101199901011234");
        Assertions.assertNotNull(gender, "性别的测试用例未通过");
        System.out.println("性别 = " + gender);
    }

    @Test
    void getYear() {
        String year = userService.getYear("110101199901011234");
        Assertions.assertNotNull(year, "出生年份的测试用例未通过");
        System.out.println("出生年份 = " + year);
    }

    @Test
    void getMonth() {
        String month = userService.getMonth("110101199901011234");
        Assertions.assertNotNull(month, "出生月份的测试用例未通过");
        System.out.println("出生月份 = " + month);
    }
}