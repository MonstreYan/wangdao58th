package com.cskaoyan._14network._02tcp.v3;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * 客户端需要将这个文件发送。服务端这边需要接收并且保存这个文件。
 * 图片发送出去。
 *
 * @author Common-zhou
 * @since 2024-03-25 15:59
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 8899);

        OutputStream outputStream = socket.getOutputStream();

        InputStream inputStream = new FileInputStream("C:\\Users\\zhoubing\\Desktop\\tmp\\1.png");

        byte[] bytes = new byte[2048];
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        // 数据就操作结束了。
        // inputStream.close();
        // outputStream.close();

        // socket.close();


        TimeUnit.SECONDS.sleep(60);

    }
}
