package com.cskaoyan.datasource.dbcp;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPUtils {

    private static DataSource dataSource;


    static {
        //逻辑 如何获得datasource数据源
        Properties properties = new Properties();
        try {
            //配置文件里面需要写什么？需要写连接信息
            properties.load(new FileInputStream("dbcp.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
