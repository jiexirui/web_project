package com.itheima.tlias.controller;

import com.itheima.tlias.pojo.PageBean;
import com.itheima.tlias.pojo.Result;
import com.itheima.tlias.pojo.Student;
import com.itheima.tlias.pojo.StudentQueryParam;
import com.itheima.tlias.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result list(StudentQueryParam studentQueryParam) {
        PageBean studentList = studentService.queryStudentList(studentQueryParam);
        return Result.success(studentList);
    }

    @PutMapping
    public Result update(Student student) {
        studentService.update(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable Integer[] ids) {
        log.info("批量删除员工:{}", ids);
        studentService.deleteById(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Student student) {
        studentService.add(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        Student student = studentService.queryById(id);
        return Result.success(student);
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id, @PathVariable Short score) {
        studentService.updateViolation(id, score);
        return Result.success();
    }
}
