package com.cskaoyan._14network._01udp.v1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Common-zhou
 * @since 2024-03-25 11:11
 */
public class Demo1 {

    public static void main(String[] args) throws IOException {

    }
}


class Sender1 {
    public static void main(String[] args) throws IOException {
        // 1. 创建发送端的socket对象
        // DatagramSocket(int port)        创建数据报套接字并将其绑定到本地主机上的指定端口。监听这个端口。
        DatagramSocket datagramSocket = new DatagramSocket();

        String message = "hello udp again";
        byte[] bytes = message.getBytes();

        // 2. 把要发送的数据封装成数据报包
        // DatagramPacket(byte[] buf,  int offset, int length, InetAddress address, int port)
        // 构造数据报包，用来将长度为 length 偏移量为 offset  的包发送到指定主机上的指定端口号
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("localhost"), 8080);

        // 3. send方法发送数据报包
        datagramSocket.send(packet);

        // 4. 释放资源close
        datagramSocket.close();
    }
}


class Receiver {
    public static void main(String[] args) throws IOException {
        // 1. 创建接收端的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(8080);

        // 2. 创建用于接收的数据报包
        byte[] bytes = new byte[20480];
        DatagramPacket receivePacket = new DatagramPacket(bytes, 0, bytes.length);

        System.out.println("receive before");
        // 3. receive方法接收数据
        datagramSocket.receive(receivePacket);
        System.out.println("receive after");

        // 4. 解析数据报包
        byte[] data = receivePacket.getData();
        int length = receivePacket.getLength();
        int offset = receivePacket.getOffset();

        String s = new String(data, offset, length);
        System.out.println("接收到的信息:" + s);

        // 5. 释放资源close
        datagramSocket.close();

    }
}
