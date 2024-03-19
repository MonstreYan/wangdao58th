package com.cskaoyan._10exception._04choice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * - 捕获并处理try-catch
 * - 向上抛出
 * - 运行时异常，自动抛出，直到抛给JVM
 * - 编译时异常，需要结合throws关键字向上抛
 *
 * @author Common-zhou
 * @since 2024-03-19 14:44
 */
public class Demo1 {
    public static void main(String[] args) throws FileNotFoundException {
        // 现在，学习了几种异常的处理策略

        test1();
    }

    private static void test1() throws FileNotFoundException {

        // 这有个空指针。 运行时异常。
        // JVM会自动向上抛：运行时异常。
        // String s = null;
        // s.length();


        // 编译时异常:  必须要处理。
        // 1.抓  try-catch
        // 2.抛
        // Unhandled exception: java.io.FileNotFoundException
        // try {
        //     new FileInputStream("1.txt");
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        new FileInputStream("1.txt");


    }
}
