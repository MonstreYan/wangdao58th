package com.cskaoyan._12io._03otherstream;

import org.junit.Test;

import java.io.*;

/**
 * @author Common-zhou
 * @since 2024-03-21 15:17
 */
public class Demo2 {
    @Test
    public void test1() {
        // 1000
        // 把不同的数据类型--->String

        // 我们自己，怎样将任意类型，转换成String输出？
        System.out.print(100);
        System.out.print(true);
    }

    @Test
    public void test2() throws IOException {
        // new OutputStreamWriter()
        Printer printer = new Printer(new FileOutputStream("2.txt"));

        printer.print(10);

        printer.print(3.14);

        // 把任何数据类型，转换为字符串输出。


    }

    @Test
    public void test3() throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream("1.txt"));

        printStream.print(10);
        printStream.print(20);
        printStream.print(3.141414141);
        printStream.close();

        // 其实大家用的标准输出，就是这玩意。
        System.out.println(10);
        System.out.print(10);
        // .out
    }

    @Test
    public void test4() throws IOException {
        // 打印流的核心： 就是把不同的数据类型，转换为String
        // int   97
        // 能不能字节流，直接打印 97 ?

        FileOutputStream outputStream = new FileOutputStream("1.txt");
        outputStream.write(String.valueOf(97).getBytes());

        outputStream.close();
    }

}


/**
 * int   10   "10"
 */
class Printer {

    OutputStream outputStream;

    public Printer(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void print(int i) throws IOException {
        outputStream.write(String.valueOf(i).getBytes());
    }

    public void print(float f) throws IOException {
        outputStream.write(String.valueOf(f).getBytes());
    }

    public void print(double f) throws IOException {
        outputStream.write(String.valueOf(f).getBytes());
    }

    public void close() throws IOException {
        // close怎么关。 ==> 因为Printer本身不做事情。 所以它不用怎么关，只要把底层用的 OutputStream关掉即可
        outputStream.close();
    }
}
