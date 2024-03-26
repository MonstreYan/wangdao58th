package com.cskaoyan._15reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载文件的另一种方式。
 * new FileInputStream("1.properties")
 *
 * ========后续接触很多的反射。就是这玩意。
 * Demo12Config3.class.getClassLoader().getResourceAsStream("123.properties")
 *
 * @author Common-zhou
 * @since 2024-03-26 11:31
 */
public class Demo12Config3 {
    public static void main(String[] args) throws IOException {
        // 另外一种，加载配置文件的方式。
        // 直接死记硬背上。
        Properties properties = new Properties();

        // ==========================================================================
        // 使用这种方式，可以加载文件进来。
        // 反射加载文件。  类加载器.getResourceAsStream() 将一个资源，作为流捞进来。
        InputStream inputStream = Demo12Config3.class.getClassLoader().getResourceAsStream("123.properties");

        // ===================================================================
        // 需要注意的点。 使用类加载器去加载配置文件。 一定要注意。它相对的路径，是编译输出的根目录。
        // 使用类加载器。去加载文件作为流。一定要注意它的相对目录。

        // 后续，在使用类加载器加载文件的时候。如果根目录下有，但是报错。 去编译后的目录看一下，如果没有，rebuild project
        // 或者把编译目录删掉。重新编译


        properties.load(inputStream);
        // properties.load(new FileInputStream("1.properties"));

        System.out.println(properties);
    }
}
