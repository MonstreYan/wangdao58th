package com.cskaoyan.jdbc._05batch;

import com.cskaoyan.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchPreparedStatementDemo {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement("insert into user values (null, ?, ?)");
            for (int i = 1; i < 1000; i++) {
                //填充，一次性发车
                preparedStatement.setString(1, "username" + i);
                preparedStatement.setString(2, "password" + i);
                //把这些参数填充到缓冲区中
                preparedStatement.addBatch();
                if(i % 200 == 0){
                    //运送到数据库去执行
                    preparedStatement.executeBatch();
                    //清空一次缓冲区
                    preparedStatement.clearBatch();
                }
            }
            //801-999数据没有装车，需要再发一次车
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                JdbcUtil.close(connection, preparedStatement, null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
