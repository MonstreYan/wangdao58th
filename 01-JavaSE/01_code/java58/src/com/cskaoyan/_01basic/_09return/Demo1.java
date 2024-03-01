package com.cskaoyan._01basic._09return;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-01 11:49
 */
public class Demo1 {
    @Test
    public void test1() {
        // break就是中断循环. 如果在for循环里面碰到，它会直接中止这一层的循环
        // break关键字。

        for (int i = 0; i < 100; i++) {
            // 现在，想循环到5，就中止循环
            System.out.println(i);
            if (i == 5) {
                break;
            }
        }
    }

    @Test
    public void test2() {
        // 会中止当前层的。 外层的for循环，不会中止。
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("-");

                if (j == 3) {
                    break;
                }
            }

            System.out.println();
        }
    }
}
