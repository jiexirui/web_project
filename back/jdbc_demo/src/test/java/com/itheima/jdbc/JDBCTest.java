package com.itheima.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JDBCTest {

    @Test
    public void testUpdate() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");// 加载驱动
        String url = "jdbc:mysql://localhost:3306/db_heima";// 数据库连接地址
        Connection connection = DriverManager.getConnection(url, "root", "root");
//        获取SQL执行对象,创建Statement对象
        Statement statement = connection.createStatement();
//        执行SQL
        int sql = statement.executeUpdate("update t_user set username = 'admin' where id = 1;");// 返回受影响的行数
        System.out.println(sql);
//
//        ResultSet resultSet = statement.executeQuery("select * from emp;");
//
//        while (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String username = resultSet.getString("username");
//            int password = resultSet.getInt("password");
//            System.out.println(id + " " + username + " " + password);
//        }

        // 修复前的代码存在SQL语法错误和SQL注入风险
        // 原代码: ResultSet resultSet = statement1.executeQuery("select * from emp where = '" + username + "'and password = '" + password + "'");
        
        // 修复后的代码 - 使用正确的SQL语法，但仍然存在SQL注入风险
        // 在实际项目中，应该使用PreparedStatement来防止SQL注入
        Statement statement1 = connection.createStatement();
        String username = "admin";
        String password = "'or'1'='1";
        // 修复SQL语法错误: 添加字段名
        ResultSet resultSet = statement1.executeQuery("select * from emp where username = '" + username + "' and password = '" + password + "'");
        System.out.println(resultSet.next());
        
        // 关闭ResultSet资源
        resultSet.close();
        statement1.close();

//        释放资源
        statement.close();
        connection.close();
    }
}
