package com.cskaoyan._12io._01bytestream;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-20 10:10
 */
public class Demo2FileOutputStream {

    @Test
    public void testConstructor1() throws IOException {

        // FileOutStream ： 从内存中，往外（文件）写数据。

        // FileOutputStream(String  fileName)  允许你直接写路径。相对路径和绝对路径都可以。
        // 它的相对路径和 File是一样的
        OutputStream outputStream = new FileOutputStream("C:\\Users\\zhoubing\\Desktop\\java-58-course-materials\\01-JavaSE" + "\\01_code\\java58\\1.txt");

        outputStream.write(97);
        outputStream.write(98);
        outputStream.write(99);
        outputStream.write(99);
        outputStream.write(99);
        outputStream.write(100);

        outputStream.close();
    }


    @Test
    public void test2Constructor2() throws FileNotFoundException {
        // 'new File' is redundant
        FileOutputStream outputStream = new FileOutputStream(new File("2.txt"));
    }


    @Test
    public void test3Constructor3() throws IOException {
        // append 就是追加的意思。 如果不设置。 默认就是覆盖掉原文件。
        OutputStream outputStream = new FileOutputStream("2.txt", false);

        outputStream.write(99);
        outputStream.write(99);
        outputStream.write(99);
        outputStream.write(99);
        outputStream.write(99);
        outputStream.write(99);
        outputStream.write(99);
        outputStream.write(99);
        outputStream.write(99);
        outputStream.write(100);

        outputStream.close();

    }


    @Test
    public void testWrite1() throws IOException {
        // 成员方法的  write 方法。

        OutputStream outputStream = new FileOutputStream("2.txt");

        outputStream.write(97);
        outputStream.write(98);

        byte[] bytes = {97, 98, 99, 100, 101, 101, 101, 102};

        // write 方法，允许你写一个int出去。 也允许你写一个字节数组出去，也允许你写字节数组的一部分出去。
        outputStream.write(bytes);

        outputStream.close();
    }


    @Test
    public void testWrite() throws IOException {
        OutputStream outputStream = new FileOutputStream("2.txt");

        byte[] bytes = {97, 98, 99, 100, 101, 101, 101, 102};
        //               0   1   2

        // 写字节数组的一部分。
        outputStream.write(bytes, 2, 4);

        outputStream.close();
    }

    @Test
    public void testWrite2() throws IOException {
        // 能不能写一些其他的字符串。

        OutputStream outputStream = new FileOutputStream("2.txt");

        String s = "hello world";
        // 可以使用  getBytes() 方法，将一个字符串，转换为字节数组、
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));

        outputStream.write(bytes);

        outputStream.close();

    }


    @Test
    public void test3NewLine() throws IOException {
        // 如何实现换行。
        // "\n"

        OutputStream outputStream = new FileOutputStream("2.txt");

        outputStream.write("hello io".getBytes());

        // 换行的方式有很多。   \n     \r\n   \r
        // 在不同的操作系统下，换行符不一样。
        outputStream.write("\n".getBytes());

        outputStream.write("new Line".getBytes());


        outputStream.close();

    }

    @Test
    public void test4NewLine() {
        String s = System.lineSeparator();

        System.out.println("aaa" + s + "bbb");
    }
}
