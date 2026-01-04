package com.itheima.dao.impt;

import com.itheima.dao.DeptDao;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;

@Repository
public class DeptDaoImpt implements DeptDao {
    @Override
    public List<String> lines() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        return IOUtils.readLines(in, "UTF-8");
    }
}
