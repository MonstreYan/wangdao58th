package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 14:48
 * @Version 1.0
 */
@WebServlet("/stream")
public class StreamServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //位于resources目录下有一个1.png，希望你可以将该图片响应给客户端 io流
        //需要有一个输入流、输出流
        ServletOutputStream outputStream = resp.getOutputStream();

        //从硬盘上面某一处来获取文件的输入流
        //文件经过部署之后位于classpath目录下
        ClassLoader classLoader = StreamServlet3.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("1.png");
        //写入的长度
        int length = 0;
        //往数组里面写入数据
        byte[] buffer = new byte[1024];
        while ((length = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();
    }
}
