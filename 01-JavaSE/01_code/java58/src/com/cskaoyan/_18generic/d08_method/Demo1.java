package com.cskaoyan._18generic.d08_method;

/**
 * @author Common-zhou
 * @since 2024-03-28 11:18
 */
public class Demo1 {

    public static void main(String[] args) {
        // 泛型方法： 就是把泛型定义在方法上面。
        // 泛型方法，认识即可。

        A a = new A();

        String s = a.test1("123");
        Integer i = a.test1(12);
    }

}


// 这是一个类
class A {

    // 定义了一个泛型在方法上面。
    public <E> E test1(E e) {
        return e;
    }

}
