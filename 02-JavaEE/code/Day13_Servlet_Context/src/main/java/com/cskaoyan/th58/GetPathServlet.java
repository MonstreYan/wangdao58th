package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/27 9:36
 * @Version 1.0
 */
@WebServlet("/path")
public class GetPathServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取位于应用根目录下1.html文件的路径
        //file相对路径获取到的路径是相对于tomcat的bin目录
        //为什么相对路径相对的是tomcat的bin目录？file相对路径相对的是用户的工作目录，当前工作目录是tomcat的bin目录
        //ee项目其实都是没有main方法的，程序究竟是如何运行的呢？jvm是如何启动的呢？
        //jvm是在tomact的bin目录下开启的；所以工作目录便是tomcat的bin目录；我们写的java ee的代码充其量只是一些代码片段，供tomcat来调用
        //tomcat + ee代码合在一起  =  完整的java程序
        //所以，在java ee阶段，绝对不可以使用file相对路径来获取文件的绝对路径
        File file = new File("1.html");
        System.out.println(file.getAbsolutePath());
    }
}
