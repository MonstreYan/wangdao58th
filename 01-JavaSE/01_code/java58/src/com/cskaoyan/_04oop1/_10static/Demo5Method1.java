package com.cskaoyan._04oop1._10static;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-07 11:18
 */
public class Demo5Method1 {

    @Test
    public void test1() {
        // - 无需创建对象就可以直接通过类名点直接调用。
        // - 同一个类中的static方法互相调用可以省略类名，直接用方法名调用。（这就是我们之前方法的调用）

        // 静态成员方法， 无需创建对象，可以直接通过类名调用。
        Player5.test1();

        // 在同一个类中，调用static方法，可以省略类名
        test2();
        Demo5Method1.test2();

    }


    //
    public static void test2() {
        System.out.println("Demo5Method1 test2 static method");
    }

}

class Player5 {
    // 静态成员方法的语法。
    // [权限修饰符] static 返回值类型 方法名(形参列表){}
    public static void test1() {
        System.out.println("Player5 test1 static method.");
    }
}
