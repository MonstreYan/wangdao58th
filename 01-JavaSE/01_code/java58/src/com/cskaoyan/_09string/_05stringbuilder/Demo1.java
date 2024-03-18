package com.cskaoyan._09string._05stringbuilder;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-18 17:17
 */
public class Demo1 {
    @Test
    public void test1() {
        // String是一个不可变对象。

        String s = "abc";

        // 一定得到了一个新的字符串。
        String lowerCase = s.toLowerCase();

        for (int i = 0; i < 10; i++) {
            // 在这里面，每一次拼接，都会产生一个新的对象， 原有对象变成垃圾
            // 如此操作，非常耗费性能。
            // Java给我们提供了可变的字符串。
            s += "0";
            System.out.println(s);
        }
    }
}
