package com.itheima.dao.impt;

import com.itheima.dao.LogDao;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;

@Repository
public class LogDaoImpt implements LogDao {
    @Override
    public List<String> lines() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("log.txt");
        return IOUtils.readLines(inputStream, "UTF-8");
    }

}
