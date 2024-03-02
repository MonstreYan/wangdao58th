package com.cskaoyan._03array._01define;

import org.junit.Test;

import java.util.Arrays;

/**
 * 对数组的基本访问。
 * 1.直接打印数组名。
 * 可以得到类似于这样的东西。
 * [I@256216b3
 * [ 表示这是一个数组。
 * I ： 表示这是int类型
 *
 * @author Common-zhou
 * @是分割付 256216b3 ：  这是地址。
 * @since 2024-03-02 10:31
 */
public class Demo5Get {
    // @Test有点类似于 main方法。
    // @Test是放在一个方法上面的
    // 这个方法， 一定是 public   void ；   一定不能有参数
    //
    @Test
    public void test1() {
        System.out.println("test1");
        // return 1;

        int[] nums = {1, 2, 3};

        System.out.println(nums);

        // 直接打印这个数组名，对程序员，意义不大。 我们关心里面的元素。
        // 建议使用 Arrays.toString  可以打印出来里面的内容。

        // Arrays.toString 就是将数组中的数据，组装起来，变成一个字符串返回给你。
        String string = Arrays.toString(nums);

        System.out.println(string);
    }


    @Test
    public void test2() {

        int[] nums = {1, 2, 3};

        int num = nums[0];
        int num2 = nums[1];
        int num3 = nums[2];
        System.out.println(num);
        System.out.println(num2);
        System.out.println(num3);
    }

    @Test
    public void test3() {
        String[] teaList = {"霸王茶姬", "茶百道", "沪上阿姨", "瑞幸", "星巴克"};

        // 挨个访问一下。 在数组中，下标是从0开始的。

        // teaList[0].sout
        // teaList[0].soutv
        System.out.println(teaList[0]);
        System.out.println("teaList[0] = " + teaList[0]);
        // System.out.println(teaList[0]);

        System.out.println("teaList[4] = " + teaList[4]);
        // ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
        // System.out.println("teaList[5] = " + teaList[5]);
    }



}
