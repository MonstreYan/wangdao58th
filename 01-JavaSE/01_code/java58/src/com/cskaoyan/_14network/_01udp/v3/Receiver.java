package com.cskaoyan._14network._01udp.v3;

import com.cskaoyan._14network._01udp.v2.UdpUtil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * @author Common-zhou
 * @since 2024-03-25 14:36
 */
public class Receiver {
    public static void main(String[] args) throws IOException {
        // 1. 创建接收端的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        while (true) {
            // 2. 创建用于接收的数据报包
            DatagramPacket receivePacket = UdpUtil.generateEmptyPacket();

            // 3. receive方法接收数据
            datagramSocket.receive(receivePacket);

            // 4. 解析数据报包
            String message = UdpUtil.parseMsg(receivePacket);
            System.out.println("接收到了消息：" + message);

            if ("886".equals(message)) {
                break;
            }

            System.out.println("请输入要发送的消息：");
            Scanner scanner = new Scanner(System.in);

            String inputMessage = scanner.nextLine();

            DatagramPacket sendPacket = UdpUtil.generateSendPacket("localhost", 8888, inputMessage);

            datagramSocket.send(sendPacket);
        }


        // 5. 释放资源close
        datagramSocket.close();
    }
}
