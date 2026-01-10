package com.itheima.tlias.controller;

import com.itheima.tlias.pojo.JobOption;
import com.itheima.tlias.pojo.Result;
import com.itheima.tlias.pojo.StatisticsData;
import com.itheima.tlias.service.EmpService;
import com.itheima.tlias.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    private EmpService empService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/empJobData")
    public Result getEmpJobList() {
        JobOption jobOption = empService.getJobList();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderList() {
        List<Map<String, Object>> genderList = empService.getEmpGenderList();
        return Result.success(genderList);
    }

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeList() {
        List<Map<String, Object>> degreeList = studentService.getStudentDegreeList();
        return Result.success(degreeList);
    }

    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        StatisticsData statisticsData = studentService.getStudentCountData();
        return Result.success(statisticsData);
    }
}
