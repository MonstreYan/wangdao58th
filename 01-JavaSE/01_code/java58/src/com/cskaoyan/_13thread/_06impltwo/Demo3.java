package com.cskaoyan._13thread._06impltwo;

/**
 * 00后，整顿职场。
 * <p>
 * 多线程实现方式2：
 * 1.写一个类，实现Runnable
 * 2.重写run方法
 * 3.创建一个子类对象
 * 4.创建一个线程对象  new Thread()。 把刚刚创建的子类对象作为参数传递进去。
 * 5.调用start。
 *
 * @author Common-zhou
 * @since 2024-03-22 14:35
 */
public class Demo3 {

    public static void main(String[] args) {
        MyRunnable3 myRunnable3 = new MyRunnable3();

        Thread thread1 = new Thread(myRunnable3);

        System.out.println(Thread.currentThread().getName() + "===>start");
        thread1.start();
        System.out.println(Thread.currentThread().getName() + "===>end");


        // 内部类、内部类对象、lambda表达式。


        System.out.println("============================");

        //
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "===>-------start");
            }
        };
        new Thread(runnable).start();


        // 直接传入一个匿名内部类对象进去。
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "===>-------start2");
            }
        }).start();


        // Anonymous new Runnable() can be replaced with lambda
        // 也可以使用idea提供的替换功能。
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "===>-------start2")).start();

        // lambda表达式的形式
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "===>-------start2");
        }).start();


    }
}


class MyRunnable3 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "===>start");
        System.out.println(Thread.currentThread().getName() + "===>end");
    }
}
