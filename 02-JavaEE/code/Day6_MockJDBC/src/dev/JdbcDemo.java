package dev;

import impl.ConnectionImpl;
import jdbc.Connection;
import jdbc.ResultSet;
import jdbc.Statement;

public class JdbcDemo {

    public static void main(String[] args) {
        //用这行代码来代替jdbc中的DriverManager.getConnection(url,username,password)
        Connection connection = new ConnectionImpl();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");
        boolean next = resultSet.next();
        System.out.println(next);
    }
}
