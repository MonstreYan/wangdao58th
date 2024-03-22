package com.cskaoyan._13thread._08sync;

import java.util.concurrent.TimeUnit;

/**
 * synchroized 关键字 放在成员方法上。锁对象是this
 *
 * @author Common-zhou
 * @since 2024-03-22 16:18
 */
public class Demo6 {
    public static void main(String[] args) throws InterruptedException {

        MyRunnable5 myRunnable5 = new MyRunnable5();
        Thread t1 = new Thread(myRunnable5);
        Thread t2 = new Thread(myRunnable5);

        t1.start();
        TimeUnit.MILLISECONDS.sleep(300);
        t2.start();

    }
}

class MyRunnable5 implements Runnable {
    private boolean enterMethod = true;

    @Override
    public void run() {
        if (enterMethod) {

            enterMethod = false;

            try {
                methodWithSynchronized();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            synchronized (this) {
                System.out.println("synchronized block start");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("synchronized block end");
            }
        }

    }

    private synchronized void methodWithSynchronized() throws InterruptedException {
        System.out.println("methodWithSynchronized start");

        TimeUnit.SECONDS.sleep(5);

        System.out.println("methodWithSynchronized end");
    }
}
