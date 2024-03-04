package com.cskaoyan._03array._06vp;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-04 15:59
 */
public class Demo2 {

    @Test
    public void test1() {
        // 方法的传参问题。
        // Java就是值传递，它传递的是值的拷贝。
        int test1 = 10;
        doubleIntValue(test1);

        // 现在。 test1 是多少？
        System.out.println(test1);
    }

    public static void doubleIntValue(int a) {
        a = a * 2;

        System.out.println("doubleIntValue:" + a);
    }
}
