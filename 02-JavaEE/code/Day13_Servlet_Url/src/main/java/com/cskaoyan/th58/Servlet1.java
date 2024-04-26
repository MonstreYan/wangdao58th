package com.cskaoyan.th58;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
//定义4个servlet，url-pattern分别为： /abc/*    /*     /abc    *.do
//依次去访问如下的几个请求，最终查看页面中显示的是哪个servlet里面的内容？
//
// /abc : /abc被调用了（/*     /abc）
// /abc/a.do： /abc/*    （/abc/*   /*     *.do）
// /xxx/a.do:   /*          （/*    *.do）
public class Servlet1 extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //当前servlet的url-pattern  /abc/*
        //给客户端输出一个字符
        res.getWriter().println("/abc/*");
    }
}
