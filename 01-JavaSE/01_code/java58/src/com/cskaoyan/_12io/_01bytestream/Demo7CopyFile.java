package com.cskaoyan._12io._01bytestream;

import java.io.*;

/**
 * 怎么完成一个复制文件的功能。
 * 怎么用IO流，完成复制功能？
 * 先读，再写。  从源文件读，往需要复制的文件写。
 *
 * 1.字节数组复制的速度快一些
 * 2.字节数组一般的大小建议  2048  8192
 * 3.不要写太大。  81920
 *
 * @author Common-zhou
 * @since 2024-03-21 10:11
 */
public class Demo7CopyFile {

    public static void main(String[] args) throws IOException {

        // long startTime = System.currentTimeMillis();
        // copyFileBySingleByte(new File("C:\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510.mp4"), new File("C" + ":\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510_copy.mp4"));
        // System.out.println("consume time:" + (System.currentTimeMillis() - startTime));


        // 对比字节数组复制，和单字节复制的时间

        // long time1 = System.currentTimeMillis();
        // copyFileBySingleByte(new File("C:\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510.mp4"), new File("C" + ":\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510_copy.mp4"));
        // long time2 = System.currentTimeMillis();
        // copyFileByByteArray(new File("C:\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510.mp4"), new File("C" + ":\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510_copy2.mp4"));
        // long time3 = System.currentTimeMillis();

        // System.out.println("single byte copy consume time:" + (time2 - time1));
        // System.out.println("byte array copy consume time:" + (time3 - time2));

        // 后续复制文件，尽量用字节数组。


        System.out.println("=========================================");
        long time1 = System.currentTimeMillis();
        // copyFileByByteArraySize(new File("C:\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510.mp4"), new File("C" + ":\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510_copy2.mp4"), 10);
        long time2 = System.currentTimeMillis();
        copyFileByByteArraySize(new File("C:\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510.mp4"), new File("C" + ":\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510_copy2.mp4"), 1024);
        long time3 = System.currentTimeMillis();
        copyFileByByteArraySize(new File("C:\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510.mp4"), new File("C" + ":\\Users\\zhoubing\\Desktop\\tmp\\20240109_092510_copy2.mp4"), 10240);
        long time4 = System.currentTimeMillis();

        System.out.println("byte array size 10, consume time: " + (time2 - time1));
        System.out.println("byte array size 1024, consume time: " + (time3 - time2));
        System.out.println("byte array size 10240, consume time: " + (time4 - time3));

        // 一般推荐字节数组的大小：2048  8192

    }

    public static void test1() throws IOException {
        // 复制文件

        // 1.创建输入流对象，用于读取需要复制的文件、
        InputStream inputStream = new FileInputStream("1.txt");

        // 2.创建输出流对象，用于写出复制的文件
        OutputStream outputStream = new FileOutputStream("111.txt");

        // 3.循环读， 一个字节一个字节的读。 读完之后写（通过输出流对象）
        int readValue = -1;
        while ((readValue = inputStream.read()) != -1) {
            outputStream.write(readValue);
        }

        // 4.关闭资源
        inputStream.close();
        outputStream.close();
    }


    // 这是个方法，参数是什么东西？
    public static void copyFileBySingleByte(File sourceFile, File copyTargetFile) throws IOException {

        InputStream inputStream = new FileInputStream(sourceFile);

        OutputStream outputStream = new FileOutputStream(copyTargetFile);

        int readValue = -1;
        while ((readValue = inputStream.read()) != -1) {
            outputStream.write(readValue);
        }

        inputStream.close();
        outputStream.close();
    }


    public static void copyFileByByteArray(File sourceFile, File copyTargetFile) throws IOException {

        InputStream inputStream = new FileInputStream(sourceFile);

        OutputStream outputStream = new FileOutputStream(copyTargetFile);

        byte[] bytes = new byte[2048];

        int readCount = -1;
        while ((readCount = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, readCount);
        }

        inputStream.close();
        outputStream.close();
    }


    public static void copyFileByByteArraySize(File sourceFile, File copyTargetFile, int size) throws IOException {

        InputStream inputStream = new FileInputStream(sourceFile);

        OutputStream outputStream = new FileOutputStream(copyTargetFile);

        byte[] bytes = new byte[size];

        int readCount = -1;
        while ((readCount = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, readCount);
        }

        inputStream.close();
        outputStream.close();
    }

}
