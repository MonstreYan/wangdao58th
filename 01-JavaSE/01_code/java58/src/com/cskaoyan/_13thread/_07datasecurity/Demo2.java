package com.cskaoyan._13thread._07datasecurity;

import java.util.concurrent.TimeUnit;

/**
 * 卖票的时候，出现的这个问题。 主要的原因是。
 * <p>
 * 窗口1在卖票，窗口2在卖票，窗口3也在卖票。 都在卖票。而且卖票的动作没有原子化。
 * <p>
 * // 可以是任何东西。 但是必须要保证是同一个东西。
 * synchronized(锁对象){
 * // 对共享数据的访问操作
 * }
 * synchronized 就是Java中的锁操作。   同步操作。
 * 在里面要放一个东西，锁对象。 锁对象可以是任何对象，但是要保证是同一个。
 *
 * @author Common-zhou
 * @since 2024-03-22 15:13
 */
public class Demo2 {
    public static void main(String[] args) {
        TicketObject ticketObject = new TicketObject(100);

        Thread thread1 = new Thread(new SellWindow2(ticketObject));
        Thread thread2 = new Thread(new SellWindow2(ticketObject));
        Thread thread3 = new Thread(new SellWindow2(ticketObject));

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class SellWindow2 implements Runnable {

    TicketObject ticketObject;

    private final static Object LOCK = new Object();

    public SellWindow2(TicketObject ticketObject) {
        this.ticketObject = ticketObject;
    }

    @Override
    public void run() {

        while (ticketObject.count > 0) {
            synchronized (LOCK) {

                if (ticketObject.count <= 0) {
                    break;
                }

                // 在这个代码块里面的东西，坚不可摧。 原子化了。不能被别人中途打断。
                // 你要进入这个代码块。必须要拿到一个叫做LOCK的对象（锁）的角色。 你一旦拿到，别人拿不到这个LOCK，
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " sell tick:" + (ticketObject.count--));
            }

            // 多线程的执行特点是随机。
        }
    }
}

