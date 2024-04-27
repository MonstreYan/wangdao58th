package com.cskaoyan.th58._01basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/27 11:05
 * @Version 1.0
 */
@WebServlet("/req2")
public class RequestServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端的ip地址
        String remoteAddr = req.getRemoteAddr();
        int remotePort = req.getRemotePort();

        //服务器的ip地址、端口号
        String localAddr = req.getLocalAddr();
        int localPort = req.getLocalPort();
        System.out.println("client info:" + remoteAddr + ":" + remotePort + " visit server: " + localAddr + ":" + localPort);
    }
}
