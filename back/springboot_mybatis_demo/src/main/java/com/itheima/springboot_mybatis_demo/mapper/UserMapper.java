package com.itheima.springboot_mybatis_demo.mapper;

import com.itheima.springboot_mybatis_demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {

//    @Select("select * from emp")
    public List<User> findAll();
}
