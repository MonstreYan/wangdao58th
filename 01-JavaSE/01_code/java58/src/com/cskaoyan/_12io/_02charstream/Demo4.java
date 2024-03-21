package com.cskaoyan._12io._02charstream;

import org.junit.Test;

import java.io.*;

/**
 * 字符流。  字符流就是在字节流的基础上，加了一个编码表，里面有个缓冲区
 * 所以，字符集底层操作，其实也是字节流，只是字符流将字符，转换为字节之后，通过字节流操作的。
 *
 * @author Common-zhou
 * @since 2024-03-21 14:35
 */
public class Demo4 {
    @Test
    public void test1() throws IOException {
        // 字符流的底层，就是用的字节流。只是字符流顺手帮你转换。 帮助把字符转换为字节数组，然后写出。
        OutputStream outputStream = new FileOutputStream("2" + ".txt");
        String s = "景天老师又喝奶茶";
        outputStream.write(s.getBytes());

        // 字符流： 输出流。
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("1" + ".txt"));

        outputStreamWriter.write("景天老师喝奶茶");

        outputStreamWriter.write("景天老师喝瑞幸");

        outputStreamWriter.close();
    }

    @Test
    public void test2() throws IOException {
        // new FileWriter  <===> new OutputStreamWriter(new FileOutputStream("1" + ".txt"))
        // 简化流
        FileWriter fileWriter = new FileWriter("1.txt");

    }

    @Test
    public void test3() throws IOException {
        // Writer： 就是字符流的顶层基类
        // Reader
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("1.txt"))));

        bufferedWriter.write("景天喝茶百道");
        // bufferedWriter.write("\n");
        bufferedWriter.newLine();
        // newLine就是写一个换行符出去

        bufferedWriter.write("景天喝美式");

        bufferedWriter.close();

    }


}
