package com.cskaoyan._09string._03feature;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Common-zhou
 * @since 2024-03-18 10:04
 */
public class Demo1 {
    @Test
    public void test1() {
        // 对象一旦被创建后，对象所有的状态及属性在其生命周期内不会发生任何变化。

        String s = new String("hello");
        System.out.println(s);

        // 因为String的底层，是采用的一个数组来存储这些东西。
        // 数组采用的是final修饰的。

        // JDK8的时候，底层是采用的字符数组。
        // private final char[] value;
        // JDK9开始，底层换成了字节数组
        // private final byte[] value;
        // 整体来说，没有大的区别。
    }

    @Test
    public void test2() {
        // 对象一旦被创建后，对象所有的状态及属性在其生命周期内不会发生任何变化。
        String s = "hello";

        String temp = s;

        temp = "world";


        // 现在打印s。 大家觉得是world， 还是hello
        System.out.println("s = " + s); // world？ ===> hello
        System.out.println("temp = " + temp); // world
    }


    @Test
    public void test3() {
        // 对象一旦被创建后，对象所有的状态及属性在其生命周期内不会发生任何变化。
        // 可以自己画一下这个图。 帮助自己理解String。 **************************
        Scanner scanner = new Scanner(System.in);
        // lisi
        String s = scanner.nextLine();

        String s1 = s;

        s1 = "zhansgan";

        System.out.println("s = " + s); // lisi
        System.out.println("s1 = " + s1); // zhangsan

    }
}
