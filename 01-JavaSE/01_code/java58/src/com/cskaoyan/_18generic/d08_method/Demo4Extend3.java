package com.cskaoyan._18generic.d08_method;

/**
 * ② ? extends E
 * 向下限定，E及其子类.    ? extends Number ;  E extends Number
 * ③ ? super E
 * 向上限定，E及其父类
 *
 *  自己写代码不会用。 但是源码里面有。
 *
 * @author Common-zhou
 * @since 2024-03-28 11:39
 */
public class Demo4Extend3 {

    // 允许接收 Number及Number的子类。
    public <E extends Number> E test1(E e) {
        // Number

        // Integer
        // Double

        System.out.println("====" + e);
        return e;
    }

    public static void main(String[] args) {
        Demo4Extend3 demo4Extend3 = new Demo4Extend3();

        Integer i1 = 10;

        demo4Extend3.test1(i1);

        // demo4Extend3.test1("123");


    }

}
