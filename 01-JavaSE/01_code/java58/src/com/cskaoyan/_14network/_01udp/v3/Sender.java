package com.cskaoyan._14network._01udp.v3;

import com.cskaoyan._14network._01udp.v2.UdpUtil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * @author Common-zhou
 * @since 2024-03-25 14:34
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        // 1. 创建发送端的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        while (true) {
            // 2. 把要发送的数据封装成数据报包
            System.out.println("请输入你要发送的消息：");
            Scanner scanner = new Scanner(System.in);
            String inputMessage = scanner.nextLine();

            DatagramPacket sendPacket = UdpUtil.generateSendPacket("localhost", 9999, inputMessage);
            // 3. send方法发送数据报包
            datagramSocket.send(sendPacket);
            if ("886".equals(inputMessage)) {
                break;
            }


            // 接着接收消息.
            DatagramPacket receivePacket = UdpUtil.generateEmptyPacket();
            datagramSocket.receive(receivePacket);

            String message = UdpUtil.parseMsg(receivePacket);
            System.out.println("接收到了消息:" + message);
        }



        // 4. 释放资源close
        datagramSocket.close();
    }
}
