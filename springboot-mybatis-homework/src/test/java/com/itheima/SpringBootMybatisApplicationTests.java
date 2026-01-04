package com.itheima;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootMybatisApplicationTests {
    @Autowired
    private DeptMapper deptMapper;
    @Test
    void contextLoads() {
        System.out.println(deptMapper.findAll());
        for (Dept dept : deptMapper.findAll()){
            System.out.println(dept);
        }
    }

}
