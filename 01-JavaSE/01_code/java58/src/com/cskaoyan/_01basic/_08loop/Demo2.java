package com.cskaoyan._01basic._08loop;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-01 11:15
 */
public class Demo2 {
    public static void main(String[] args) {
        // 1. 用for循环计算1+2+3+...+100
        // 2. 用for循环求出1-100之间偶数和
        // 3. 用for循环求5的阶乘

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            // 在这里面，能拿到哪些i？
            // System.out.println(i);
            sum += i;
        }
        // fori
        // for (int i = 0; i < 10; i++) {
        //
        // }

        System.out.println(sum);

        // 需要注意的点，就是边界情况。
        // 是否包括 for (int i = 0; i < 10; i++) {
        // 比如上面的循环条件。是否包括0？  包括
        // 是否包括10  不包括
    }


    @Test
    public void test2() {
        // 2. 用for循环求出1-100之间偶数和

        int sum = 0;
        for (int i = 1; i < 101; i++) {
            // 在这里，能拿到哪些i？  1,2,3，  100
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);

        // 1   2 3 4 5 6  7 8

        // 2  4


        // 拿偶数。 +=2
        for (int i = 2; i < 101; i += 2) {
            System.out.println(i);
        }

    }

    @Test
    public void test3() {
        // 3. 用for循环求5的阶乘

        int result = 1;
        // 1 * 2 * 3 * 4 * 5
        for (int i = 1; i < 7; i++) {
            // System.out.println(i);
            result *= i;
        }
        System.out.println(result);

        // 一般情况下，是不会关心你的实现的。
        // 但是，在你的效率太差的时候。  ==》 不要整太多的循环。 尤其是循环的嵌套。

    }
}
