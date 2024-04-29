package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 17:14
 * @Version 1.0
 */
@WebServlet("/upload2")
@MultipartConfig
public class UploadServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用服务器提供的功能来处理的话，操作非常简单：
        //1.处理的servlet类头上标注一个@MultipartConfig注解
        //2.通过req.getPart()来调用即可，里面输入提交的文件的name属性即可
        Part part = req.getPart("image");
        String filename = part.getSubmittedFileName();
        String contentType = part.getContentType();
        String realPath = getServletContext().getRealPath("image");
        String path = realPath  + "/" + filename;
        File file = new File(path);
        if(!file.getParentFile().exists()){
            //父级目录不存在，则创建所有的父级目录
            file.getParentFile().mkdirs();
        }
        part.write(path);
    }
}
