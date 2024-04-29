package com.cskaoyan.th58.work1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 9:48
 * @Version 1.0
 */
@WebServlet("/work1")
public class Work1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //访问当前servlet时，要求可以获取当前客户端的请求报文，然后将请求报文写入到位于应用根目录下某个文件中
        StringBuffer stringBuffer = new StringBuffer();
        String method = req.getMethod();
        String requestURI = req.getRequestURI();
        String protocol = req.getProtocol();
        //链式调用-----建造者设计模式
        stringBuffer.append(method).append(" ").append(requestURI).append(" ").append(protocol).append("\n");

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            stringBuffer.append(headerName).append(": ").append(headerValue).append("\n");
//            System.out.println(headerName + ":" + headerValue);
        }
        //get方法没有请求体

        String content = stringBuffer.toString();
        //需要将这部分数据写入到一个文件中
//        new FileWriter("1.txt")
        String realPath = getServletContext().getRealPath("1.txt");
        FileWriter fileWriter = new FileWriter(realPath);
        fileWriter.write(content);
        fileWriter.flush();
        fileWriter.close();
    }
}
