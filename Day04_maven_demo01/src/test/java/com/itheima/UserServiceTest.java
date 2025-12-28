package com.itheima;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void create() {
        userService = new UserService();
        System.out.println("userService = " + userService);
    }

    @Test
    void getAge() {
        Integer age = userService.getAge("420101199901011234");
        System.out.println("age = " + age);
    }

    @DisplayName("测试获取性别")
    @ParameterizedTest
    @ValueSource(strings = {"420101199901011234", "420101199901011235"})
    void getGender(String cardId) {
        String gender = userService.getGender(cardId);
        Assertions.assertEquals("女",gender,"预期不符");
        System.out.println("gender = " + gender);
    }

    @AfterEach
    void destroy() {
        System.out.println("修饰实例方法，每个测试方法执行后执行一次");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("所有测试执行完毕");
    }

    @BeforeAll
    static void BeforeAll() {
        System.out.println("修饰静态方法，所有测试方法前只执行一次");
    }
    

}