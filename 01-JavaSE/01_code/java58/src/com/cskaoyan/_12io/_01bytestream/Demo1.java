package com.cskaoyan._12io._01bytestream;

import org.junit.Test;

import java.io.*;

/**
 * @author Common-zhou
 * @since 2024-03-20 09:57
 */
public class Demo1 {
    @Test
    public void test1() {
        // 抽象基类不能直接new。 所以我们直接用JDK给我们提供的类。
        // OutputStream outputStream =
    }

    @Test
    public void test2() throws IOException {
        // OutputStream 是抽象的字节输出流
        // FileOutputStream 是文件字节输出流。
        // 文件字节输出流是干什么的： 从内存中，往文件写出数据的。

        //
        //   内存     --->     外部资源(文件)

        // 传入一个File。代表什么意思。 往哪个文件中写

        OutputStream outputStream = new FileOutputStream(new File("1.txt"));

        // 编译时异常： 一定要手动处理。

        outputStream.write(97);

        outputStream.write(98);
        outputStream.write(99);

    }

    @Test
    public void test3() throws IOException {
        // 使用流的标准步骤

        // 1.创建流对象
        OutputStream outputStream = new FileOutputStream(new File("2.txt"));

        // 2.操作
        outputStream.write(99);
        outputStream.write(100);
        outputStream.write(101);

        // 3.关闭流。
        outputStream.close();

        // 所有不是Java里面的资源， 如果打开了，一定要自己关。  IO
    }

}
