package com.cskaoyan._12io._01bytestream;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Common-zhou
 * @since 2024-03-20 11:09
 */
public class Demo5BufferOutputStream {
    @Test
    public void test1() {
        // BufferedOutputStream 缓冲字节输出流
        // 该类实现缓冲的输出流。通过设置这种输出流，应用程序就可以将各个字节写入底层输出流中，
        // 而不必针对每次字节写入调用底层系统,去实际写出。 等到积累到一定量的时候，再一次输出。

        // 东哥兄弟给大家送快递。

        // 1000 快递
        // 文件字节输出流：
        // 60个块


        // 2000字节要输出。
        // 字节输出流：  （800）
        // 缓冲：
    }

    @Test
    public void test2() throws IOException {
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("2.txt"));

        // outputStream.flush();

        outputStream.write(97);
        outputStream.write(98);
        outputStream.write(98);
        outputStream.write(98);
        outputStream.write(99);


        // BufferedOutputStream  是个小车
        // outputStream.close();
        outputStream.flush();
    }

    @Test
    public void test3() throws IOException {
        // size就是小车的大小。
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("2.txt"), 2);

        outputStream.write(97);
        outputStream.write(98);
        outputStream.write(99);
        outputStream.write(100);
        outputStream.write(101);
        outputStream.write(102);
        outputStream.write(103);

        // 默认是 8192
        BufferedOutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream("2.txt"));

    }
}
