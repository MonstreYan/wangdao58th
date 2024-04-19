package com.cskaoyan.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Utils {

    private static DataSource dataSource;


    static {
        //代码能够这么去写的前提条件是必须要求在src目录下存在着一个c3p0.properties配置文件
        dataSource = new ComboPooledDataSource();
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
