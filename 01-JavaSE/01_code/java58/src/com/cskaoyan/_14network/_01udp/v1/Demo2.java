package com.cskaoyan._14network._01udp.v1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author Common-zhou
 * @since 2024-03-25 11:29
 */
public class Demo2 {

}

class Sender2 {
    public static void main(String[] args) throws IOException {
        // 1. 创建发送端的socket对象
        DatagramSocket senderSocket = new DatagramSocket();

        String message = "udp again";
        byte[] bytes = message.getBytes();


        // SocketAddress ： new InetSocketAddress("localhost", 8888)
        // InetAddress ， port 可以
        // 2. 把要发送的数据封装成数据报包
        DatagramPacket senderPackage = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 8888));
        // 3. send方法发送数据报包
        senderSocket.send(senderPackage);

        // 4. 释放资源close
        senderSocket.close();

    }
}

class Receiver2 {
    public static void main(String[] args) throws IOException {
        // 1. 创建接收端的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        byte[] bytes = new byte[20480];

        // 2. 创建用于接收的数据报包
        DatagramPacket receivePacket = new DatagramPacket(bytes, 0, bytes.length);

        // 3. receive方法接收数据
        datagramSocket.receive(receivePacket);

        // 4. 解析数据报包

        byte[] data = receivePacket.getData();
        int offset = receivePacket.getOffset();
        int length = receivePacket.getLength();

        String s = new String(data, offset, length);
        System.out.println("接收到的数据：" + s);
        System.out.println(bytes == data);

        // 接收到的数据，里面的字节数组，其实就是你传入的字节数组。

        // 5. 释放资源close
        datagramSocket.close();
    }
}
