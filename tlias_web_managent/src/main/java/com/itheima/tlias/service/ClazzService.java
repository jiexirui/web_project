package com.itheima.tlias.service;

import com.itheima.tlias.pojo.Clazz;
import com.itheima.tlias.pojo.ClazzQueryParam;
import com.itheima.tlias.pojo.PageBean;

import java.util.List;

public interface ClazzService {
    List<Clazz> queryClazzList();

    PageBean queryClazzListByPage(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void add(Clazz clazz);

    void update(Clazz clazz);

    Clazz getById(Integer id);

}
