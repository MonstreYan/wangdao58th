package com.cskaoyan.th58;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ss2")
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需要现持有servletContext对象的引用
        ServletContext servletContext = getServletContext();
        //从context域中获取数据  key=name
        Object name = servletContext.getAttribute("name");
        System.out.println(name);
    }
}
