package com.cskaoyan._09string._03feature;

import org.junit.Test;

/**
 * 字符串拼接问题
 *
 * @author Common-zhou
 * @since 2024-03-18 11:30
 */
public class Demo5 {

    /**
     * 进行字符串拼接的时候有2种情况
     * - 当参与字符串拼接对的2个字符串,只要有1个引用变量的形式出现时,则会在堆上创建新的字符串对象.
     * - 原因是因为参与了运算,无法在编译期确定其值,就不能在编译时期加入常量池
     * - 只有参与字符串拼接的2个字符串都是字面值常量的时候
     * - 如果常量池中已有该字符串对象的引用,则返回常量池中的引用
     * - 如果常量池中没有,则在堆上创建,并把引用放入常量池
     */
    @Test
    public void test2() {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");

        System.out.println("[s1 == s2] : " + (s1 == s2));// true
        System.out.println("[s1 == s3] : " + (s1 == s3));// true
        System.out.println("[s1 == s4] : " + (s1 == s4));// false
        System.out.println("[s1 == s5] : " + (s1 == s5));// false

        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;
        String s10 = "Hello";

        System.out.println("[s9 == s10] : " + (s9 == s10));// false
    }


    @Test
    public void test3() {

        String s1 = "world";
        String s2 = "world";

        String s3 = "wor" + new String("ld");
        String s4 = "wor" + "ld";

        System.out.println("(s1== s3) = " + (s1 == s3)); //  false
        System.out.println("(s1 == s4) = " + (s1 == s4)); // true

        String s5 = "wor";
        String s6 = "ld";

        String s7 = s5 + s6;
        System.out.println("(s1 == s7) = " + (s1 == s7)); // false

    }
}
