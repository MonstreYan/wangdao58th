package com.cskaoyan.jdbc._04sqlInject;

import com.cskaoyan.jdbc.util.JdbcUtil;

import java.sql.*;
import java.util.Scanner;
//解决sql注入问题
public class MockLogin2 {

    public static void main(String[] args) {
        //模拟用户的登录行为
        //使用scanner来模拟用户输入的用户名、密码信息
        Scanner scanner = new Scanner(System.in);
        //去构造一个伪造的用户名、密码信息，用户名随便写；密码 : 1234' or '1' = '1
        String username = scanner.nextLine();
        String password = scanner.nextLine();


        //获取到了用户输入的用户名、密码，需要校验用户名、密码是否匹配
        //select * from user where username = xxx and password = xxx
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtil.getConnection();
//            connection.createStatement();
            //为什么prepareStatement需要提供一个sql，而createStatement不需要？原因在于prepareStatement需要进行预编译
            //先创建一个preparedStatement，第一次通讯：将sql语句发送到数据库进行预编译
           preparedStatement = connection.prepareStatement("select * from user where name = ? and password = ?");
            //第二次通讯：再次填充对应的参数信息
           preparedStatement.setString(1, username);
           preparedStatement.setString(2, password);
           resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                //用户名、密码匹配
                System.out.println("用户名密码匹配");
            }else {
                //用户名、密码不匹配
                System.out.println("用户名密码错误");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                JdbcUtil.close(connection, preparedStatement, resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
