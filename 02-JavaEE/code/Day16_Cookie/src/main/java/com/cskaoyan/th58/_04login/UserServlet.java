package com.cskaoyan.th58._04login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/30 14:52
 * @Version 1.0
 */
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

    //这里面不可以使用username成员变量来存储用户的信息，为什么？？？？？？？？
    //因为UserServlet在整个程序运行期间只有一个实例对象，所以username只有一份，如果多个用户同时访问当前servlet
    //他们是共享的，但是这部分数据很明显是不可以进行共享的
   // private String username;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  /app/user/login------>  login(/app/user/去掉)
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("login".equals(op)) {
            login(req, resp);
        }
    }

    //登录的业务逻辑：接收用户提交过来的请求参数信息，在系统中进行比对校验，校验通过，则跳转到一个新的页面
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //做一些校验 判空等操作

        //和系统中的数据进行比对：和数据库中的进行比对校验
        //直接登录成功

        //跳转页面----直接复制我的代码即可
        resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/user/info");

        //创建一个Cookie
        Cookie cookie = new Cookie("username", username);
        resp.addCookie(cookie);

        resp.getWriter().println("login success");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("info".equals(op)) {
            info(req, resp);
        }
    }

    private void info(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //再次把cookie信息携带了回来
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
               if("username".equals(cookie.getName())){
                   resp.getWriter().println("welcome " + cookie.getValue());
               }
            }
        }
    }
}
