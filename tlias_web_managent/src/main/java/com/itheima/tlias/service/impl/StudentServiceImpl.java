package com.itheima.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.tlias.mapper.StudentMapper;
import com.itheima.tlias.pojo.*;
import com.itheima.tlias.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageBean queryStudentList(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());//使用PageHelper插件设置分页参数，包括当前页码和每页大小
        List<Student> students = studentMapper.queryStudentList(studentQueryParam);//调用Mapper层执行数据库查询，返回学生列表
        Page<Student> stu = (Page<Student>) students;//将查询结果强制转换为Page类型，因为PageHelper会在查询时自动分页并增强结果集
        return new PageBean(stu.getTotal(), stu.getResult());//创建PageBean对象，将总记录数和当前页数据封装返回
    }

    @Override
    public void update(Student student) {
        student.setCreateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void deleteById(Integer[] ids) {
        studentMapper.deleteById(ids);
    }

    @Override
    public void add(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        studentMapper.add(student);
    }

    @Override
    public Student queryById(Integer id) {
        return studentMapper.queryById(id);
    }

    @Override
    public void updateViolation(Integer id, Short score) {
        studentMapper.updateViolation(id, score);
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeList() {
        return studentMapper.getStudentDegreeList();
    }

    @Override
    public StatisticsData getStudentCountData() {
        List<Map<String, Object>> studentCountData = studentMapper.getStudentCountData();
        List<Object> clazzList = studentCountData.stream().filter(dataMap -> dataMap.get("clazzList") != null).map(dataMap -> dataMap.get("clazzList")).toList();
        List<Object> dataList = studentCountData.stream().filter(dataMap -> dataMap.get("dataList") != null).map(dataMap -> dataMap.get("dataList")).toList();
        return new StatisticsData(clazzList, dataList);
    }
}
