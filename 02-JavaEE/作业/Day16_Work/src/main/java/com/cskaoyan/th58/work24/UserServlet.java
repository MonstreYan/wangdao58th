package com.cskaoyan.th58.work24;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 9:56
 * @Version 1.0
 */
@WebServlet("/user/*")
@MultipartConfig
public class UserServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        //读取配置文件
        InputStream inputStream = UserServlet.class.getClassLoader().getResourceAsStream("app.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String path = properties.getProperty("app.upload.directory");
            //随即将这个数据放入context域中
            getServletContext().setAttribute("path", path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        //获取session域里面的数据
        User user = (User) req.getSession().getAttribute("user");
        resp.getWriter().println("<div>" + user.getUsername() + "</div>");
        resp.getWriter().println("<div>" + user.getUsername() + "</div>");
        //这个路径是用来给用户访问的
        resp.getWriter().println("<div><img src='" + req.getContextPath() + "/static/" + user.getImage() + "'/></div>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("register".equals(op)){
            register(req, resp);
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //需要做的事情便是将文件存储起来，我们的要求是存储在非应用根目录下的某个目录内
        // D:/image/----存储的位置写到配置文件中会比较好，后续更好，只需要更换配置文件里面的配置即可
        //注册成功之后，需要做的事情是要把一个访问地址返回给客户端；客户端再次发起请求，服务器需要做的事情是将该文件响应给客户端
        //所以，此时我们需要自己去配置一个匹配规则，比如 /static/*----------匹配位于D:/image目录下的文件
        //上传的基准目录
        String path = (String) getServletContext().getAttribute("path");

        //先把表单数据接收了
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Part part = req.getPart("image");
        String filename = part.getSubmittedFileName();
        filename = UUID.randomUUID() + filename;
        //放在当前时间对应的目录内  2024-05-02   基准目录 + 2024/5/2/1.jpg ：  D:/image/     2024/5/2/1.jpg

        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT+8:00"));
        calendar.setTime(new Date());

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String relativePath = year + "/" + month + "/" + day + "/" + filename;

        //需要构建一个file，需要使用到硬盘路径，为什么需要file呢？因为这些年月日目录可能不存在，需要先把这些目录创建出来
        File file = new File(path + "/" + relativePath);
        if(!file.getParentFile().exists()){
            //如果父级目录不存在，则创建所有的父级目录
            file.getParentFile().mkdirs();
        }

        part.write(file.getAbsolutePath());

        //创建一个user对象
        User user = new User(username, password, relativePath);
        //把这部分数据放入session域
        req.getSession().setAttribute("user", user);

        //进行页面跳转，跳转到一个新的页面，要求可以显示出刚刚注册时的用户名、密码、头像等信息
        resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/user/info");
    }
}
