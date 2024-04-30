package com.cskaoyan.th58;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/30 10:35
 * /user/app/xx/aaa/register
 * @Version 1.0
 */
@WebServlet("/user/*")
//该注解的功能是让服务器帮助我们去解析请求里面的文件数据，处理过之后再次封装回req对象中
@MultipartConfig
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //不要着急，上来就在doPost里面写注册逻辑，因为后面可能还会有其他方法也需要使用doPost来分发
        //因为这里面含有*，所以不可以使用
//        req.getServletPath()
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("register".equals(op)){
            register(req, resp);
        }
    }

    //注册的业务逻辑
    //获取接收用户提交过来的请求参数信息（借助于请求报文）；初步校验比对，保证信息的唯一性，存储到数据库，给页面一个回执信息
    //如何和另外一个servlet共享数据？
    //以用户名作为key------对象作为value放入context域中；要求保障用户名唯一
    //再把用户名传递给info  /user/info?username=xxx
    //在info中，获取用户名，从context域里面获取数据，取出来里面的内容
    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用request.getPart获取文件的数据;使用request.getParameter来获取表单数据
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //判断用户名是否唯一
        ServletContext servletContext = getServletContext();
        Object u = servletContext.getAttribute("username");
        if(u != null){
            //用户名已经被占用了
            resp.getWriter().println("当前用户名已经被占用");
            return;
        }

        Part part = req.getPart("image");
        String filename = part.getSubmittedFileName();
        filename = UUID.randomUUID() + filename;
        //D:/xxx/xxx/xxx/xxx
        String relativePath = "image/" + filename;
        String realPath = servletContext.getRealPath(relativePath);
        //file就是对于硬盘上某个文件的封装
        File file = new File(realPath);
        //如果父级目录不存在，则创建所有的父级目录
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        part.write(realPath);
        //todo image
        User user = new User(username, password, relativePath);

        servletContext.setAttribute(username, user);

        resp.getWriter().println("注册成功，即将跳转至信息预览页面");
        resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/user/info?username=" + username);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("info".equals(op)){
            info(req, resp);
        }
    }

    private void info(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        register里面包含的数据需要和当前info进行共享
        String username = req.getParameter("username");
        ServletContext servletContext = getServletContext();
        User user = (User) servletContext.getAttribute(username);
        resp.getWriter().println("<div>" + user.getUsername() + "</div>");
        resp.getWriter().println("<div>" + user.getPassword() + "</div>");
        //   /app/image/xxxx.jpg
        resp.getWriter().println("<div><img src='" + req.getContextPath() + "/" + user.getImage() + "'></div>");

    }
}
