package com.cskaoyan._03array._04exception;

/**
 * @author Common-zhou
 * @since 2024-03-04 14:30
 */
public class Demo4 {
    public static void main(String[] args) {
        // 数组长度为0和数组是null以及数组未初始化，有啥区别？

        // 数组长度为0
        // - 不能访问任何数组下标，否则都会抛出数组下标越界异常。
        // - 输出数组的长度为0
        int[] nums = new int[0];
        System.out.println(nums);
        // System.out.println(nums[0]);
        System.out.println(nums.length);

        // 数组是null
        int[] nums2 = null;
        // 直接打印 为null的数组。 会得到一个null
        System.out.println(nums2);
        // System.out.println(nums2.length);

        // 数组未初始化: 数组未初始化： 这个数组完全是不可用的，没有初始化的数组毫无意义，一旦使用会编译报错。
        int[] nums3;

        // System.out.println(nums3);
        // System.out.println(nums3.length);


    }
}
