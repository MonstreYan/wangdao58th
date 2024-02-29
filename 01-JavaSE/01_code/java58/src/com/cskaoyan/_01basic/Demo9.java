package com.cskaoyan._01basic;

/**
 * @author Common-zhou
 * @since 2024-02-29 16:24
 */
public class Demo9 {
    public static void main(String[] args) {
        // 变量：程序运行过程中，值可能会发生改变的量（注重变化的可能性而不是确定性）。
        // 在程序运行期间，随时可能产生一些临时数据，应用程序会将这些数据保存在一些内存单元中，
        // 每个内存单元都用一个标识符来标识。这些内存单元我们称之为变量，定义的标识符就是变量名，
        // 内存单元存储的数据就是变量的值。


        // 局部变量，就是定义在局部位置的变量。
        // 什么是局部位置：在Java中,使用 {} 括起来的范围，就称为局部位置。

        // 局部变量，一定要注意作用域。
        int num = 10;

        // 在这能不能访问 num
        System.out.println(num);

        if (true) {
            // 局部变量。
            int flag = 15;

            // 在这，能不能访问 num
            System.out.println(num);

            // 在这，能否访问 flag
            System.out.println(flag);
        }

        // System.out.println(flag);

    }


    {
        int i = 10;

    }
}
