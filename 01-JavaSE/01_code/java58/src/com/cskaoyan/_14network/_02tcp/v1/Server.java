package com.cskaoyan._14network._02tcp.v1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Common-zhou
 * @since 2024-03-25 15:17
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("accept before");
        // accept是一个阻塞方法。 如果没有请求来，就在这阻塞上。如果有请求来了，就往下继续走
        Socket socket = serverSocket.accept();
        System.out.println("accept after");

        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[2048];
        int readCount = inputStream.read(bytes);

        String s = new String(bytes, 0, readCount);

        System.out.println(s);

        serverSocket.close();
    }
}
