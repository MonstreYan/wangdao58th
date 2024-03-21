package com.cskaoyan._12io._03otherstream;

import org.junit.Test;

import java.io.*;

/**
 * 数据流
 * 需求: 用字节流向文件中写个整数1000   小数3.14
 *
 * @author Common-zhou
 * @since 2024-03-21 15:09
 */
public class Demo1 {
    @Test
    public void test1() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("1.txt");

        // 1000   ===》 对应的字符。
        // outputStream.write(1000);
        // outputStream.write(3.14);
    }


    @Test
    public void test2() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("1.txt"));

        dataOutputStream.writeInt(10);
        dataOutputStream.writeDouble(3.14);

        dataOutputStream.close();

        // 用 DataOutputStream 写出去的数据，看不懂。
    }


    @Test
    public void test3() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("1.txt"));

        int readInt = dataInputStream.readInt();
        System.out.println(readInt);

        double v = dataInputStream.readDouble();
        System.out.println(v);

        // 按什么格式往外输出，你就要按什么格式read。
    }

}
