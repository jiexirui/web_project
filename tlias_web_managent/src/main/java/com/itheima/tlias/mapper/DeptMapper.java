package com.itheima.tlias.mapper;

import com.itheima.tlias.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from ")
    public List<Dept> findAll();
}
