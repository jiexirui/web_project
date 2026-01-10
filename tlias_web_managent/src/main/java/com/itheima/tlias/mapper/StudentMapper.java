package com.itheima.tlias.mapper;

import com.itheima.tlias.pojo.StatisticsData;
import com.itheima.tlias.pojo.Student;
import com.itheima.tlias.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> queryStudentList(StudentQueryParam studentQueryParam);

    void update(Student student);

    void deleteById(Integer[] ids);

    void add(Student student);

    @Select("select * from student left join clazz on student.clazz_id = clazz.id where student.id = #{id}")
    Student queryById(Integer id);

    @Update("update student set violation_count = violation_count + 1 ,violation_score = violation_score + #{score} where id = #{id}")
    void updateViolation(Integer id, Short score);

    List<Map<String, Object>> getStudentDegreeList();

    List<Map<String, Object>> getStudentCountData();
}
