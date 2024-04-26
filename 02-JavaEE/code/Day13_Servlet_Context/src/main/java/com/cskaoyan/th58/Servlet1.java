package com.cskaoyan.th58;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ss1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //程序运行期间产生了某些数据，希望可以和servlet2进行共享，怎么办？
        //先获取servletContext对象的引用 getServletContext()怎么来的？来自于父类，继承得到
        ServletContext servletContext = getServletContext();
        //往context域里面写入数据 存入数据的时候key=name，取得时候key也是name
        servletContext.setAttribute("name", "context");
    }
}
