package com.itheima.day09word;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

@SpringBootTest
class Day09wordApplicationTests {

    @Test
    void contextLoads() throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/web01";
        Connection connection = DriverManager.getConnection(url, "root", "root@1234");

        // 预编译SQL
        PreparedStatement ps = connection.prepareStatement("update emp set password = ? , name = ?, age = ? where id = ? ;");
        ps.setString(1, "666888");
        ps.setString(2, "关羽");
        ps.setInt(3, 32);
        ps.setInt(4, 4);

// 执行查询
        int resultSet = ps.executeUpdate();
        System.out.println(resultSet);

        PreparedStatement preparedStatement = connection.prepareStatement("select id,username,password,name,age from emp where age >= ? and id <= ? ;");
        preparedStatement.setInt(1, 20);
        preparedStatement.setInt(2, 4);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        while (resultSet1.next()) {
            int id = resultSet1.getInt("id");
            String username = resultSet1.getString("username");
            String password = resultSet1.getString("password");
            String name = resultSet1.getString("name");
            int age = resultSet1.getInt("age");
            System.out.println(id + " " + username + " " + password + " " + name + " " + age);
        }
    }
}
