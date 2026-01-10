package com.itheima.tlias.service;

import com.itheima.tlias.pojo.PageBean;
import com.itheima.tlias.pojo.StatisticsData;
import com.itheima.tlias.pojo.Student;
import com.itheima.tlias.pojo.StudentQueryParam;

import java.util.List;
import java.util.Map;

public interface StudentService {
    PageBean queryStudentList(StudentQueryParam studentQueryParam);

    void update(Student student);

    void deleteById(Integer[] ids);

    void add(Student student);

    Student queryById(Integer id);

    void updateViolation(Integer id, Short score);

    List<Map<String, Object>> getStudentDegreeList();

    StatisticsData getStudentCountData();
}
