package com.cskaoyan._03array._05operations;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-04 14:36
 */
public class Demo1 {

    public static void main(String[] args) {
        // 手动遍历 数组中的数据。
        int[] nums = {10, 15, 25};

        // 0  1 2   length-1
        for (int i = 0; i < nums.length; i++) {
            // 边界情况。
            System.out.println(nums[i]);
        }
    }


    @Test
    public void test1() {
        // 可以写得更美观一点。 输出的更美观一点
        // 最终将一个数组。 美观的输出出来。
        int[] nums = {10, 15, 25};

        // [10, 15, 25]
        System.out.printf("[ ");
        for (int i = 0; i < nums.length; i++) {

            if (i != nums.length - 1) {
                System.out.printf(nums[i] + ", ");
            } else {
                System.out.printf(nums[i] + "");
            }

        }

        System.out.printf(" ]");


    }


}
