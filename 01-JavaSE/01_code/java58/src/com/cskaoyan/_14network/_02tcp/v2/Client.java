package com.cskaoyan._14network._02tcp.v2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Common-zhou
 * @since 2024-03-25 15:28
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // Socket 是什么东西？连接。 连接在Java里面的表现
        // 新建了一个连接。 连接到 localhost  8899这个端口。
        Socket socket = new Socket("localhost", 8899);

        // 拿到了连接之后，就可以使用socket。来获取输入和输出流。使用输入输出流写数据、读数据
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("Client send 1".getBytes());

        System.out.println("客户端读取到了数据：" + TcpUtil.parseMsg(inputStream));

        inputStream.close();
        outputStream.close();
        socket.close();


    }
}
