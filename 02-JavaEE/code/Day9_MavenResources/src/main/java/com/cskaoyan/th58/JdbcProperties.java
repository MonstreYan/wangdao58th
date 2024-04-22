package com.cskaoyan.th58;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
// baseDir(classpath) + com/cskaoyan/th58/JdbcProperties.class
public class JdbcProperties {

    public static void main(String[] args) {
        //读取jdbc.properties配置文件里面的数据，应该如何读取呢？
        Properties properties = new Properties();
        try {
            //往期同学有使用这种方式来获取位于src\main\resources目录下的文件的路径，可以吗？可以是可以，但是不要用，否则今后项目只要更换地址或者打包，代码无法运行
//            properties.load(new FileInputStream("D:\\cskaoyan-training-course\\java-58-course-materials\\02-JavaEE\\code\\Day9_MavenResources\\src\\main\\resources\\jdbc.properties"));

            //打包之后，这个也是无法使用的
            File file = new File("src\\main\\resources\\jdbc.properties");
            //获取加载当前类的类加载器 当前类的类加载器在Class对象里面也有记录
            ClassLoader classLoader = JdbcProperties.class.getClassLoader();
            //参数：要求输入一个相对于classpath的相对路径，返回一个文件的输入流信息
            InputStream inputStream = classLoader.getResourceAsStream("jdbc.properties");
//

            String path = classLoader.getResource("jdbc.properties").getPath();


            properties.load(inputStream);
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            System.out.println(username);
            System.out.println(password);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
