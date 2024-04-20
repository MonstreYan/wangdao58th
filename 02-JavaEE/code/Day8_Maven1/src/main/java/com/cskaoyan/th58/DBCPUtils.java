package com.cskaoyan.th58;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.util.Properties;

public class DBCPUtils {

    static {
        Properties prop = new Properties();
        try {
            BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
