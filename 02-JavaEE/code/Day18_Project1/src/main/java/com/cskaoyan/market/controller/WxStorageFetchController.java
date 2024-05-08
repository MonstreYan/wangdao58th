package com.cskaoyan.market.controller;

import javax.servlet.ServletContext;
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
 * @Date 2024/5/7 10:37
 * @Version 1.0
 */
@WebServlet("/wx/storage/fetch/*")
//  /wx/storage/fetch/xxxx----------->  D:/image/xxx 去查找该文件是否存在
public class WxStorageFetchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        //将key保留，其余的部分全部去掉，保留的key拼接处前缀D:/image，在该目录下去查找该文件是否存在
        String key = requestURI.replace(req.getContextPath() + "/wx/storage/fetch/", "");

        // 从配置文件中去读取
        ServletContext servletContext = getServletContext();
        String path = (String) servletContext.getAttribute("path");
        File file = new File(path + key);
        if(file.exists() && file.isFile()){
            //响应给客户端:服务器给客户端返回信息 响应报文 响应体  哪个方法设置响应体呢？ 字符还是字节
            ServletOutputStream outputStream = resp.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(file);
            int length = 0;
            byte[] bytes = new byte[1024];
            while ((length = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, length);
            }
            return;
        }
        resp.setStatus(404);
        //404
    }
}
