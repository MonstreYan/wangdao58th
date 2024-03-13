package com.cskaoyan._06oop3._04anonymous;

/**
 * @author Common-zhou
 * @since 2024-03-13 11:13
 */
public class Demo2 {
    public static void main(String[] args) {
        // 匿名内部类对象：就是指的一个 继承/实现了某一个接口的子类对象，但是它没有名字。
        // new 类名/接口名(){
        //  // 子类中具体方法
        // }

        // 这个就是一个匿名内部类。 匿名内部类对象
        new Play2() {

            @Override
            public void play() {
                System.out.println("匿名内部类的实现 Play2");
            }

            @Override
            public void play2() {
                System.out.println("匿名内部类的实现 Play");
            }
        }.play2();




        Play2 play2 = new Play2() {
            @Override
            public void play() {
                System.out.println("匿名内部类的实现 Play2");
            }

            @Override
            public void play2() {
                System.out.println("匿名内部类的实现 Play");
            }

            public void test3() {

            }
        };

        // 编译看左边，运行看右边
        // 编译看左边： 就是指的，左边是什么类型（父类、父接口），在编译的时候只能点出来这些方法。
        // 运行看右边： 右边实际类型是什么，就调用这个实际类型的方法。
        play2.play2();

        // 匿名内部类的使用
        // 1.直接在后面调用方法。如果有时候，你就只想简单调用一下这个方法， 这时候可以使用这种方式。
        // 有啥问题。 使用简单。 但是对于如果要调用多个方法， 需要一次创建一个对象，很麻烦。
        // 2.用父类来接收。 父类、父接口都可以
    }
}

interface Play2 {
    void play();

    void play2();
}

class SonClazz {

}
