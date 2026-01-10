package com.itheima.tlias.service;

import com.itheima.tlias.pojo.Dept;

import java.io.IOException;
import java.util.List;

public interface DeptService {
    // 查询所有的部门数据
    List<Dept> queryDeptList() throws IOException;

    void deleteById(Integer id);

    void save(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
