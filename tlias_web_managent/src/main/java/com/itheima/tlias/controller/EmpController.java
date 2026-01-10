package com.itheima.tlias.controller;

import com.itheima.tlias.pojo.*;
import com.itheima.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
@Slf4j
public class EmpController {
    @Autowired
    private EmpService empService;

//    //    @GetMapping
//    public Result list() {
//        List<Emp> empList = empService.queryEmpList();
//        return Result.success(empList);
//    }
//
//    @GetMapping("/page")
//    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
//        PageBean listByPage = empService.queryEmpListByPage(page, pageSize);
//        return Result.success(listByPage);
//    }

    //    @GetMapping("/pageNew")
    @GetMapping
    public Result pageNew(EmpQueryParam empQueryParam) {
//        PageBean listByPage = empService.queryEmpListByPageNew(page, pageSize);
        PageBean listByPage = empService.queryEmpListByPageNew(empQueryParam);
        log.info("接受参数:{}", empQueryParam);
        return Result.success(listByPage);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("保存员工:{}", emp);//{}：Slf4j 日志框架的参数占位符,值替换：运行时将 emp 对象替换到 {} 位置
        empService.save(emp);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工:{}", emp);
        empService.updateEmp(emp);
        return Result.success();
    }

//    @DeleteMapping
//    public Result deleteById(Integer[] ids) {
//        log.info("批量删除员工:{}", Arrays.toString(ids));
////        empService.deleteById(ids);
//        return Result.success();
//    }

    @DeleteMapping
    public Result deleteById(@RequestParam List<Integer> ids) {
        log.info("批量删除员工:{}", ids);
        empService.deleteById(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        Emp emp = empService.queryById(id);
        return Result.success(emp);
    }
}
