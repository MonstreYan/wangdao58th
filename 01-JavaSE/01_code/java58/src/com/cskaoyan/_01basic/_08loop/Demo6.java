package com.cskaoyan._01basic._08loop;

import org.junit.Test;

/**
 * 算法工程师。
 * 设计算法。
 * @author Common-zhou
 * @since 2024-03-01 11:41
 */
public class Demo6 {
    @Test
    public void test1() {

        // 嵌套循环。 for  while
        // 0 1 2 3 4

        // i=0
        for (int i = 0; i < 5; i++) {

            // i=0  j=0
            for (int j = 0; j <= i; j++) {
                System.out.printf("#");
            }
            System.out.println();
        }
    }
}
