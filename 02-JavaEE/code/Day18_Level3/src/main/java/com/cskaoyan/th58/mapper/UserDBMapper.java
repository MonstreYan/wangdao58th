package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 11:36
 * @Version 1.0
 */
public class UserDBMapper implements UserMapper{
    public Integer register(User user) {
        //今天暂时先不去整合mybatis jdbc
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tx?characterEncoding=utf-8&useSSL=false", "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user values (null, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
            return 200;
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
        return 404;
    }
}
