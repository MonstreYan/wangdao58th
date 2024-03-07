package com.cskaoyan._04oop1._12block;

/**
 * 给静态成员变量赋值的方式。
 * 1. 默认初始化，具有默认值
 * 2. 显式赋值
 * 3. 静态代码块
 *
 * @author Common-zhou
 * @since 2024-03-07 15:54
 */
public class Demo6 {
    public static MyConnection myConnection ;

    static {
        // 静态代码块
        name = "lisi";

        // 在静态代码块中，完成对一些复杂变量的初始化。

        // myConnection = new MyConnection(1,2,3,4,5,6,7,98,5,12,5,5,54);
    }

    public static String name = "zhangsan";


    public static void main(String[] args) {
        // 显式赋值和静态代码块， 按照上下顺序执行
        // 哪个在上面，哪个先执行。
        System.out.println(name);
    }

}


class MyConnection {
    // 假设这个构造方法，非常的复杂。
    // 20个参数。  所以不太好构建，现在可以把这个复杂的代码，放在构造代码块执行。
}
