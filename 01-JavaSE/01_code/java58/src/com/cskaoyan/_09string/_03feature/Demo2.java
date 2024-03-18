package com.cskaoyan._09string._03feature;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-18 10:18
 */
public class Demo2 {
    @Test
    public void test1() {
        // 字符串的分配和其他对象分配一样，是需要消耗高昂的时间和空间的，而且字符串使用的非常多
        // JVM为了提高性能和减少内存的开销，在实例化字符串对象的时候进行了一些优化：
        // 使用字符串常量池,来提高字符串创建性能。

        String s = "hello";

        // "hello"这个东西，是字符串 ，是对象。

    }

    @Test
    public void test2() {
        // 每当创建字符串常量对象时，JVM会首先检查字符串常量池，如果该字符串对象引用已经存在常量池中，
        // 那么就直接返回常量池中的实例引用。如果字符串对象引用不存在于常量池中，就会实例化该字符串并且将其引用放到常量池中。

        // 用双引号引起来的东西，就叫做字符串常量。
        String s1 = "hello";

        String s = new String(s1);
    }


    @Test
    public void test3() {

        // 只对  “字符串常量对象” 增强。
        // 每当创建字符串常量对象时，JVM会首先检查字符串常量池，如果该字符串对象引用已经存在常量池中，
        // 那么就直接返回常量池中的实例引用。如果字符串对象引用不存在于常量池中，就会实例化该字符串并且将其引用放到常量池中。
        String s1 = "world";
        String s2 = "world";

        String s3 = new String("world");

        System.out.println("s1.equals(s2) = " + s1.equals(s2));
        System.out.println("(s1 == s2) = " + (s1 == s2));

        System.out.println("s1.equals(s3) = " + s1.equals(s3));
        System.out.println("(s1 == s3) = " + (s1 == s3));

        // 今后，凡是。引用数据类型的比较。 都用equals方法，equals方法，比较的是内容。
    }


    @Test
    public void test5() {
        // 字符串常量池： 针对字面值字符串常量。JVM认为你会经常使用String，所以针对这块，做了优化。 使用字符串常量池。
        // 当你使用一个字符串常量的时候，JVM会首先，去常量池中找，找到了，就用常量池中的对象； 找不到，就新建一个，然后把新建的加入常量池。

        // 字符串常量的时候，才会去常量池。  "hello"叫做字符串常量
        String s1 = "hello";
        String s2 = "hello";

        String s3 = new String("hello");
        String s4 = new String("hello");


        System.out.println("(s1== s2) = " + (s1 == s2));// true
        System.out.println("(s2==s3) = " + (s2 == s3)); // false
    }

}
