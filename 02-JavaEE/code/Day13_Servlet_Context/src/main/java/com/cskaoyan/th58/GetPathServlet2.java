package com.cskaoyan.th58;

import javax.servlet.ServletContext;
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
@WebServlet("/path2")
public class GetPathServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //应用部署在tomcat服务器中，应用的两个属性分别是什么？应用名，应用的路径（应用的根目录）这两个信息我们是配置在tomcat中的
        //tomcat能否知晓每个应用的应用根目录的地址？可以。如果tomcat能够将这个路径再次暴露返回给开发人员，那么我们便可以获取应用根目录的路径
        //后续再自行拼接出文件相对于应用根目录的相对路径即可
        //希望可以有一种方式，使用代码来获取应用根目录下的文件路径
        ServletContext servletContext = getServletContext();
        //输入一个参数：文件相对于应用根目录的一个相对路径；返回一个绝对路径；如果输入的是空字符串，那么返回的便是应用根目录的路径
        //使用方式一：输入一个空字符串，返回应用根目录路径
        String docBase = servletContext.getRealPath("");
        String path = docBase + "/1.html";
        System.out.println(path);

        //使用方式二：输入一个相对于应用根目录的相对路径，返回该文件的绝对路径
        String realPath = servletContext.getRealPath("1.html");
        System.out.println(realPath);
    }
}
