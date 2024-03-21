package com.cskaoyan._12io._02charstream;

import org.junit.Test;

import java.io.*;

/**
 * @author Common-zhou
 * @since 2024-03-21 15:02
 */
public class Demo6FileReader {
    @Test
    public void test1() throws IOException {
        FileReader fileReader = new FileReader("1.txt");

        System.out.println((char) fileReader.read());
        System.out.println((char) fileReader.read());
        System.out.println((char) fileReader.read());
        System.out.println((char) fileReader.read());

        fileReader.close();
    }


    @Test
    public void test2() throws IOException {
        // 为什么一个套一个。
        // 字符输入流。   ====》 字节输入流  + 字符集
        // 缓冲输入流的作用。
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("1.txt")));

        String s = bufferedReader.readLine();
        System.out.println(s);

        System.out.println(bufferedReader.readLine());
        // 如果没有数据的了，返回null。
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();

    }
}
