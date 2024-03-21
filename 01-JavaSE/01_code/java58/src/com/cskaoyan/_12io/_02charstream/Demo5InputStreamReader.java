package com.cskaoyan._12io._02charstream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-21 14:50
 */
public class Demo5InputStreamReader {
    @Test
    public void test1() throws IOException {
        // Reader
        // Reader就是字符流的顶层基类。 字符流，输入流

        InputStreamReader reader = new InputStreamReader(new FileInputStream("1.txt"));

        int read = reader.read();
        System.out.println((char) read);
        System.out.println((char) reader.read());
        System.out.println((char) reader.read());
        System.out.println((char) reader.read());
        System.out.println((char) reader.read());
        System.out.println((char) reader.read());


        reader.close();
    }

    @Test
    public void test3() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("1.txt"));

        char[] chars = new char[20];

        // char的默认值。是一个绝对的空字符串
        // System.out.println(chars[0]);

        int readCount = inputStreamReader.read(chars);

        System.out.println(Arrays.toString(chars));

        for (char aChar : chars) {
            System.out.println(aChar);
        }

        // 因为一个转义字符的问题。

        System.out.println(readCount);
    }

    @Test
    public void test4() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append("2");
        stringBuilder.append("3");

        // stringBuilder.append("\b");
        stringBuilder.append("\r");
        stringBuilder.append("6");
        stringBuilder.append("6");
        stringBuilder.append("6");

        System.out.println(stringBuilder.toString());
    }

}
