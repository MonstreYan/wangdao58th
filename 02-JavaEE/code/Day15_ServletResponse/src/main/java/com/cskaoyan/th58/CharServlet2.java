package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 14:38
 * @Version 1.0
 */
@WebServlet("/char2")
public class CharServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //输出字符数据
        //中文乱码？如何解决呢？
        //可以借鉴req的来；
        //为什么设置utf-8之后还是乱码？原因在于编解码不一致
        //分析：响应报文从服务器出去的时候，以及到达客户端之前的编码格式utf-8
        // 响应报文被浏览器解析之后，浏览器使用的是什么编码格式？？？？gbk，和操作系统、语言有关 默认选择gbk
        //从根本上解决该问题：设置一个编码格式 + 把设置的编码格式告诉给客户端（响应头、响应体）
//        resp.setCharacterEncoding("utf-8");
        //设置的编码格式告诉给客户端
        //实际上，如果设置了下面这行代码，上面这行代码就无需开发人员自己主动去设置了，服务器会帮助我们设置
//        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        //因为content-type这个响应头用的比较多，所以ee规范又单独给它封装了一个方法，下面方法完全等价
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("你好！！！！");
    }
}
