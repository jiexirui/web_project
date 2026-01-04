package com.itheima.tlias.service.impl;

import com.itheima.tlias.mapper.DeptMapper;
import com.itheima.tlias.pojo.Dept;
import com.itheima.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> queryDeptList() {
        return deptMapper.findAll();
    }
}
