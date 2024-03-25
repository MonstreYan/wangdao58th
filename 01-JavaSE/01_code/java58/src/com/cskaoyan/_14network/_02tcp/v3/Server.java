package com.cskaoyan._14network._02tcp.v3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Common-zhou
 * @since 2024-03-25 16:04
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        // 文本： 是按照文本的方式解析的； 图片，是按照图片的方式存储的。
        // 如果这是图片，不能将它变成文本输出。
        // 字符组成的图片。  怎么实现的。  =====
        // TcpUtil.parseMsg();

        //
        OutputStream outputStream = new FileOutputStream("2.png");

        byte[] bytes = new byte[2048];
        int len = -1;

        // 在网络里面注意。 如果那边不调用close。 这边 -1没有
        // 如果另一端不调用close方法。 这边循环读的时候，可能会阻塞住。
        // 要么字节数组写大一点。 ===》
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        outputStream.close();
        inputStream.close();
        serverSocket.close();


    }
}
