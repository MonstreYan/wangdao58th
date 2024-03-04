package com.cskaoyan._03array._05operations;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-04 14:45
 */
public class Demo3 {
    @Test
    public void test1() {
        // for(数据类型 变量名 : 要遍历的数组或者集合){
        //     System.out.println(变量名);
        // }

        int[] nums = {60, 65, 90};
        for (int num : nums) {
            // 这个num。就可以拿到里面的一个一个的数据
            System.out.println(num);
        }
        // 增强for循环。可以用于拿数组中的每一个元素。
    }

    @Test
    public void test2() {
        int[] nums = {60, 65, 90};

        // nums.for  在idea中。只要这样写， 点击enter， 这时候会自动生成foreach的代码。
        for (int element : nums) {
            System.out.println(element);
        }

        // foreach的底层是一个fori循环。
    }

    @Test
    public void test3() {
        // fori  foreach
        // 什么情况下，用fori， 什么情况用foreach

        // 需要获取下标的时候。  用 fori
        // 如果只是想统计数据。   fori  foreach.  推荐用foreach


    }
}
