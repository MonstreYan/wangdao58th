package com.cskaoyan._09string._03feature;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-18 11:15
 */
public class Demo4 {

    @Test
    public void test1() {
        // 关注输出什么
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2); //  false
        System.out.println(s1.equals(s2)); // true
        // ==就是比较地址；  equals就是比较内容。

        String s3 = new String("hello");
        String s4 = "hello";
        System.out.println(s3 == s4); // false
        System.out.println(s3.equals(s4)); // true

        String s5 = "hello";
        String s6 = "hello";
        System.out.println(s5 == s6); // true
        System.out.println(s5.equals(s6)); // true
    }


    @Test
    public void test2() {
        // equals方法是Object的方法,默认是比较2个对象的地址,若要比较内容,应当重写父类方法
        // Object 中有一个equals方法。
        // equals的方法的默认实现，是比较地址。 this==target
        // 如果子类重写了这个方法，这时候一般比较内容。
        // String这个类，我们有没有重写equals。 没有。但是现在比较的就是内容
        // 已经被重写过了。


        String s = "hello";

        s.equals("hello");

        // String类的中equals方法，就是逐个比较字符串的内容，如果字符串内容相同，则true。 否则，是false。

    }
}
