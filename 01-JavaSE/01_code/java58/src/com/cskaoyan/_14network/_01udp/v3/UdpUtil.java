package com.cskaoyan._14network._01udp.v3;

import java.net.DatagramPacket;
import java.net.InetSocketAddress;

/**
 * 工具。
 * private UdpUtil():  强制让别人无法创建对象。 保险
 *
 * @author Common-zhou
 * @since 2024-03-25 11:48
 */
public class UdpUtil {
    private UdpUtil() {
    }


    public static DatagramPacket generateEmptyPacket() {
        byte[] bytes = new byte[20480];
        // 2. 创建用于接收的数据报包
        DatagramPacket receivePacket = new DatagramPacket(bytes, 0, bytes.length);

        return receivePacket;
    }


    public static String parseMsg(DatagramPacket receivePacket) {
        byte[] data = receivePacket.getData();
        int offset = receivePacket.getOffset();
        int length = receivePacket.getLength();

        String s = new String(data, offset, length);
        return s;
    }

    public static DatagramPacket generateSendPacket(String hostName, int port, String message) {

        byte[] bytes = message.getBytes();

        // 2. 把要发送的数据封装成数据报包
        DatagramPacket senderPackage = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(hostName, port));
        return senderPackage;


    }


}
