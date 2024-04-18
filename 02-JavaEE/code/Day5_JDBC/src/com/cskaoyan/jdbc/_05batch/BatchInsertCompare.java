package com.cskaoyan.jdbc._05batch;

import com.cskaoyan.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchInsertCompare {

    public static void main(String[] args) throws SQLException {
        //为了去评估各自的时间，打印一些当前的时间点
        Connection connection = JdbcUtil.getConnection();
        long t1 = System.currentTimeMillis();
        ordianryStatement(connection);
        long t2 = System.currentTimeMillis();
        ordinaryPreparedStatement(connection);
        long t3 = System.currentTimeMillis();
        batchStatement(connection);
        long t4 = System.currentTimeMillis();
        batchPreparedStatement(connection);
        long t5 = System.currentTimeMillis();
        System.out.println("常规statement：" + (t2 - t1) + "ms");
        System.out.println("常规PreparedStatement:" + (t3 - t2) + "ms");
        System.out.println("批处理statement：" + (t4 - t3) + "ms");
        System.out.println("批处理PreparedStatement:" + (t5 - t4) + "ms");
    }

    private static void batchPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user values (null, ?, ?)");
        for (int i = 1; i < 1001; i++) {
            preparedStatement.setString(1, "username" + i);
            preparedStatement.setString(2, "password" + i);
            preparedStatement.addBatch();
        }
        //一次性将全部的参数发送到数据库
        preparedStatement.executeBatch();
        preparedStatement.clearBatch();
        preparedStatement.close();
    }

    private static void batchStatement(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        for (int i = 1; i < 1001; i++) {
            statement.addBatch("insert into user values (null,'username" + i + "','password" + i + "')");
        }
        statement.executeBatch();
        statement.clearBatch();
        statement.close();
    }

    //常规preparedStatement
    private static void ordinaryPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user values (null, ?, ?)");
        for (int i = 1; i < 1001; i++) {
            preparedStatement.setString(1, "username" + i);
            preparedStatement.setString(2, "password" + i);
            preparedStatement.executeUpdate();
        }
        preparedStatement.close();
    }

    //常规statement
    private static void ordianryStatement(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        for (int i = 1; i < 1001; i++) {
            statement.executeUpdate("insert into user values (null,'username" + i + "','password" + i + "')");
        }
        statement.close();
    }
}
