package com.cskaoyan._14network._01udp.v2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Common-zhou
 * @since 2024-03-25 11:52
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        // 1. 创建发送端的socket对象
        DatagramSocket senderSocket = new DatagramSocket();

        String message = "udp again 11111111111";

        // 2. 把要发送的数据封装成数据报包

        DatagramPacket senderPackage = UdpUtil.generateSendPacket("localhost", 8888, message);

        // 3. send方法发送数据报包
        senderSocket.send(senderPackage);

        // 4. 释放资源close
        senderSocket.close();

    }
}
