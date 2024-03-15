package com.cskaoyan._06oop3._03inner._04local;

/**
 * @author Common-zhou
 * @since 2024-03-13 10:20
 */
public class Demo1 {

    public void test1() {
        // 这个是不是局部位置。

        // 访问权限修饰符不能加。 static也不能加
        class Test1 {
            int age = 10;

            // 这个就是JDK16加上去。
            // static int age2 = 20;
            //
            // static {
            //     age2 = 30;
            // }
        }

        // 这个就是局部内部类。 定义在局部位置的类。


    }
}
