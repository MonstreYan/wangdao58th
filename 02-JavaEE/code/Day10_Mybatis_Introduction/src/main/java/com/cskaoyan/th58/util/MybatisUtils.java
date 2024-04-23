package com.cskaoyan.th58.util;

import com.cskaoyan.th58.MybatisDemo1;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory factory;

    static {
        InputStream inputStream = MybatisUtils.class.getClassLoader().getResourceAsStream("mybatis.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession(){
        return factory.openSession();
    }
}
