package com.cskaoyan._12io._03review;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * IO流名字比较讲究。 顶层父类的名字，放在最后。
 * FileOutputStream
 * <p>
 * 字节输出流： OutputStream(顶层基类)
 * 字节输入流： InputStream
 * <p>
 * 抽象类。
 *
 * @author Common-zhou
 * @since 2024-03-21 09:35
 */
public class Demo1 {
    @Test
    public void test1() throws IOException {
        // 操作文件的字节输出流。
        OutputStream outputStream = new FileOutputStream(new File("1.txt"));

        outputStream.write(97);
        outputStream.write(98);
        outputStream.write(99);

        // outputStream.write();

        // 在操作，JVM以外的资源的时候。一定要注意关闭资源。
        outputStream.close();

        // 一层一层套娃。
    }

    @Test
    public void test2() throws IOException {
        InputStream inputStream = new FileInputStream("2.txt");

        //    a    b    c    de
        //            |

        System.out.println("inputStream.read() = " + inputStream.read()); // a
        System.out.println("inputStream.read() = " + inputStream.read()); // b
        System.out.println("inputStream.read() = " + inputStream.read()); // c
        System.out.println("inputStream.read() = " + inputStream.read()); // d
        System.out.println("inputStream.read() = " + inputStream.read()); // e
        System.out.println("inputStream.read() = " + inputStream.read());
        System.out.println("inputStream.read() = " + inputStream.read()); //-1
        // read 一下，往后挪一下。 最后一次返回-1

    }


    @Test
    public void test3() throws IOException {
        // 使用数组的方式来读取文件。
        InputStream inputStream = new FileInputStream("2.txt");

        byte[] bytes = new byte[4];

        // 首先，传入一个字节数组。 用这个字节数组去存储里面的数据。 从数组的0开始装。直到装满数组，或者流里面没数据了。
        // 返回一个int。 int代表了这次读取，读取到了多少数据；如果流里没有数据，返回-1

        //    a b c d  e *
        //                |
        // [0,0,0,0]


        // read一次，数据现在变成什么样？
        // [97,98,99,100] bytes数组； readCount = 4

        // read第二次，数据现在变成什么样
        // [101,10,99,100 ]   readCount = 2

        // read第二次，数据现在变成什么样

        int readCount = inputStream.read(bytes);

        System.out.println("===========================");
        System.out.println(Arrays.toString(bytes));
        System.out.println("readCount = " + readCount);

        readCount = inputStream.read(bytes);

        System.out.println("===========================");
        System.out.println(Arrays.toString(bytes));
        System.out.println("readCount = " + readCount);
        readCount = inputStream.read(bytes);
        System.out.println("===========================");
        System.out.println(Arrays.toString(bytes));
        System.out.println("readCount = " + readCount);

        inputStream.close();
    }


    @Test
    public void test4() throws IOException {
        InputStream inputStream = new FileInputStream("2.txt");

        byte[] bytes = new byte[3];
        int len = -1;

        // len = inputStream.read(bytes)  ===> 把数据放到byte[]  ,len是读取到的数据长度。
        // len != -1
        while ((len = inputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }

        inputStream.close();
    }


    @Test
    public void test5() throws IOException {
        InputStream inputStream = new FileInputStream("2.txt");

        byte[] bytes = new byte[3];
        int len = -1;

        // iterator
        while ((len = inputStream.read(bytes)) != -1) {
            len = inputStream.read(bytes);
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }

        inputStream.close();
    }


    @Test
    public void test6() {
        // BufferedOutputStream
        // buffer : 缓冲。

        // BufferedOutputStream: 带缓冲区的。
        // 写数据的数据的时候，是怎样的？

        // 平板小车。 缓冲区。
        // 快递员
        // new BufferedOutputStream(new FileOutputStream("1.txt"));



    }
}
