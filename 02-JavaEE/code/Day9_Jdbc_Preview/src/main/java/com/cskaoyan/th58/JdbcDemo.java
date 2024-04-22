package com.cskaoyan.th58;

import com.cskaoyan.th58.bean.Salary;
import com.cskaoyan.th58.util.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo {

    public static void main(String[] args) {
        //查询一张表的数据，将数据结果封装成为一个对象 salary
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Salary> salaries = new ArrayList<>();
        try {
            connection = DruidUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from salary");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                salaries.add(new Salary(id, name, salary));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(connection != null){
                    connection.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (Exception e){

            }
        }

        //打印一下list的数据
        for (Salary salary : salaries) {
            System.out.println(salary);
        }

    }
}
