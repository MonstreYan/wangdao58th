package com.cskaoyan._08othercls._01wrapper;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-15 17:27
 */
public class Demo5Cache {
    @Test
    public void test1() {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(1);

        System.out.println("(integer1 == integer2) : " + (integer1 == integer2)); // false?

        Integer integer3 = 1; // 底层使用valueOf(int i)方法
        Integer integer4 = 1; //底层使用valueOf(int i)方法


        System.out.println("(integer3 == integer4) : " + (integer3 == integer4)); // true?

        Integer integer5 = Integer.valueOf(1);
        Integer integer6 = Integer.valueOf(1);
        System.out.println("(integer5 == integer6) : " + (integer5 == integer6)); // true?

        // 主要是因为JDK底层，对这块做了特殊处理。有个缓存在。

        // Integer.valueOf(1);

        // 只要在  [-128,127] 之间，就会从我原本的数组拿。
    }

    @Test
    public void test3() {
        Integer integer1 = new Integer(127);
        Integer integer2 = new Integer(127);
        System.out.println("(integer1 == integer2) = " + (integer1 == integer2));// false
        // 这是 new的对象。地址不一样。


        Integer integer3 = 127;
        Integer integer4 = 127;
        System.out.println("(integer3 == integer4) = " + (integer3 == integer4)); // true
        // -128 127之间。 直接从数组中拿数据。
        // 他们两个指向同一个。


        Integer integer5 = 128;
        Integer integer6 = 128;
        System.out.println("(integer5 == integer6) = " + (integer5 == integer6)); // false
    }
}
