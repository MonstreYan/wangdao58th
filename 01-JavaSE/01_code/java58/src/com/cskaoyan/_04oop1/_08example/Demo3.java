package com.cskaoyan._04oop1._08example;

/**
 * 练习：
 * 定义一个学生类，该类具有一个int属性age
 * 1.在测试类中写一个方法，交换两个Student对象的age属性
 * 请问能够交换成功吗？原因是什么？
 * <p>
 *
 *
 * @author Common-zhou
 * @since 2024-03-06 11:23
 */
public class Demo3 {
    public static void main(String[] args) {
        Student2 s1 = new Student2();
        s1.name = "zhangsan";
        s1.age = 18;

        Student2 s2 = new Student2();
        s2.name = "lisi";
        s2.age = 28;

        swapAge(s1, s2);

        s1.showAge();
        s2.showAge();

    }

    private static void swapAge(Student2 s1, Student2 s2) {
        // 怎么交换？
        int temp = s1.age;
        s1.age = s2.age;
        s2.age = temp;

        // 在这里看。 年龄发生变化没有？
        // 变了

        s1.showAge();
        s2.showAge();
    }
}

