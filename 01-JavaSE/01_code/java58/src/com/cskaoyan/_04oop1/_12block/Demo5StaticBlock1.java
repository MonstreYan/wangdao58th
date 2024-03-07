package com.cskaoyan._04oop1._12block;

/**
 * 定义在类的成员位置，使用以下声明方式声明的代码块，称之为静态代码块
 * <p>
 * static{
 * // 这个就是静态代码块
 * }
 * 随着类加载的过程而执行，静态代码块可以看成是一个在类加载过程中，会自动调用的静态方法！用于给静态成员变量赋值！
 * <p>
 * 随着类加载的过程而执行，静态代码块可以看成是一个在类加载过程中，会自动调用的静态方法！用于给静态成员变量赋值！
 * <p>
 * 这里还是想再强调一下：一般的静态成员方法是调用才会执行，并不是类加载过程中就会自动调用执行它！
 * <p>
 * 想要一段语句，能够在类加载过程中自动被调用，需要使用静态代码块，而不是静态方法！！
 *
 * @author Common-zhou
 * @since 2024-03-07 15:50
 */
public class Demo5StaticBlock1 {
    static {
        int a = 10;
        System.out.println(a);

        System.out.println("static block be invoked");
    }

    public static void test1() {
        // invoke  调用
        System.out.println("test method be invoked!");
    }

    public static void main(String[] args) {
        System.out.println("main method");
    }
}
