package com.cskaoyan._04oop1._12block;

/**
 * 构造代码块：
 * 就是定义在成员位置的一个代码块。 使用  {}进行划分。
 * 需要注意的点： 这个东西属于局部位置，所以变量出了这个局部位置， 就访问不到了
 *
 * 随着构造器的执行，用于在创建对象过程中，给成员变量赋值
 *
 * @author Common-zhou
 * @since 2024-03-07 15:10
 */
public class Demo1 {
    {
        // 这个就叫做构造代码块

        int a = 10;
        System.out.println(a);
    }


    public void test1() {
        // System.out.println(a);
    }


}
