package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

    private static String url;

    private static String username;

    private static String password;

    static {
        //因为properties配置文件的改动并没有那么地频繁，所以不用每次获取连接时都去读取一遍
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("jdbc.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    //工具类里面的异常其实可以放心的抛出来，谁调用，谁处理这个异常
    //获取连接
    public static Connection getConnection() throws SQLException {


        //todo 如果由使用mysql更换为使用oracle，那么不仅上述的url、username、password需要变动，driver也需要变动
//        DriverManager.registerDriver(new Driver());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //获取连接 url:固定写法 jdbc协议  mysql子协议 localhost:3306服务器的ip地址以及端口号 /58_work指的是通讯的数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


    //释放资源
    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(connection != null){
            connection.close();
        }
        if(statement != null){
            statement.close();
        }
        if(resultSet != null){
            resultSet.close();
        }
    }
}
