package com.cskaoyan._03array._06vp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-04 16:06
 */
public class Demo3 {
    @Test
    public void test1() {
        // 在Java中，只存在值传递。
        int[] nums1 = {10, 20, 30};
        int[] nums2 = {111, 222, 333};
        // nums1  10 20 30
        // nums2  111 222 33

        swap(nums1, nums2);
        System.out.println("test1: nums1 = " + Arrays.toString(nums1));
        System.out.println("test1: nums2 = " + Arrays.toString(nums2));
    }

    private void swap(int[] nums1, int[] nums2) {
        // nums1 = 10 20 30
        // nums2 = 111 222 333
        int[] temp = nums1;
        nums1 = nums2;
        nums2 = temp;

        System.out.println("swap: nums1 = " + Arrays.toString(nums1));
        System.out.println("swap: nums2 = " + Arrays.toString(nums2));
        // 这两个数组的值，是否会被换过来。
    }


    @Test
    public void test2() {
        int[] nums1 = {111, 222, 333};

        // 在Java中，只有值传递。

        changArrayValue(nums1);
        System.out.println("test2:" + Arrays.toString(nums1));
    }

    private void changArrayValue(int[] nums1) {
        // nums1 = new int[]{10, 20, 30, 40};

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = i;
        }

        // System.out.println("changArrayValue:" + Arrays.toString(nums1));

        nums1[0] = 666;
        System.out.println("changArrayValue:" + Arrays.toString(nums1));
    }
}
