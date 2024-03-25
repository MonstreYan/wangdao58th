package com.cskaoyan._14network._01udp.v4;

import com.cskaoyan._14network._01udp.v2.UdpUtil;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 发送任务的线程
 *
 * @author Common-zhou
 * @since 2024-03-25 14:51
 */
public class SendTask implements Runnable {

    // 对于这个发送端来说。 它要干啥 ？
    // 发数据。
    private String ip;
    private int port;

    public SendTask(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();

            // 对于这个线程来说。 只做发送。
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("请输入要发送的消息：");
                String inputMessage = scanner.nextLine();
                datagramSocket.send(UdpUtil.generateSendPacket(ip, port, inputMessage));
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // 1. 创建发送端的socket对象
        // 2. 把要发送的数据封装成数据报包
        // 3. send方法发送数据报包
        // 4. 释放资源close
    }
}
