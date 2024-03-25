package com.cskaoyan._14network._02tcp.v2;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Common-zhou
 * @since 2024-03-25 15:56
 */
public class TcpUtil {
    public static String parseMsg(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[2048];
        int readCount = inputStream.read(bytes);

        return new String(bytes, 0, readCount);
    }
}
