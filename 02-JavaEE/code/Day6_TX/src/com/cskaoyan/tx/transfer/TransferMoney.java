package com.cskaoyan.tx.transfer;

import com.cskaoyan.tx.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransferMoney {

    public static void main(String[] args) {
        //使用scanner来模拟进行转账的双方信息  转发方姓名  转入方姓名  金额
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入转出方");
        String output = scanner.nextLine();
        System.out.println("请输入转入方");
        String input = scanner.nextLine();
        System.out.println("请输入金额");
        double money = scanner.nextDouble();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            //需要开启事务，保障原子性
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("update account set money = money - ? where name = ?");
            //转出方
            preparedStatement.setDouble(1, money);
            preparedStatement.setString(2, output);
            preparedStatement.executeUpdate();

            int i = 1 / 0;
            //转入方
            preparedStatement.setDouble(1, -money);
            preparedStatement.setString(2, input);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(connection, preparedStatement, null);
        }
    }
}
