package com.cskaoyan._01basic._09return;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-01 14:39
 */
public class Demo4 {
    @Test
    public void test1() {
        // 1.添加continue的时候。 如何输出
        // 0   1    2
        // 我喜欢学习Java
        // 4
        // 我喜欢学习C++!

        // 2.添加break的时候。 如何输出
        // 0   1  2
        // 我喜欢学习Java!
        // 我喜欢学习C++!

        // 3.添加return的时候。 如何输出
        // 0   1  2
        // 我喜欢学习Java!

        // 0 1 2 3 4
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                System.out.println("我喜欢学习Java!");
                //在此处填写代码
                // continue;
                // break;
                return;
            }
            System.out.println(i);
        }
        System.out.println("我喜欢学习C++!");
    }
}
