package com.cskaoyan._14network._01udp.v2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Common-zhou
 * @since 2024-03-25 11:44
 */
public class Receiver {
    public static void main(String[] args) throws IOException {
        // 1. 创建接收端的socket对象
        DatagramSocket receiverSocket = new DatagramSocket(8888);

        DatagramPacket receivePacket = UdpUtil.generateEmptyPacket();

        // 3. receive方法接收数据
        receiverSocket.receive(receivePacket);

        String s = UdpUtil.parseMsg(receivePacket);

        System.out.println(s);

        // 4. 解析数据报包
        // 5. 释放资源close
        receiverSocket.close();
    }
}
