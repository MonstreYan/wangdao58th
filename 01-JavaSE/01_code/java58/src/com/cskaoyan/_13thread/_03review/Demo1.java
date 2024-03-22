package com.cskaoyan._13thread._03review;

/**
 * 多线程实现方式1：
 * 1.继承Thread类
 * 2.重写run方法
 * 3.创建子类对象
 * 4.调用start方法。
 * <p>
 * 1.多线程的执行特点： 随机性。 在线程之间是随机的。
 * 有两线程，它们两个之间执行的特点是随机的。 没有明显的先后顺序
 * 2.一定要调用start方法。 不要调用run。
 * 3.
 *
 * @author Common-zhou
 * @since 2024-03-22 10:26
 */
public class Demo1 {
    public static void main(String[] args) {
        // MyThread myThread = new MyThread();
        //
        // System.out.println("main start");
        // myThread.start();
        // System.out.println("main end");


        MyThread2 myThread21 = new MyThread2();
        MyThread2 myThread22 = new MyThread2();

        myThread21.start();
        myThread22.start();


    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "====>" + "start");
        System.out.println(Thread.currentThread().getName() + "====>" + "end");
    }
}


class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "===>" + i);
        }
    }
}
