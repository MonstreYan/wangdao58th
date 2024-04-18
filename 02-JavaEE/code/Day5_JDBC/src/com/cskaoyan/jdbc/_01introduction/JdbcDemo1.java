package com.cskaoyan.jdbc._01introduction;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JdbcDemo1 {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //0.导入驱动程序
            DriverManager.registerDriver(new Driver());
            //        1.获取连接 建立tcp连接 mysql -u root -p 提供信息：用户名、密码、服务器的ip地址、端口号
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/58_work", "root", "123456");
            //        2.发送sql语句
            //在jdbc规范中，我们希望发送sql语句，则需要使用一个叫做statement对象
            statement = connection.createStatement();
            //statement专门用来去发送sql语句
            resultSet = statement.executeQuery("select * from mentor");
            //resultSet里面包含的便是我们需要的数据结果
            //对于开发者来说，我们需要做的事情便是去解析获取里面的数据
            //        3.解析结果
            //resultSet内部有一个结果集，相当于excel表格一样；内部有一个指针，默认指向第一行数据之前，移动一次指针，可以取出当前行数据
            //相当于移动一次指针
            resultSet.next();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String title = resultSet.getString("title");
            String direction = resultSet.getString("direction");
            System.out.println(id + " " + name + " " + title + " " + direction);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //        4.关闭连接 释放资源
            try {
                if(connection != null){
                    connection.close();
                }
                if(statement != null){
                    statement.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (Exception e){

            }
        }
    }
}
