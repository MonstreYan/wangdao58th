package com.cskaoyan._06oop3._04anonymous;

/**
 * 匿名内部类。
 * 我们已经使用过匿名对象了，匿名对象的含义是这个对象是没有名字，
 * 没有引用指向它。那么匿名内部类，指的就是这个内部类没有名字。
 * 当然成员内部类和静态内部类没法没有名字，所以 匿名内部类指的是"没有名字的局部内部类"。
 *
 * @author Common-zhou
 * @since 2024-03-13 11:07
 */
public class Demo1 {

    public void test1() {
        System.out.println("1111");
    }

    public static void main(String[] args) {
        // 匿名：就是指没有名字。
        new Demo1();
        new Demo1().test1();

        // 在这里的局部内部类。


        // 匿名内部类。 就是定义在局部位置的 内部类。 没名字。


        // new 类名/接口
        //
        new Play1(){
            @Override
            public void play() {

            }
        };


    }
}

interface Play1 {
    void play();
}
