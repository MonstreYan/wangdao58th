package com.cskaoyan._01basic._08loop;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-01 11:28
 */
public class Demo3 {
    @Test
    public void test1() {
        // 珠峰的高度是8848m，假设有一张足够大可折叠的纸张，初始厚度是0.01m。
        // 求解这张纸折叠多少次，纸张的厚度开始超过珠峰？

        double paperHeight = 0.01;
        int count = 0;

        while (paperHeight < 8848) {
            paperHeight = paperHeight * 2;
            count++;
        }

        System.out.println("折叠次数：" + count);
        System.out.println(paperHeight);



    }
}
