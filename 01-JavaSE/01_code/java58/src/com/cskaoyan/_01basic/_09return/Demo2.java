package com.cskaoyan._01basic._09return;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-01 11:53
 */
public class Demo2 {
    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {

            if (i == 3) {
                // continue 跳过当前次循环。但是下一次循环继续
                continue;
            }

            System.out.println(i);
        }
    }
}
