package com.cskaoyan._14network._02tcp.v4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author Common-zhou
 * @since 2024-03-25 16:18
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 8899);

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("cllient1 send".getBytes());

        TimeUnit.SECONDS.sleep(180);

        System.out.println("客户端中止了");
        socket.close();
    }
}
