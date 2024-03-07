package com.cskaoyan._04oop1._12block;

/**
 * 现在，学习了很多变量赋值手段。
 * 1.默认初始化
 * 2.显式赋值
 * 3.构造代码块
 * 4.构造方法。
 * <p>
 * 现在，需要梳理一下，他们的执行顺序。
 * 在梳理之前，首先完成掐头去尾。 在所有的赋值手段中，默认初始化一定是在第一位。
 * 构造器，一定是在最后的。
 * <p>
 * 现在，我们很关心：显式赋值和构造代码块的执行顺序。
 * 结论： 他们两个没有明显顺序。 按谁在前，谁先执行的顺序来。
 *
 * 编译了代码之后，发现编译之后，不存在构造代码块。这个代码全部插入了，构造器中。
 *
 * @author Common-zhou
 * @since 2024-03-07 15:16
 */
public class Demo2 {

    // 显式赋值在上面的时候，先执行的上面。
    int testFlag1 = 10;

    {
        // 构造代码块中
        testFlag1 = 100;

        testFlag2 = 200;
    }


    int testFlag2 = 20;


    public Demo2() {

    }

    public Demo2(int testFlag1) {
        this.testFlag1 = testFlag1;
    }


    public static void main(String[] args) {
        Demo2 demo2 = new Demo2(1000);

        System.out.println("demo2.testFlag1 = " + demo2.testFlag1);
    }
}
