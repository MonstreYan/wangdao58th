package com.cskaoyan._20map._06other;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Common-zhou
 * @since 2024-04-05 17:01
 */
public class Demo4Properties {
    @Test
    public void test1() throws IOException {
        // Properties其实是Hashtable的一个子类。
        // 它主要用来存储配置文件

        // 怎么使用？

        Properties properties = new Properties();

        properties.load(new FileInputStream("src/123.properties"));

        System.out.println(properties);

        // properties.getProperty()
        // properties.setProperty()
    }

    @Test
    public void test2() throws IOException {
        // 反射经常用在读取配置文件
        InputStream inputStream = Demo4Properties.class.getClassLoader().getResourceAsStream("123.properties");
        Properties properties = new Properties();

        properties.load(inputStream);

        System.out.println(properties);

    }
}
