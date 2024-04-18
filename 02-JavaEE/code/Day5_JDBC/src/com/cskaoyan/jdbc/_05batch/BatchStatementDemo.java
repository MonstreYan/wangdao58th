package com.cskaoyan.jdbc._05batch;

import com.cskaoyan.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchStatementDemo {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            for (int i = 1; i < 1000; i++) {
                //往statement的缓冲区中去填充sql语句，往小推车里面去添加
                statement.addBatch("insert into user values (null,' username"+ i + "','password" + i + "')");
                //设定每200条sql语句发一次车，集中将200条sql语句一次性全部发送到数据库
                if(i % 200 == 0){
                    //发车
                    statement.executeBatch();
                    //清空缓冲区里面存储的sql语句
                    statement.clearBatch();
                }
            }
            //全部处理完毕之后，801-999这些数据没有进入到if条件语句中
            statement.executeBatch();
            //至于是否需要clearBatch，可以clear也可以不clear，因为程序即将结束，statement即将被关闭
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                JdbcUtil.close(connection, statement, null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
