package com.cskaoyan._13thread._05control;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程
 * 用户线程
 * <p>
 * 用户线程就是工作的线程。 如果一个JVM虚拟机中，全是守护线程，这时候，JVM会直接挂掉
 *
 * 守护线程，就是守护用户线程的线程。当一个JVM虚拟机中，没有用户线程的时候， JVM会直接挂掉。
 *
 * @author Common-zhou
 * @since 2024-03-22 11:26
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        // main是一个用户线程。    daemonThread现在不是，是守护线程
        DaemonThread daemonThread = new DaemonThread();

        // 默认是用户线程。 只要JVM里面有用户线程在运行。这时候JVM就会正常跑。 等到没有其他的用户线程运行的时候，就挂掉了，

        // daemonThread.setDaemon(true);
        daemonThread.start();
        daemonThread.setDaemon(true);

        TimeUnit.SECONDS.sleep(2);
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("DaemonThread" + i);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
