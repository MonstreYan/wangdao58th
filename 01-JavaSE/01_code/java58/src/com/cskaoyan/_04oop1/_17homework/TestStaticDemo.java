package com.cskaoyan._04oop1._17homework;

/**
 * 类加载（JVM已经把这个类的代码搞进来了。）  就已经知道，里面有哪些变量，有哪些方法。
 * static： 不是和这个过程相关的。
 * 连接： 把该用的类型。 连接上
 * 初始化: 昨天理解的加载过程。 也就是它会调用 static  代码块这种东西。
 *
 * 只要开始执行static这种代码块，那说明已经类加载完成了。执行static，只是在完成初始化而已。
 * 只是在完成 static代码块。 显式赋值这些任务而已。
 *
 * 所有的赋值顺序：
 * 1.默认初始化
 * 2.(构造代码快)
 * 3.（显式初始化）
 * 4.构造器赋值
 *
 */
public class TestStaticDemo {
    public static void main(String[] args) {
        staticMethod();
    }

    static TestStaticDemo ts = new TestStaticDemo();
    //static  java.lang.String  s = "";
    // static String s = "";

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }

    public TestStaticDemo() {
        System.out.println("无参构造器");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticMethod() {
        System.out.println("静态成员方法");
    }

    int a = 666;
    static int b = 777;
    static TestStaticDemo ts2 = new TestStaticDemo();
}
