package com.itheima.tlias.mapper;

import com.itheima.tlias.pojo.Clazz;
import com.itheima.tlias.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {
    @Select("select clazz.*,emp.name as master_name from tlias.clazz inner join emp on clazz.master_id = emp.id")
    List<Clazz> findAll();

    List<Clazz> queryClazzListByPage(ClazzQueryParam clazzQueryParam);

    @Select("select * from tlias.clazz where tlias.clazz.id = #{id}")
    Clazz getById(Integer id);

    @Delete("delete from tlias.clazz where tlias.clazz.id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into tlias.clazz(id, name, room, begin_date, end_date, master_id, subject, create_time, update_time) values(null,#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},#{createTime},#{updateTime})")
    void add(Clazz clazz);

//    @Update("update tlias.clazz set name = #{name}, room = #{room}, begin_date = #{beginDate}, end_date = #{endDate}, master_id = #{masterId}, subject = #{subject}, update_time = #{updateTime} where id = #{id}")
    void update(Clazz clazz);

}
