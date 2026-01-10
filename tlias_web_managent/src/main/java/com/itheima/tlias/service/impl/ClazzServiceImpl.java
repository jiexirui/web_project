package com.itheima.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.tlias.mapper.ClazzMapper;
import com.itheima.tlias.pojo.Clazz;
import com.itheima.tlias.pojo.ClazzQueryParam;
import com.itheima.tlias.pojo.PageBean;
import com.itheima.tlias.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public List<Clazz> queryClazzList() {
        return clazzMapper.findAll();
    }

    @Override
    public PageBean queryClazzListByPage(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());// 设置分页参数
        List<Clazz> queryList = clazzMapper.queryClazzListByPage(clazzQueryParam);// 查询
        Page<Clazz> list = (Page<Clazz>) queryList;// 强转

        list.forEach(clazz -> {
            if (LocalDate.now().isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
            } else if (LocalDate.now().isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结课");
            } else {
                clazz.setStatus("在读");
            }
        });
        return new PageBean(list.getTotal(), list.getResult());// 封装结果list.getTotal()获取总记录数，list.getResult()获取当前页的数据列表
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void add(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazz.setCreateTime(LocalDateTime.now());
        clazzMapper.add(clazz);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }
}
