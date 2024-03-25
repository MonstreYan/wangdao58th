package com.cskaoyan._14network._01udp.v4;

/**
 * @author Common-zhou
 * @since 2024-03-25 15:04
 */
public class OtherPerson {
    public static void main(String[] args) {
        Thread sendTask = new Thread(new SendTask("localhost", 9999));
        Thread receiveTask = new Thread(new ReceiveTask(8888));

        sendTask.start();
        receiveTask.start();
    }
}
