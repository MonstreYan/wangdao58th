package com.cskaoyan.th58;

import com.cskaoyan.th58.bean.Salary;
import com.cskaoyan.th58.mapper.SalaryMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MybatisDemo3 {

    public static void main(String[] args) {
        //之前封装的一个工具类，每次操作数据库的时候，都要调用一次
        //这个sqlSession就相当于一个连接connection
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //使用一种基于动态代理的方式，提供了一个接口；后续mybatis会在程序运行期间，动态地产生一个类对象
        SalaryMapper salaryMapper = sqlSession.getMapper(SalaryMapper.class);
        List<Salary> salaries = salaryMapper.selectAll();
        for (Salary salary : salaries) {
            System.out.println(salary);
        }

        Integer rows = salaryMapper.insertOne("阿齐");
        System.out.println(rows);

        salaryMapper.updateOne("aqi");

        salaryMapper.deleteOne(1);

        sqlSession.commit();
        sqlSession.close();
    }
}
