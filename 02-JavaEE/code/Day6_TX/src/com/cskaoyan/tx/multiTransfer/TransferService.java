package com.cskaoyan.tx.multiTransfer;

import com.cskaoyan.tx.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//转账业务
public class TransferService {

    public static List<Employee> getEmployeeList(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Employee> employeeList = new ArrayList<Employee>();

        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from salary");
            resultSet = preparedStatement.executeQuery();
            //处理结果集
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                Employee employee = new Employee(id, name, salary);
                employeeList.add(employee);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection, preparedStatement, resultSet);
        }
        return employeeList;
    }

    //进行批量转账的时候，如果全部转账完成才提交事务，那么有一个风险点，如果转账完成99%，但是在最后1%失败了，那么需要全部回滚，但是前面的99%是没有问题
    //所以可以设置一个存档点
    public static void transfer(List<Employee> employeeList) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Savepoint savepoint = null;
        Employee currentEmployee = null;
        try {
            connection = JdbcUtils.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("update account set money = money - ? where name = ?");
            for (int i = 0; i < employeeList.size() ; i++) {
                Employee employee = employeeList.get(i);
                currentEmployee = employee;
                preparedStatement.setDouble(1, employee.getSalary());
                preparedStatement.setString(2, "boss");
                preparedStatement.executeUpdate();

                if(i == employeeList.size() - 1){
                    int a = 1 / 0;
                }
                //转入方
                preparedStatement.setDouble(1, -employee.getSalary());
                preparedStatement.setString(2, employee.getName());
                preparedStatement.executeUpdate();
                //每次转账完成之后，都设置一个存档点
                savepoint = connection.setSavepoint();
                //写入日志
                LogService.log(currentEmployee, "OK");
            }
            //提交事务
            connection.commit();
        } catch (Exception e) {
            //日志写入
            LogService.log(currentEmployee, e.getMessage());
            try {
                if(savepoint != null){
                    connection.rollback(savepoint);
                    //但是需要特别注意的是，如果回滚到存档点，那么需要再次commit提交
                    connection.commit();
                }else {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

    }
}
