package com.cskaoyan.datasource.hikari;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class HikariUtils {

    private static DataSource dataSource;


    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("hikari.properties"));
            HikariConfig config = new HikariConfig(properties);
            dataSource = new HikariDataSource(config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
