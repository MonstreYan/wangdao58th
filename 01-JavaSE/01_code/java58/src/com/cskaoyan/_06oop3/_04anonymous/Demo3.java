package com.cskaoyan._06oop3._04anonymous;

/**
 * main方法不能动
 * 不修改main方法和接口Inter的前提下，补齐Outer类代码，要求在控制台输出HelloWorld
 *
 * @author Common-zhou
 * @since 2024-03-13 11:24
 */
public class Demo3 {
    public static void main(String[] args) {
        // Outer
        // 这是个静态方法。： 因为现在使用类名.方法() 调用的方法
        Outer.method().show();
    }
}

interface Inter {
    void show();
}

class InterSon implements Inter {
    @Override
    public void show() {
        System.out.println("HelloWorld1");
    }
}

class Outer {

    static class StaticInterInner implements Inter {

        @Override
        public void show() {
            System.out.println("HelloWorld2");
        }
    }

    public static Inter method() {
        // 怎么返回一个Inter的子类。 让这个子类，打印 HelloWorld

        // 1.直接在外面定义一个类
        // return new InterSon();

        // 2.定义一个静态内部类
        // return new StaticInterInner();

        // 3.局部内部类。
        // class InterInnerMethod implements Inter {
        //     @Override
        //     public void show() {
        //         System.out.println("HelloWorld3");
        //     }
        // }
        // return new InterInnerMethod();

        return new Inter() {
            @Override
            public void show() {
                System.out.println("HelloWorld4");
            }
        };


    }
}
