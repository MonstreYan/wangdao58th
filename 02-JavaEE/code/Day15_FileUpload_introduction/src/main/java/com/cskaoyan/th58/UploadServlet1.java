package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 17:14
 * @Version 1.0
 */
@WebServlet("/upload")
public class UploadServlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先应该做的事情是获取位于req对象中的文件数据
        ServletInputStream inputStream = req.getInputStream();

        //写入到硬盘上面
        //存储到应用根目录下的image目录中
        String realPath = getServletContext().getRealPath("image");
        String path = realPath + "/1.txt";
        File file = new File(path);
        if(!file.getParentFile().exists()){
            //父目录不存在 则创建所有的父目录
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int length = 0;
        byte[] bytes = new byte[1024];
        while ((length = inputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes, 0, length);
        }
        inputStream.close();
        fileOutputStream.close();
    }
}
