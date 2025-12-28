package com.itheima;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserService2Test {
    private UserService userService;

    @BeforeEach
    void create() {
        userService = new UserService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231","110110201509091109","510310198812120931"})
    void isBeijing(String idcard) {
        boolean beijing = userService.isBeijing(idcard);
        System.out.println(beijing?"北京":"非北京");
    }

    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231","110110201509091109","510310198812120931"})
    void getAge(String idcard) {
        Integer age = userService.getAge(idcard);
        System.out.println("年龄 = " + age);
    }

    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231","110110201509091109","510310198812120931"})
    void getGender(String idcard) {
        String gender = userService.getGender(idcard);
        System.out.println("性别 = " + gender);
    }

    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231","110110201509091109","510310198812120931"})
    void getYear(String idcard) {
        String year = userService.getYear(idcard);
        System.out.println("出生年份 = " + year);
    }

    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231","110110201509091109","510310198812120931"})
    void getMonth(String idcard) {
        String month = userService.getMonth(idcard);
        System.out.println("出生月份 = " + month);
    }
}