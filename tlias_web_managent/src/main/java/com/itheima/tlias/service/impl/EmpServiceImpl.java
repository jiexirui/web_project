package com.itheima.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.tlias.mapper.EmpExprMapper;
import com.itheima.tlias.mapper.EmpMapper;
import com.itheima.tlias.pojo.*;
import com.itheima.tlias.service.EmpLogService;
import com.itheima.tlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;
/*

    @Override
    public List<Emp> queryEmpList() {
        return empMapper.queryEmpList();
    }

    @Override
    public PageBean queryEmpListByPage(Integer page, Integer pageSize) {
        Long tolal = empMapper.count();
        List<Emp> rows = empMapper.queryEmpListByPage((page - 1) * pageSize, pageSize);
        return new PageBean(tolal, rows);
    }
*/

    @Override
    public PageBean queryEmpListByPageNew(EmpQueryParam empQueryParam) {
        // 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 封装结果
        Page<Emp> pageList = (Page<Emp>) empMapper.queryEmpListByPageNew(empQueryParam);
        ;// 强转
        return new PageBean(pageList.getTotal(), pageList.getResult());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)// 开启事务
    public void save(Emp emp) {
        //保存员工基本信息
        try {
            emp.setUpdateTime(LocalDateTime.now());// 设置更新时间
            emp.setCreateTime(LocalDateTime.now());// 设置创建时间
            log.info("获得Id值前---{}", emp.getId());
            empMapper.save(emp);
            log.info("获得Id值后---{}：", emp.getId());


            //保存员工工作经历信息
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();//从员工对象中获取员工履历列表
            // 如果员工表达式列表不为空，则为每个表达式设置员工ID并批量插入
            if (!CollectionUtils.isEmpty(exprList)) {//Spring的 CollectionUtils.isEmpty() 方法 判断履历列表不为空才执行后续操作
                //为每条履历记录设置员工ID，建立外键关联
                for (EmpExpr expr : exprList) {
                    expr.setEmpId(empId);
                }
                empExprMapper.batchInsertEmpExpr(exprList);//用 EmpExprMapper 执行履历批量插入
            }
        } finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), emp.toString());
            empLogService.insertLog(empLog);
        }

    }

    @Override
    @Transactional// 开启事务
    public void deleteById(List<Integer> ids) {
        //删除员工基本信息
        empMapper.deleteByIds(ids);
        //删除员工工作经历信息
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp queryById(Integer id) {
//        密码脱敏
        Emp emp = empMapper.queryById(id);
        emp.setPassword(null);
        return emp;
    }

    @Override
    @Transactional
    public void updateEmp(Emp emp) {
        //更新员工基本信息
        empMapper.updateById(emp);
        //更新员工工作经历信息
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));//删除员工所有工作经历
        //新增员工工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            for (EmpExpr expr : exprList) {
                expr.setEmpId(emp.getId());
            }
            empExprMapper.batchInsertEmpExpr(exprList);
        }
    }

    @Override
    public JobOption getJobList() {
        List<Map<String, Object>> list = empMapper.getJobList();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderList() {
        List<Map<String, Object>> genderList = empMapper.getEmpGenderList();
        return genderList;
    }
}
