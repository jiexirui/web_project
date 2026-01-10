package com.itheima.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 *  分页查询
 */
public class PageBean {
    private long total;//总记录数
    private List rows;//数据行
}
