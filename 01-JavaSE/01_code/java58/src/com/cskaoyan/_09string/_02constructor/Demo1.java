package com.cskaoyan._09string._02constructor;

import org.junit.Test;

/**
 * String类的构造方法。 主要就分三大类。
 * <p>
 * - 空字符串""
 * - byte[] -----> String
 * - char[] -----> String
 *
 * @author Common-zhou
 * @since 2024-03-18 09:44
 */
public class Demo1 {
    @Test
    public void test1() {

        // String类，一定要用java.lang包下的。
        // 尤其是JDK8.
        String string = new String();

        System.out.println("===" + string + "===");

        // 第一个构造方法： 了解一下。 就是一个无参

        // 为什么在不同的方法里面，点ctrl+p。出来的选项不同。 因为有的方法，有方法重载， 允许多种参数组合的输入。
        // string.length();
        // string.substring();
    }


    @Test
    public void test2() {
        // 第二种：就是允许你传入一个byte数组。
        // 或者一个byte数组的一部分。

        byte[] bytes = {97, 98, 99, 102};

        // abcf
        // 97--->a
        // 98--->b
        // 99--> c
        // 102 --> f
        String s = new String(bytes);
        System.out.println(s);

        String s1 = new String(bytes, 1, 2);
        System.out.println(s1);
    }

    @Test
    public void test3() {
        // 第三种构造方法，允许你传入一个 char数组， 或者char数组的一部分。
        // 把char数组，变成字符串。

        // char[] chars  =
        // 数组初始化方法
        // 1.静态初始化
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', '你'};
        // 简化写法， 但是一定要注意。 一定要和声明一起使用
        char[] chars2 = {'a', 'b', 'c', 'd'};
        // chars = {'a', 'b', 'c', 'd'};
        // 2.动态初始化
        // char[] chars1 = new char[10];

        String s = new String(chars);

        System.out.println(s);

        // 很多时候，名字是帮助我们理解的一个非常重要的东西。
        // 偏移两个， 截取长度是3个。
        String s1 = new String(chars, 2, 3);
        System.out.println("s1 = " + s1);
    }

    @Test
    public void test4() {
        //知道即可
        // public String(String original)
        // 允许你传入一个字符串。 用这个字符串生成一个字符串。

        String s = new String("abc");
        System.out.println(s);

    }
}
