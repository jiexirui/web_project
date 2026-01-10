package com.itheima.tlias.mapper;

import com.itheima.tlias.pojo.EmpExpr;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface EmpExprMapper {
    public void batchInsertEmpExpr(List<EmpExpr> empList);

    void deleteByEmpIds(List<Integer> empIds);
}
