package com.cskaoyan._13thread._04api;

/**
 * @author Common-zhou
 * @since 2024-03-22 11:00
 */
public class Demo3 {
    public static void main(String[] args) {
        MyThread3 myThread31 = new MyThread3();
        MyThread3 myThread32 = new MyThread3();

        myThread31.setName("王道景天");
        myThread32.setName("王道吴彦祖");

        //
        myThread31.setPriority(1);
        myThread32.setPriority(10);

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
