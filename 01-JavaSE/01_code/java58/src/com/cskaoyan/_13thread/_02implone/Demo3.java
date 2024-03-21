package com.cskaoyan._13thread._02implone;

/**
 * 特点1： 多线程的执行特点是随机的。（针对的是线程和线程之间，在线程内部，还是顺序。 ）
 *
 * @author Common-zhou
 * @since 2024-03-21 17:44
 */
public class Demo3 {
    public static void main(String[] args) {
        MyThread3 myThread31 = new MyThread3();
        MyThread3 myThread32 = new MyThread3();

        myThread31.start();
        myThread32.start();
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "===>" + i);
        }
    }
}
