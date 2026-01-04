package com.itheima.tlias.controller;

import com.itheima.tlias.pojo.Dept;
import com.itheima.tlias.pojo.Result;
import com.itheima.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() throws IOException {
        List<Dept> deptList = deptService.queryDeptList();
        return Result.success(deptList);
    }

    @GetMapping("/getString")
    public Result getString() {
        return Result.success("hello");
    }

//    @GetMapping("/getObj")
//    public Result getObj() {
//        return Result.success(new Dept(1, "开发部", LocalDateTime.now(), LocalDateTime.now()));
//    }
}
