package com.cskaoyan.th58;

import com.cskaoyan.th58.bean.Log;
import com.cskaoyan.th58.bean.Salary;
import com.cskaoyan.th58.util.DruidUtils;

import java.sql.Connection;
import java.util.List;

public class JdbcDemo2 {

    public static void main(String[] args) throws Exception {
        //查询salary表，把数据封装成为List<Salary>形式

        Connection connection = DruidUtils.getConnection();
        List<Salary> salaryList = (List<Salary>) MockMybatis.query(connection, "select * from salary", Salary.class);
        for (Salary salary : salaryList) {
            System.out.println(salary);
        }

        //我们写的这段代码不仅可以用来封装salary表，也可以用来封装log表
        List<Log> logList = (List<Log>) MockMybatis.query(connection, "select * from log", Log.class);

        for (Log log : logList) {
            System.out.println(log);
        }
        connection.close();
    }
}
