package com.itheima.tlias.service;

import com.itheima.tlias.pojo.Emp;
import com.itheima.tlias.pojo.EmpQueryParam;
import com.itheima.tlias.pojo.JobOption;
import com.itheima.tlias.pojo.PageBean;

import java.util.List;
import java.util.Map;

public interface EmpService {
//    List<Emp> queryEmpList();
//
//    PageBean queryEmpListByPage(Integer page, Integer pageSize);

    PageBean queryEmpListByPageNew(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void deleteById(List<Integer> ids);

    Emp queryById(Integer id);

    void updateEmp(Emp emp);

    JobOption getJobList();

    List<Map<String,Object>> getEmpGenderList();
}
