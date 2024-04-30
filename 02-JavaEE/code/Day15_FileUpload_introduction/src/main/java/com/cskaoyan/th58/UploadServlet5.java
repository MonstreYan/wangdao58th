package com.cskaoyan.th58;

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
 * @Date 2024/4/29 17:14
 * @Version 1.0
 */
@WebServlet("/upload5")
@MultipartConfig
public class UploadServlet5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part part = req.getPart("image");
        String filename = part.getSubmittedFileName();
        //对文件名去做一个设置、修改
        String uuid = UUID.randomUUID().toString();
        filename = uuid + filename;
        //取哈希值
        int hashCode = filename.hashCode();
        String hexString = Integer.toHexString(hashCode);
        char[] charArray = hexString.toCharArray();
        String basePath = "image";
        for (char c : charArray) {
            basePath = basePath + "/" + c;
        }

        String contentType = part.getContentType();
        String realPath = getServletContext().getRealPath(basePath);
        String path = realPath  + "/" + filename;
        File file = new File(path);
        if(!file.getParentFile().exists()){
            //父级目录不存在，则创建所有的父级目录
            file.getParentFile().mkdirs();
        }
        part.write(path);
    }
}
