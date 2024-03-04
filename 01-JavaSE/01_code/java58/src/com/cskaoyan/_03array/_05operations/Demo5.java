package com.cskaoyan._03array._05operations;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-04 15:08
 */
public class Demo5 {

    @Test
    public void testReverse1() {
        // 逆序。
        //   1   6   9   3   7
        //  7    3  9   6    1

        // 遍历。 并且将对应位置的值换一下。 这时候可以完成逆序

        //  0     length-1  两位置的数据换一下
        //  1    length-2
        // 循环的时候，一定要注意。 只能访问一半的数据。
        int[] nums = {1, 6, 9, 3, 7};

        // 我怎么判断，这种需不需要 -1  -2 ， 不减。
        // 带入进去试一下。  不要去记。
        // 你把实际的边界情况带入进去试一下， 你就知道。 这里是否需要  -1 -2
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length / 2; i++) {
            // i=0
            int temp = nums[i];

            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] arr = {1, 6, 9, 3, 7};


        //   1       6        9        3        7
        //   start=0                          end=length-1
        //           1                length-2
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}
