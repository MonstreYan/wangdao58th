package com.cskaoyan._03array._02memory;

/**
 * JVM栈（简称栈。）： 描述的是一个普通方法所占的内存模型
 * <p>
 * 方法在执行的过程中，会有一些局部变量。这些局部变量需要存储。
 *
 * 这些局部变量，会存放在一个叫做栈帧的地方。 （狗熊的饼子。 ）
 *
 * @author Common-zhou
 * @since 2024-03-02 11:20
 */
public class Demo1 {
    public static void main(String[] args) {
        // 现在，要执行main方法。
        test1();

    }

    public static void test1() {
        int i = 10;

        System.out.println(i);
        for (int j = 0; j <10; j++) {
            //在这个方法的执行过程中，会产生一些中间变量。 这些变量都会存储。
        }
    }
}
