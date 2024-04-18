package com.cskaoyan.jdbc._03crud;

import com.cskaoyan.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDemo {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            int rows = statement.executeUpdate("delete from student where id = 7");
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
