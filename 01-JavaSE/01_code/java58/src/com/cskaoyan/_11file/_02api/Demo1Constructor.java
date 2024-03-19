package com.cskaoyan._11file._02api;

import org.junit.Test;

import java.io.File;

/**
 * @author Common-zhou
 * @since 2024-03-19 16:18
 */
public class Demo1Constructor {
    @Test
    public void test1() {
        // File (String pathname)  ==> 相对路径，绝对路径

        // 这个绝对路径。拉到你的电脑，找不找到的？
        File file1 = new File("C:\\Users\\zhoubing\\Desktop\\java-58-course-materials\\01-JavaSE" + "\\01_code" + "\\java58\\src\\com\\cskaoyan\\_11file\\_01introduct\\Demo1.java");
        System.out.println("file1.exists() = " + file1.exists());

        // 相对路径
        // 只要开头不是  盘符、 /。 都是相对路径。
        // 相对路径，最重要的就是相对于谁。
        // 一定是相对于： working director
        new File("2.txt");
    }

    @Test
    public void test2() {
        // File (String pathname)  ==> 相对路径，绝对路径

        // 相对路径。
        // 比如，想找这个  _00test包下的Test1.java 文件。怎么找。
        // 绝对路径可以
        // 相对路径。
        // File file1 = new File("src/com.cskaoyan/_00test/Test1.java");
        File file1 = new File("src/com/cskaoyan/_00test/Test1.java");

        // 相对路径： 注意一个最核心的问题。相对于谁。

        System.out.println("file1.exists() = " + file1.exists());
    }

    @Test
    public void test3() {
        //   .   /
        // .在哪里能被识别出来？
        // 在idea里面，创建包的时候，写.可以识别出来。
        // _03test.Demo1  这样的写法，只有在idea里面的写代码的地方才认这个写法。 其他地方不认。

        // 在maven。 还会有这个 .的问题。
    }


    @Test
    public void testN() {
        // File (String parent, Sting child)
        // 在父目录，找child。

        File file1 = new File("C:\\Users\\zhoubing\\Desktop\\java-58-course-materials\\01-JavaSE" +
                "\\01_code\\java58", "1.txt");
        System.out.println("file1.exists() = " + file1.exists());

        // File (File parent, String child)
    }
}
