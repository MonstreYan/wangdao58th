package com.cskaoyan.jdbc._03crud;

import com.cskaoyan.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            //里面写入insert语句
            int rows = statement.executeUpdate("insert into student(id,name) values (null,'阿齐')");
            System.out.println(rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                JdbcUtil.close(connection, statement, null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
