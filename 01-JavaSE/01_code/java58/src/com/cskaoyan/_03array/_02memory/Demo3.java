package com.cskaoyan._03array._02memory;

/**
 * @author Common-zhou
 * @since 2024-03-02 11:45
 */
public class Demo3 {
    public static void main(String[] args) {
        // 数组的声明和初始化。
        int[] nums = new int[5];
        // 只要是new，就会在堆上开辟空间。
        // 栈上面也有东西，栈上存的是地址。

        // 程序计数器。 就是记录当前正在执行的行数。
        test1();

        System.out.println(nums);

    }

    public static void test1() {

        // 会执行test1里面的逻辑。

    }
}
