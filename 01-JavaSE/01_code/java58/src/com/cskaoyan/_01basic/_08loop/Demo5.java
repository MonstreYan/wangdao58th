package com.cskaoyan._01basic._08loop;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-01 11:36
 */
public class Demo5 {
    @Test
    public void test1() {
        // 打印四行六列的 #
        for (int i = 0; i < 4; i++) {
            // 在这里面就是4次。
            // System.out.println("######");
            for (int j = 0; j < 6; j++) {
                System.out.printf("#");
            }
            System.out.println();
        }
    }
}
