package com.cskaoyan.th58.jdbc;

import com.cskaoyan.th58.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DynamicSqlDemo {

    public static void main(String[] args) throws SQLException {
        //先不使用mybatis，使用jdbc的代码来实现动态sql的功能
        //需要先思考一个问题：sql语句是固定的吗？
        //想到的解决方案是穷举：遍历所有的条件：3个条件 C3,1 c3,2 c3,3  3 + 3 + 1 + 1 = 8种
        //select * from user where id = ? and username = ? and phone = ?
        //综上所述，使用穷举法，如果面对的条件非常多的话，那么是不太可行的
        //这里面的思路：其实是根据传递的条件不同，动态地去拼接对应的sql语句

        //模拟从用户接收到的用户名、编号、手机等信息
        String username = "aaa123";
        Integer id = 1;
        String phone = "18823288226";

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dynamic_table?characterEncoding=utf-8&useSSL=false", "root", "123456");
        dynamicSql(connection, username, id, phone);
        connection.close();
    }

    //因为用户输入的条件不是固定，或者说不是一定会输入对应的条件，所以sql语句也是不固定的
    private static void dynamicSql(Connection connection, String username, Integer id, String phone) throws SQLException {
        String sql = "select * from user ";
        String condition = "";
        //如果三者均是null，则condition是null，那么最终的sql语句就是sql
        //如果这三者之中有一个不是null，那么我们需要拼接一个where，并且将这三个condition最前面的and去掉
        List<Object> params = new ArrayList<>();
        if(username != null){
            condition += "and username = ? ";
            params.add(username);
        }
        if(id != null){
            condition += "and id = ? ";
            params.add(id);
        }
        if(phone != null){
            condition += "and phone = ? ";
            params.add(phone);
        }

        if(!condition.equals("")){
            //需要先将condition前面的and去掉
            condition = condition.substring(3);
            sql = sql + " where " + condition;
        }
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //填充参数
        for (int i = 0; i < params.size(); i++) {
            preparedStatement.setObject( i + 1, params.get(i));
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id1 = resultSet.getInt("id");
            String name = resultSet.getString("username");
            String phone1 = resultSet.getString("phone");
            User user = new User(id1, name, phone1);
            System.out.println(user);
        }
    }
}
