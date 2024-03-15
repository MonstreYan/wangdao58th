package com.cskaoyan._08othercls._01wrapper;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-15 17:36
 */
public class Demo6 {
    @Test
    public void test1() {
        // 面试题1：
        // 三元运算符。
        // 三元运算符里面，结果的类型。取决于最大范围的类型。
        // obj是个Double
        // 1
        Object obj = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj); // 1.0
        System.out.println(obj.getClass()); //Double
    }

    @Test
    public void test2() {
        Object obj;
        // 这是不是三目运算符。
        if (true) {
            obj = new Integer(1);
        } else {
            obj = new Double(2.0);
        }
        System.out.println(obj);  // 1
        System.out.println(obj.getClass()); // Integer
    }
}
