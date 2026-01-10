package com.itheima.tlias.mapper;

import com.itheima.tlias.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Mapper注解：
 * 接口映射：标记数据访问层接口，使其能够被 Spring 框架识别和管理
 * SQL 映射：将接口方法与 SQL 语句进行映射关联
 */

@Mapper
public interface DeptMapper {
    @Select("select * from tlias.dept")
    public List<Dept> findAll();

    @Delete("delete from tlias.dept where tlias.dept.id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into tlias.dept (name,create_time,update_time)values (#{name},#{createTime},#{updateTime})")
    public void save(Dept dept);

    @Select("select * from tlias.dept where tlias.dept.id = #{id}")
    public Dept getById(Integer id);

//    @Update("update tlias.dept set name = #{name},update_time = #{updateTime} where tlias.dept.id = #{id}")
    public void update(Dept dept);
}
