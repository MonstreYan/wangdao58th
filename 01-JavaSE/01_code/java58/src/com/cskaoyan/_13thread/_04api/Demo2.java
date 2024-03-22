package com.cskaoyan._13thread._04api;

/**
 * 另外一种设置线程名的方式
 * 通过构造方法，直接设置名字
 *
 * @author Common-zhou
 * @since 2024-03-22 10:36
 */
public class Demo2 {
    public static void main(String[] args) {
        // 可以通过构造方法的方式，将线程名传入。
        MyThread2 myThread21 = new MyThread2("蜜雪冰城");
        MyThread2 myThread22 = new MyThread2("蜜雪冰城");

        myThread21.start();
    }
}

class MyThread2 extends Thread {

    public MyThread2() {
    }

    public MyThread2(String name) {
        // 这个就是你传一个name（线程名）。然后顺手带给父类
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
