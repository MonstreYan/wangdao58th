package com.cskaoyan._14network._02tcp.v4;

import com.cskaoyan._14network._02tcp.v2.TcpUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Common-zhou
 * @since 2024-03-25 16:18
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8899);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            Socket socket = serverSocket.accept();

            executorService.submit(()->{
                try {
                    InputStream inputStream = socket.getInputStream();

                    String message = TcpUtil.parseMsg(inputStream);

                    System.out.println("接收到了消息：" + message);
                    TimeUnit.SECONDS.sleep(60);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        }

    }
}
