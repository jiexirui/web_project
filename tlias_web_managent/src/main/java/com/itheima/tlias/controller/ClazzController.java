package com.itheima.tlias.controller;

import com.itheima.tlias.pojo.Clazz;
import com.itheima.tlias.pojo.ClazzQueryParam;
import com.itheima.tlias.pojo.PageBean;
import com.itheima.tlias.pojo.Result;
import com.itheima.tlias.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @GetMapping("/list")
    public Result list() {
        List<Clazz> clazzList = clazzService.queryClazzList();
        return Result.success(clazzList);
    }

    @GetMapping
    public Result list(ClazzQueryParam clazzQueryParam) {
        PageBean pageBean = clazzService.queryClazzListByPage(clazzQueryParam);
        return Result.success(pageBean);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        clazzService.add(clazz);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        clazzService.update(clazz);
        return Result.success();
    }
}
