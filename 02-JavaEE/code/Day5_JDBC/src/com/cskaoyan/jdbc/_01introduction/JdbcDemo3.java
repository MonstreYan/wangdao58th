package com.cskaoyan.jdbc._01introduction;

import com.cskaoyan.jdbc.util.JdbcUtil;

import java.sql.*;

public class JdbcDemo3 {

    public static void main(String[] args) {
        //关于jdbc的过程，希望大家能够做到非常非常熟练
        //1注册驱动
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //发送sql语句
            connection  = JdbcUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from student");
            //解析结果集
            resultSet.next();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int gender = resultSet.getInt("gender");
            Date entryDate = resultSet.getDate("entry_date");
            int mid = resultSet.getInt("mid");
            System.out.println(id + " " + name + " " + gender + " " + entryDate + " " + mid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭连接
            try {
                JdbcUtil.close(connection,statement, resultSet);
            }catch (Exception e){

            }

        }
    }
}
