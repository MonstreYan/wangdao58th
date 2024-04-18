package com.cskaoyan.jdbc._03crud;

import com.cskaoyan.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            int i = statement.executeUpdate("update student set name='kongling' where id = 6");
            System.out.println(i);
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
