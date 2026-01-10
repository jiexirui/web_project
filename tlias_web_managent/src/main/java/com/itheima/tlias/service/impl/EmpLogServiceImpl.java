package com.itheima.tlias.service.impl;

import com.itheima.tlias.mapper.EmpLogMapper;
import com.itheima.tlias.pojo.EmpLog;
import com.itheima.tlias.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
