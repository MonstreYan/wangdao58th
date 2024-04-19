package com.cskaoyan.cp.v3;

import com.cskaoyan.cp.JdbcUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyConnectionPool3 implements DataSource {

    private static LinkedList<Connection> connectionPool = new LinkedList<>();


    static {
        for (int i = 0; i < 10; i++) {
            //创建10个连接
            Connection connection = null;
            try {
                connection = JdbcUtils.getConnection();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Connection connectionWrapper = new ConnectionWrapper(connection, connectionPool);
            //应该将connectionWrapper放入连接池中，而不是将connection放入连接池，因为wrapper将会对close方法进行重写
            connectionPool.addFirst(connectionWrapper);
        }
    }



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
