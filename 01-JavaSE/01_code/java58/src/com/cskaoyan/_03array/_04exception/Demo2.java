package com.cskaoyan._03array._04exception;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-04 11:38
 */
public class Demo2 {

    @Test
    public void test1() {
        // 为什么我们要学数组相关的异常
        // 1.了解了这些异常，写代码的时候。碰到了这些异常。 才知道怎么解决。
        // 2.提前了解。 写代码的时候才能预防。
    }


    @Test
    public void test2() {
        // 数组下标越界异常
        // 这个异常在数组操作中很常见，尤其是在循环当中，当你误判了循环的变量是非常容易下标越界的。
        int[] nums = {1, 12, 9};

        for (int i = 0; i <= nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    @Test
    public void test3() {
        // 什么是null
        // 在Java中，可以理解为 null就是空。  但是不等于没有初始化

        // s1目前叫做没有被初始化。
        String s1;

        // System.out.println(s1);
        // System.out.println(s1.length());

        // s2叫做null。 但是要注意。 它已经初始化了。
        String s2 = null;
        System.out.println(s2);
        // System.out.println(s2.length());
    }

    @Test
    public void test4() {

        // 如果你给数组初始化的时候，初始化了一个值。 是null。 这时候再去访问， 会出现一个问题。
        // 空指针。

        // java.lang.NullPointerException: Cannot read the array length because "nums" is null
        int[] nums = null;
        // System.out.println(nums.length);


        // 如何避免空指针异常。 通过if 来进行判断
        // if (nums.equals(null)){
        if (nums != null){
            // 和null进行比较的时候。 用  ==
            System.out.println(nums.length);
        }
    }
}
