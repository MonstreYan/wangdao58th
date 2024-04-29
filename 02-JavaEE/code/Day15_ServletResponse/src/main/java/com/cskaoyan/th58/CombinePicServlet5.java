package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 16:11
 * @Version 1.0
 */
@WebServlet("/pic/*")
public class CombinePicServlet5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // /app/pic/view  /app/pic/down
        String requestURI = req.getRequestURI();
        //把前面的这部分内容替换成一个空字符串
        String op = requestURI.replace(req.getContextPath() + "/pic/", "");
        if("view".equals(op)){
            view(req, resp);
        }else if("down".equals(op)){
            down(req, resp);
        }
    }

    private void down(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-Disposition", "attachment;filename=1.png");

        view(req, resp);
    }

    private void view(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletOutputStream outputStream = resp.getOutputStream();

        //从硬盘上面某一处来获取文件的输入流
        //文件经过部署之后位于classpath目录下
        ClassLoader classLoader = StreamServlet3.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("1.png");
        //写入的长度
        int length = 0;
        //往数组里面写入数据
        byte[] buffer = new byte[1024];
        while ((length = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();

    }
}
