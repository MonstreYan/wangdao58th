package com.cskaoyan._14network._01udp.v4;

import com.cskaoyan._14network._01udp.v2.UdpUtil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author Common-zhou
 * @since 2024-03-25 14:59
 */
public class ReceiveTask implements Runnable {

    private int port;

    public ReceiveTask(int port) {
        this.port = port;
    }

    @Override
    public void run() {

        // 1. 创建接收端的socket对象
        try {
            DatagramSocket datagramSocket = new DatagramSocket(port);

            // 2. 创建用于接收的数据报包
            // 3. receive方法接收数据
            // 4. 解析数据报包
            // 5. 释放资源close

            while (true) {
                DatagramPacket datagramPacket = UdpUtil.generateEmptyPacket();
                datagramSocket.receive(datagramPacket);

                String messageFromOther = UdpUtil.parseMsg(datagramPacket);

                System.out.println("收到了消息：" + messageFromOther);

            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
