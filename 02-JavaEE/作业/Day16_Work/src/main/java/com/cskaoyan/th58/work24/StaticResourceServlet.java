package com.cskaoyan.th58.work24;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 10:05
 * @Version 1.0
 */
@WebServlet("/static/*")
public class StaticResourceServlet extends HttpServlet {

    //需要去到指定的目录下去查找数据D:/image/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这个时候用户输入http://localhost:8080/app/static/2024/5/2/84951057-75f9-413e-b4f1-8f5e02d251151.png------> D:/image/2024/5/2/xxxx.jpg
        //所以我们需要做的事情就是取出/2024/5/2/84951057-75f9-413e-b4f1-8f5e02d251151.png----拼接上前缀基准目录，去查找该文件是否存在，如果存在，则响应出去
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/static", "");
        //拿到基准路径
        String path = (String) getServletContext().getAttribute("path");
        path = path + op;
        File file = new File(path);
        if(file.exists() && file.isFile()){
            //把文件响应出去，此时充当的相当于缺省Servlet的功能
            FileInputStream fileInputStream = new FileInputStream(file);
            ServletOutputStream outputStream = resp.getOutputStream();
            int length = 0;
            byte[] bytes = new byte[1024];
            while ((length = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, length);
            }
            fileInputStream.close();
            outputStream.close();
        }
    }
}
