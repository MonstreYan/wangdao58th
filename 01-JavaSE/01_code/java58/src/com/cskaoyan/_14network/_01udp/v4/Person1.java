package com.cskaoyan._14network._01udp.v4;

/**
 * @author Common-zhou
 * @since 2024-03-25 15:03
 */
public class Person1 {
    public static void main(String[] args) {
        Thread sendTask = new Thread(new SendTask("localhost", 8888));
        Thread receiveTask = new Thread(new ReceiveTask(9999));

        sendTask.start();
        receiveTask.start();
    }
}
