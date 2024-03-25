package com.cskaoyan._14network._02tcp.v1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Common-zhou
 * @since 2024-03-25 15:17
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("蜜雪冰城甜蜜蜜，你知道吗?".getBytes());

        socket.close();
    }

}
