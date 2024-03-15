package com.cskaoyan._07object;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-15 10:21
 */
public class Demo2ToString {

    @Test
    public void test1() {
        // 这个是JDK的官方文档说明
        // 1. 返回该对象（调用toString方法的对象）的字符串表示。
        Demo2ToString demo2ToString = new Demo2ToString();
        Demo2ToString demo2ToString2 = new Demo2ToString();

        String string = demo2ToString.toString();
        System.out.println(string);


        // 2. 通常，toString() 方法会返回一个 "以文本方式表示" 此对象的字符串。
        // 3. 结果应是一个简明但易于读懂的信息表达式。

        // 对于一个对象。大家关注什么东西？ ==》 我们关心里面的成员变量取值。

        // 4. 建议所有子类都重写此方法。

        // 如果重写了该方法， 调用toString， 返回的是重写过的方法返回的字符串。

    }


    @Test
    public void test2() {
        // toString就是把一个对象转换为用字符串描述的。 而且应该简单易懂
        // 现在，来看一下JDK的默认实现。

        Object o = new Object();
        // 如果大家想自己看一下 方法。 可以这样写。
        o.toString();
    }

    @Test
    public void test3() {
        // 全限定类名： 包名 + 类名
        Object o = new Object();
        o.toString();

        // return getClass().getName() + "@" + Integer.toHexString(hashCode());
        // 全限定类名  + @ + 十六进制表示的地址。
        Demo2ToString demo2ToString = new Demo2ToString();

        String name = demo2ToString.getClass().getName();
        System.out.println(name);

        // hashCode: 在默认情况下。 返回就是该对象的地址。
        // Integer.toHexString()  : 把数转成16进制。

        // 10  ===》 a
        // 0 1
        // 0 1 2 3 4 5 6 7 8 9
        // 0 1 2 3 4 5 6 7 8 9 a b c d e
        // 16进制。
        System.out.println(o.toString());
    }

    @Test
    public void test4() {
        // toString在代码中的作用。
        // 1.如果在代码中，直接打印该对象，出来的就是toString的结果。
        Demo2ToString demo2ToString = new Demo2ToString();
        // Unnecessary 'toString()' call  ==》 调不调toString都一样。
        System.out.println(demo2ToString.toString());
        System.out.println(demo2ToString);

        // 2.如果对象，参与字符串的拼接。 这时候也是使用toString的结果进行
        String s = demo2ToString + "===";
        System.out.println(s);

    }
}
