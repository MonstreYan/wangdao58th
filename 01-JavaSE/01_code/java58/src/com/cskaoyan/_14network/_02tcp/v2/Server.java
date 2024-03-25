package com.cskaoyan._14network._02tcp.v2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Common-zhou
 * @since 2024-03-25 15:51
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // ServerSocket里面有个端口。代表什么意思?
        // 服务端，监听这个端口。 等会谁来找这个端口。我们就可以通过这个来通讯
        ServerSocket serverSocket = new ServerSocket(8899);

        Socket socket = serverSocket.accept();

        // Socket 是什么东西？连接。 连接在Java里面的表现

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        String message = TcpUtil.parseMsg(inputStream);

        System.out.println("接收到了一个消息:" + message);

        outputStream.write("server response".getBytes());

        outputStream.close();
        inputStream.close();
        serverSocket.close();
    }
}
