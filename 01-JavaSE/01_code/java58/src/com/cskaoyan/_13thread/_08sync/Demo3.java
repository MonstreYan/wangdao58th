package com.cskaoyan._13thread._08sync;

/**
 * 有五个线程，大家伙对一个数进行累加。  每个线程10000次。 最终结果正确的是多少？
 * 50000
 *
 * @author Common-zhou
 * @since 2024-03-22 15:46
 */
public class Demo3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new IncreaRunnable());
        Thread thread2 = new Thread(new IncreaRunnable());
        Thread thread3 = new Thread(new IncreaRunnable());
        Thread thread4 = new Thread(new IncreaRunnable());
        Thread thread5 = new Thread(new IncreaRunnable());


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}

class IncreaRunnable implements Runnable {

    static int count = 0;
    // Integer String不要用这些来当锁。
    static final Object LOCK = new Object();

    @Override
    public void run() {
        // 改进一下。 怎么改？

        for (int i = 0; i < 100000; i++) {
            // 是什么对象不重要。但是是同样一个对象。 非常
            synchronized (LOCK) {
                count++;
            }

        }

        System.out.println(count);
    }
}
