package com.cskaoyan._13thread._02implone;

/**
 * 1.创建一个类。继承Thread
 * 2.重写run方法。
 * 3.创建子类对象
 * 4.调用  start启动线程
 *
 * @author Common-zhou
 * @since 2024-03-21 17:41
 */
public class Demo2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();

        myThread2.start();

        System.out.println("main method");
    }
}


class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start");
        System.out.println(Thread.currentThread().getName() + "end");
    }
}

