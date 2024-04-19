package com.cskaoyan.cp.v2;

import com.cskaoyan.cp.JdbcUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyConnectionPool2 implements DataSource {

    private static LinkedList<Connection> connectionPool = new LinkedList<>();


    static {
        for (int i = 0; i < 10; i++) {
            try {
                connectionPool.addFirst(JdbcUtils.getConnection());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //只去实现接口中的这个方法
    @Override
    public Connection getConnection() throws SQLException {

        return connectionPool.removeLast();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
