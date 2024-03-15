package com.cskaoyan._08othercls._01wrapper;

/**
 * @author Common-zhou
 * @since 2024-03-15 16:29
 */
public class Demo1 {

    // 常量：
    static int end = Integer.MAX_VALUE;
    static int start = end - 5;

    public static void main(String[] args) {
        int count = 0;

        // Non-static field 'start' cannot be referenced from a static context

        // 最大值假设是1000.
        // end = 1000
        // start = 995

        // i=995 count=1
        // i=996 count=2
        // i=997 count=3
        // i =998 count=4
        // i=999 count=5
        // i=1000  count=6
        // i= 负数
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            count++;
        }

        System.out.println(count);

        int maxValue = Integer.MAX_VALUE;
    }
}
