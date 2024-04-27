package com.cskaoyan.th58._02param;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/27 11:26
 * @Version 1.0
 */
@WebServlet("/param2")
public class ParamServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用方法来获取请求参数
        //key其实就是form表单的name属性
        //无需开发人员自行去解析请求体，服务器会帮助我们解析好
        //请求参数的key值集合：注意和getHeaderNames的区分？？获取的位置不同
        //getParameterNames：获取的是位于请求行或者请求体里面的请求参数
        //getHeaderNames：获取的是请求头里面的键值对
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String paramKey = parameterNames.nextElement();
            String[] paramValues = req.getParameterValues(paramKey);
            System.out.println(paramKey + " : " + Arrays.toString(paramValues));
        }
    }
}
