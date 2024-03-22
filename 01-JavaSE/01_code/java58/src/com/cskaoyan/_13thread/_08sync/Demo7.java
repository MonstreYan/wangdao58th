package com.cskaoyan._13thread._08sync;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 放在静态方法上面。锁对象是  class文件
 *
 * @author Common-zhou
 * @since 2024-03-22 16:29
 */
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        MyThread7 t1 = new MyThread7(true);
        MyThread7 t2 = new MyThread7(false);
        t1.start();
        TimeUnit.MILLISECONDS.sleep(300);
        t2.start();

    }
}


class MyThread7 extends Thread {

    private boolean enterMethod;

    public MyThread7(boolean enterMethod) {
        this.enterMethod = enterMethod;
    }

    @Override
    public void run() {
        if (enterMethod) {
            try {
                staticMethodWithSynchronized();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            synchronized (MyThread7.class) {
                System.out.println("MyThread7 synchronized block start");

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("MyThread7 synchronized block end");
            }
        }
    }

    private static synchronized void staticMethodWithSynchronized() throws InterruptedException {
        System.out.println("staticMethodWithSynchronized start");

        TimeUnit.SECONDS.sleep(5);

        System.out.println("staticMethodWithSynchronized end");
    }
}
