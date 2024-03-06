package com.cskaoyan._04oop1._08example;

/**
 * 2.在测试类中写一个方法，交换两个Student对象的引用（地址）
 * 请问能够交换成功吗？原因是什么？
 *
 * 改引用。出了方法没有效果。
 * 但是改引用，里面的属性，就会有效果。
 *
 * @author Common-zhou
 * @since 2024-03-06 11:34
 */
public class Demo4 {
    public static void main(String[] args) {
        Student2 s1 = new Student2();
        s1.name = "zhangsan";
        s1.age = 18;

        Student2 s2 = new Student2();
        s2.name = "lisi";
        s2.age = 28;

        swapReference(s1, s2);

        System.out.println("main=======================");

        // zhangsan-->18
        s1.showAge();
        // lisi-->28
        s2.showAge();
    }

    private static void swapReference(Student2 s1, Student2 s2) {

        Student2 student2 = s1;
        s1 = s2;
        s2 = student2;

        System.out.println("swapReference=======================");
        // lisi-->28
        s1.showAge();
        // // zhangsan-->18
        s2.showAge();
    }
}
