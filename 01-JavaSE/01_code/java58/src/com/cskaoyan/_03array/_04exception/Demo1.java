package com.cskaoyan._03array._04exception;

/**
 * @author Common-zhou
 * @since 2024-03-04 11:31
 */
public class Demo1 {


    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] nums = new int[3];

        System.out.println(nums[1]);
        System.out.println(nums[2]);
        System.out.println("nums[3] = " + nums[3]);

        // 注：由于Java代码最终需要解释执行，所以产生异常之前的代码是可以正常执行的。

    }

}
