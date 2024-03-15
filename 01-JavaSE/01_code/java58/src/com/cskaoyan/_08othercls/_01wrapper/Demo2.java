package com.cskaoyan._08othercls._01wrapper;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-15 16:38
 */
public class Demo2 {
    @Test
    public void test1() {
        // 包装类，所有对象不可变。
        // Integer是int的一个包装类。就是把这个东西变成一个对象

        // int  Integer
        Integer count = new Integer(10);
        System.out.println(count);

        Integer count1 = ++count;

        System.out.println(count1);

        System.out.println(count == count1);

    }
}
