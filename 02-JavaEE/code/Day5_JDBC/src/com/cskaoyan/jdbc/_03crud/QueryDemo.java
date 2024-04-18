package com.cskaoyan.jdbc._03crud;

import com.cskaoyan.jdbc.bean.Student;
import com.cskaoyan.jdbc.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDemo {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Student> studentList = new ArrayList<>();
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from student where id >= 2");
            //查询全部的数据
            while (resultSet.next()){
                //是否有下一行数据，和iterator的用法基本是一致的，只不过比iterator少调用一个方法
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int gender = resultSet.getInt("gender");
                Date entryDate = resultSet.getDate("entry_date");
                int mid = resultSet.getInt("mid");
                studentList.add(new Student(id, name, gender, entryDate, mid));
                System.out.println(id + "`" + name + "`" + gender + "`" + entryDate + "`" + mid + "`");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                JdbcUtil.close(connection, statement, resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        //后续可以进一步去处理studentList里面的数据
    }
}
