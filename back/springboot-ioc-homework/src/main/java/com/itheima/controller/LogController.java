package com.itheima.controller;

import com.itheima.pojo.Log;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.LogService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping("/log/page")
    private Result list() {
        List<Log> logList = logService.logList();
        return Result.success(new PageBean(10L,logList));//10L是每页显示的条数//logList是日志列表
    }

}
