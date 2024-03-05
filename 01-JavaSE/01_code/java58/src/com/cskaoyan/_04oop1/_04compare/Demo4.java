package com.cskaoyan._04oop1._04compare;

/**
 * 给成员变量赋值的方式。
 * 1.默认初始化，具有默认值。
 * 2.显式赋值。
 * public String address = "China";
 *
 * 显式赋值和默认初始化赋值的顺序，任何时候都要记住，
 * 对象中的元素，默认初始化永远是第一步！在任何给成员变量赋值的手段执行前，默认初始化都已经执行了！
 * 可以认为默认初始化是JVM在创建对象的内存结构时，它"顺手"给出的！
 * 最开始的时候，虽然有显式赋值，但是在真正执行过程中，永远是先进行默认初始化， 之后再将值设置进去。
 *
 * @author Common-zhou
 * @since 2024-03-05 14:44
 */
public class Demo4 {
    public static void main(String[] args) {
        Teacher4 teacher4 = new Teacher4();
        System.out.println("teacher4.name = " + teacher4.name);

        // 可以显式赋值。
        System.out.println("teacher4.address = " + teacher4.address);

    }
}


class Teacher4 {
    public String name;
    public String address = "China";

}
