package com.cskaoyan.th58;

import com.cskaoyan.th58.bean.Salary;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisDemo2 {

    public static void main(String[] args) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //此处不需要去写sql语句，而是直接去写sql语句对应的编号(namespace + id)
        Salary salary = sqlSession.selectOne("com.cskaoyan.th58.mapper.SalaryMapper.selectOne", 1);
        System.out.println(salary);
        //查询的时候可以不用commit也可以，但是增晒改的时候一定得记得commit
        //下面两行代码就可以理解为是对于jdbc的进一步封装
        //对于connection.commit()封装
        sqlSession.commit();
        //对于connection、preparedStatement、ResultSet.close的封装
        sqlSession.close();
    }
}
