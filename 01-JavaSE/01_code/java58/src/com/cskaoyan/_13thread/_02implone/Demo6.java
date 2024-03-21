package com.cskaoyan._13thread._02implone;

/**
 * @author Common-zhou
 * @since 2024-03-21 17:56
 */
public class Demo6 {
    public static void main(String[] args) {



    }
}

class MyThread6 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + "===>" + i);
        }
    }
}
