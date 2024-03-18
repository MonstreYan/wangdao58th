package com.cskaoyan._09string._03feature;

import org.junit.Test;

/**
 * String实例化的两种方式。
 *
 * @author Common-zhou
 * @since 2024-03-18 11:06
 */
public class Demo3 {


    @Test
    public void test1() {
        String s1 = "abc";
        String s2 = new String("abc");

        // 创建了几个对象出来？
        // 创建了两个， 第一个创建了一个对象，第二个创建了一个对象。
        // s1 = "abc";   创建了一个
        // s2 = new String("abc");  “abc”在常量池上，直接拿。 外围 new String()  新创建了一个
    }

    @Test
    public void test2() {
        String s2 = new String("abc");
        String s1 = "abc";


        // 有没有区别？ 创建了几个对象？
        // 第一句话，创建了两个对象。  “abc”是一个。  new String("") 是另外一个
        // 第二句话， 没有创建对象。直接指向了原来的  abc
    }

}
