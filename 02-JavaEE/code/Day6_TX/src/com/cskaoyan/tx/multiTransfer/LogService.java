package com.cskaoyan.tx.multiTransfer;

import com.cskaoyan.tx.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogService {
    public static void log(Employee currentEmployee, String message) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement("insert into log values (null, ?, ?, ?, ?)");
            preparedStatement.setString(1, "boss");
            preparedStatement.setString(2, currentEmployee.getName());
            preparedStatement.setDouble(3, currentEmployee.getSalary());
            preparedStatement.setString(4, message);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection, preparedStatement, null);
        }

    }

}
