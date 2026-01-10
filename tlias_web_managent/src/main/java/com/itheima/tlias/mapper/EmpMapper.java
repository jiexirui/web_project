package com.itheima.tlias.mapper;

import com.itheima.tlias.pojo.Emp;
import com.itheima.tlias.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
/*

    @Select("select emp.*,dept.name as deptName from emp,dept where emp.dept_id = dept.id ")
    List<Emp> queryEmpList();

    */
/**
 * 原始方法分页查询
 * 查询总记录数
 *//*

    @Select("select count(*) as deptName from emp,dept where emp.dept_id = dept.id ")
    Long count();

    */
/**
 * 原始方法分页查询
 * 分页查询
 *//*

    @Select("select emp.*,dept.name as deptName from emp,dept where emp.dept_id = dept.id limit #{startIndex},#{pageSize}")
    List<Emp> queryEmpListByPage(Integer startIndex, Integer pageSize);
*/


    /**
     * PageHelper 分页插件进行分页查询
     */
//    @Select("select emp.*,dept.name as deptName from emp,dept where emp.dept_id = dept.id")
    List<Emp> queryEmpListByPageNew(EmpQueryParam empQueryParam);

    /**
     * useGeneratedKeys = true：启用数据库自动生成主键
     * keyColumn = "id"：指定数据库主键列名为"id"
     * keyProperty = "id"：指定实体类中接收主键值的属性为"id"
     * 插入数据后，自动生成的主键值会自动赋值给实体对象的id属性。
     */
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
//    这段代码是MyBatis框架的注解配置，用于数据库插入操作。当执行INSERT语句后，数据库自动生成的主键值会自动回填到实体对象的id属性中，无需手动获取或设置主键值。
    @Insert("insert into emp (username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);


    void deleteByIds(List<Integer> ids);

    public Emp queryById(Integer id);

    void updateById(Emp emp);

    List<Map<String, Object>> getJobList();

    List<Map<String, Object>> getEmpGenderList();
}
