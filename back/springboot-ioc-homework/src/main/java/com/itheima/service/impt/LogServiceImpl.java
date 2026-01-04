package com.itheima.service.impt;

import com.itheima.dao.LogDao;
import com.itheima.pojo.Log;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.LogService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public List<Log> logList() {
        List<String> lines = logDao.lines();
        //2. 对原始数据进行处理 , 组装日志数据
        List<Log> logList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Log log = new Log(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
            return log;
        }).collect(Collectors.toList());

        //3. 返回日志列表
        return logList;
    }
}
