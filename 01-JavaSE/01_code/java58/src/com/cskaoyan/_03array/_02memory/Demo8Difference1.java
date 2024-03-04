package com.cskaoyan._03array._02memory;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-04 10:32
 */
public class Demo8Difference1 {
    @Test
    public void test2() {
        // 在堆上的数据是有默认值的。
        // 在堆上的数据，我们没有进行赋值。 但是还是有值
        int[] nums = new int[10];

        System.out.println(nums[0]);
        System.out.println(nums[2]);


        // 在栈上的数据没有默认值，必须进行显式初始化之后，才能使用。
        // Variable 'a' might not have been initialized
        int a;
        // System.out.println(a);

    }

    @Test
    public void test3() {
        // 关于生命周期的不同。
        // int[] nums = new int[10];

        // 方法的调用。
        // 可以自动生成方法。  先调用。 再声明这个方法。
        // alt + enter
        test4();
    }

    private void test4() {
        int a = 10;

        int[] nums = new int[5];
    }


    @Test
    public void test5() {
        // 问题： 是不是基本数据类型存储在栈上，引用数据类型存储在堆上。
        /// 不是的。
        int a = 10;
        int[] b = new int[5];

    }


}
