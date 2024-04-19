package com.cskaoyan.cp.v1;

import com.cskaoyan.cp.JdbcUtils;

import java.sql.Connection;
import java.util.LinkedList;

public class MyConnectionPool1 {

    //连接池，使用什么来充当池子呢？容器 list 存放的是什么呢？Connection
    //使用linkedlist来充当池子
    private static LinkedList<Connection> connectionPool = new LinkedList<>();

    static {
        //预先先创建好10个连接，放入池子中，后续客户端使用的时候，直接从池子中获取
        for (int i = 0; i < 10; i++) {
            Connection connection = null;
            try {
                //创建连接，自己封装编写的工具类
                connection = JdbcUtils.getConnection();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            connectionPool.addFirst(connection);
        }
    }


    public static Connection getConnection(){
        return connectionPool.pollLast();
    }

    public static void returnConnection(Connection connection){
        connectionPool.addFirst(connection);
    }
}
