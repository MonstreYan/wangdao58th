package com.cskaoyan._15reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 重点理解什么是配置文件。 它是干什么的， 有什么作用。
 *
 * @author Common-zhou
 * @since 2024-03-26 11:24
 */
public class Demo11Config2 {

    public static void main(String[] args) throws IOException {
        // properties配置文件。 是以 .properties结尾的文件
        // 在文件中，是以key=value形式存储的数据。
        // 使用非常简单。 步骤
        // 步骤1： 创建Properties对象
        Properties properties = new Properties();

        // 步骤2： 加载。 properties.load 直接放入一个输入流
        properties.load(new FileInputStream("1.properties"));

        // properties里面就有东西。
        System.out.println(properties);

        // 步骤3： 直接使用。   getProperty()
        String url = properties.getProperty("url");
        System.out.println("properties.getProperty(\"url\") = " + properties.getProperty("url"));

        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));

    }

}
