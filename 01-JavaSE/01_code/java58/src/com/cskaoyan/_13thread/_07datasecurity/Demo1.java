package com.cskaoyan._13thread._07datasecurity;

import java.util.concurrent.TimeUnit;

/**
 * 假设A电影院正在上映某电影，该电影有100张电影票可供出售，现在假设有3个窗口售票。请设计程序模拟窗口售票的场景。
 * 分析：
 * 3个窗口售票，互不影响，同时进行。 -----> 多线程  3个线程
 * 3个窗口共同出售这100张电影票		-------> 多线程共享数据
 *
 * @author Common-zhou
 * @since 2024-03-22 14:56
 */
public class Demo1 {
    public static void main(String[] args) {

        TicketObject ticketObject = new TicketObject(100);

        Thread thread1 = new Thread(new SellWindow(ticketObject));
        Thread thread2 = new Thread(new SellWindow(ticketObject));
        Thread thread3 = new Thread(new SellWindow(ticketObject));

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();


    }
}


// 是用来模拟票的。
class TicketObject {
    int count;

    public TicketObject(int count) {
        this.count = count;
    }
}


class SellWindow implements Runnable {

    TicketObject ticketObject;

    public SellWindow(TicketObject ticketObject) {
        this.ticketObject = ticketObject;
    }

    @Override
    public void run() {

        while (ticketObject.count > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " sell tick:" + (ticketObject.count--));

        }
    }
}
