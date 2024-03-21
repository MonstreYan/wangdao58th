package com.cskaoyan._12io._02charstream;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Common-zhou
 * @since 2024-03-21 11:38
 */
public class Demo3 {


    @Test
    public void test1() throws IOException {
        // 字符流： 字节流 + 编码。


        // FileOutputStream outputStream = new FileOutputStream("1.txt");
        // outputStream.write();

        // abc   ===>   数    ===>    字节流输出。
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("1.txt"));

        writer.write("hello world");

        writer.close();
    }


    @Test
    public void test2() throws IOException {
        // 字符流里面没有做什么很特殊的，只是在里面加了一个字符编码表。

        // OutputStreamWriter

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("2" + ".txt"));

        outputStreamWriter.write("123你好nihao");

        outputStreamWriter.close();
    }

    @Test
    public void test3() throws FileNotFoundException {
        // 字符流，里面就包着 字符编码表 + 字节流

        // 如果没有设置 字符集。这里就用默认的。
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("2.txt"));

        Charset charset = Charset.defaultCharset();
        System.out.println(charset);


        // StandardCharsets.UTF_8 can be used instead  ==>
        new OutputStreamWriter(new FileOutputStream("2.txt"), Charset.forName("UTF-8"));
        new OutputStreamWriter(new FileOutputStream("2.txt"), StandardCharsets.UTF_8);
    }

    @Test
    public void test4() throws IOException {
        FileWriter fileWriter = new FileWriter("3.txt");

        fileWriter.write("hello fileWriter");
        fileWriter.close();



    }
}
