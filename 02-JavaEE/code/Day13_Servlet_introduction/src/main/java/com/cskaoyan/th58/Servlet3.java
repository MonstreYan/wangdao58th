package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "s3", urlPatterns = "/ss3")
//还可以进一步简化，将name属性去掉，也就是可以不用给name属性赋值
//@WebServlet(urlPatterns = "/ss3")
//如果注解内只有一个单一的值，其实默认就是赋值给value的，而value和urlPatterns可以理解为是相互的别名的关系
@WebServlet("/ss3")
public class Servlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
    }
}
