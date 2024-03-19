package com.cskaoyan._11file._01introduct;

import org.junit.Test;

import java.io.File;

/**
 * 相对路径和绝对路径：
 * 在Java里面都能用，主要是在 File类这里用。  IO里面
 *
 * @author Common-zhou
 * @since 2024-03-19 15:56
 */
public class Demo2 {
    @Test
    public void test1() {
        // 在 new File中，可以写路径名。 相对路径和绝对路径都行。

        // Java里面的相对路径，到底相对于谁。
        // new File的时候，相对的就是  working directory
        // 默认情况下，working director 就是项目的根目录。
        // 也可以改。
        // 在Java里面的相对路径，是相对于 Working directory的目录，

        File file = new File("1.txt");
        File file2 = new File(".gitIgnore");

        System.out.println("file.exists() = " + file.exists());

        System.out.println("file2.exists() = " + file2.exists());
    }

    @Test
    public void test2() {
        // 转义字符  \\    \
        File file = new File("D:\\develop\\apache-maven-3.5.3-bin.zip");
        System.out.println("file.exists() = " + file.exists());

        // 在windows下，绝对路径是以 盘符开头的。（一般情况）


        // 但是，有时候，是以 / 开头。  ===》 只要是这样写，都是代表绝对路径。
        // 这样写，代表的是代码在哪个盘，就是以哪个盘为根目录。
        File file1 = new File("/develop/apache-maven-3.5.3-bin.zip");
        System.out.println("file1.exists() = " + file1.exists());

        File file2 = new File("\\Users\\zhoubing\\Desktop\\java-58-course-materials\\01-JavaSE\\01_code" + "\\java58\\.gitignore");

        System.out.println("file2.exists() = " + file2.exists());
    }

    @Test
    public void test3() {
        // 路径分两种
        // 绝对路径，相对路径
        // 绝对路径，是以盘符开头（/ 也算）。 在Linux/Mac下面，都是以  / 开头
        // 相对路径， 其他的都是相对路径。  test/1.txt   ./test2/2.txt
    }

    @Test
    public void test4() {
        // ./代表当前路径。  ../代表上一级路径

        // ../.. 上一级的上一级
        // 但是一定要注意。相对路径，最重要的问题，一定是相对于谁。

        // working directory
        // File file = new File("./1.txt");
        File file = new File("1.txt");
        System.out.println(file.exists());


        File file1 = new File("../../1.txt");
        System.out.println(file1.exists());
    }

    @Test
    public void test5() {
        // 相对路径和绝对路径，相对路径使用的多。
        // 如果使用绝对路径，路径写死了。别人没有这个路径。
        // C:
        // 相对路径，有时候会出错（找不到问题）。 但是对于移植问题，非常适合。
        // 所以，相对路径用的多一些。
    }
}
