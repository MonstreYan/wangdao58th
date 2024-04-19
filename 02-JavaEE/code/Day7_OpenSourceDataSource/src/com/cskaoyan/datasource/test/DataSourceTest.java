package com.cskaoyan.datasource.test;

import com.cskaoyan.datasource.c3p0.C3p0Utils;
import com.cskaoyan.datasource.dbcp.DBCPUtils;
import com.cskaoyan.datasource.druid.DruidUtils;
import com.cskaoyan.datasource.hikari.HikariUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSourceTest {

    public static void main(String[] args) {
        //不要再去使用自己封装的jdbcutils来获得连接了，因为这种方式本质也是创建一个连接
        //而我们需要的是从连接池里面获得一个
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = HikariUtils.getConnection();
//            connection = DruidUtils.getConnection();
//            connection = C3p0Utils.getConnection();
//            connection = DBCPUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from salary");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                System.out.println(name + ":" + salary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //依然去调用close方法，但是此时已经不是关闭，而是放回连接池了
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(resultSet != null){
                    resultSet.close();
                }
                if(connection != null){
                    connection.close();
                }
            }catch (Exception e){

            }
        }

    }
}
