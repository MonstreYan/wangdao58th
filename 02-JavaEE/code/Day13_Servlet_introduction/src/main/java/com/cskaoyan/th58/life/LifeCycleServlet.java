package com.cskaoyan.th58.life;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/life","/life2"},loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {

    private String username;

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    //该方法可以看做是service方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
    }

    //一般在继承HttpServlet中，没有必要去重写service方法，如果重写，那么doGet、doPost可能就无法调用

//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//
//    }


    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
