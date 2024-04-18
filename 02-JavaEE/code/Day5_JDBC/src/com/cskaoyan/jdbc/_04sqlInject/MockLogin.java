package com.cskaoyan.jdbc._04sqlInject;

import com.cskaoyan.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MockLogin {

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
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            String sql = "select * from user where name = '" + username + "' and password = '" + password + "'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
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
                JdbcUtil.close(connection, statement, resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
