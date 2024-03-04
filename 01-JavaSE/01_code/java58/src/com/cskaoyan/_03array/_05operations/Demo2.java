package com.cskaoyan._03array._05operations;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-04 14:41
 */
public class Demo2 {
    @Test
    public void test1() {
        // 如果只是想看数组中的元素。可以使用JDK内部提供的一个方法。 方便的输出数据

        int[] nums = {10, 22, 29};

        // Arrays.toString() 只用来观察数据。 如果你想统计数据， 这个没有办法用
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));

        // 比如，现在数组中存储的是班级中语文分数。 想统计一下，有多少同学80分以上。

        // 今后，要看数组里面的内容，一定要用这个方法。  不要直接打印数组名。
    }
}
