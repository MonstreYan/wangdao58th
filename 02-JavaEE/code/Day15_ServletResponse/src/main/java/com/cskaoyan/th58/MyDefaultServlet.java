package com.cskaoyan.th58;

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
 * @Date 2024/4/29 15:06
 * @Version 1.0
 */
@WebServlet("/")
public class MyDefaultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //不能被其他servlet所处理的请求都会交给当前servlet来进行处理
        //需要做的事情就是识别出用户请求的是哪个资源
        //  /2.png  /link.html  /3.html
        String servletPath = req.getServletPath();
        //确认输入的路径部分对应的硬盘路径
        String realPath = getServletContext().getRealPath(servletPath);
        File file = new File(realPath);
        if(file.exists() && file.isFile()){
            //文件存在，并且不是目录，、将文件响应出去
            FileInputStream fileInputStream = new FileInputStream(file);
            ServletOutputStream outputStream = resp.getOutputStream();
            int length = 0;
            byte[] bytes = new byte[1024];
            while ((length = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, length);
            }
            fileInputStream.close();
            outputStream.close();
            return;
        }
        //文件不存在
        resp.setStatus(404);
        resp.getWriter().println("<div>File Not Found</div>");
    }
}
