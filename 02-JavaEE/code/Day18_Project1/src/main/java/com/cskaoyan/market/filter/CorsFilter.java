package com.cskaoyan.market.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 16:22
 * @Version 1.0
 */
//@WebFilter("/*")
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //告诉浏览器任何来源的主机端口号均可以访问当前服务器
        //允许哪个域名来源的请求可以往当前服务器发起请求
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:9527");
        //发送请求时，运行的请求方法是什么
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,PUT,DELETE");
        //允许携带的请求头有哪些
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,Authorization,Content-Type,X-CskaoyanMarket-Admin-Token,X-CskaoyanMarket-Token");
        //是否允许携带Cookie等凭证
        response.setHeader("Access-Control-Allow-Credentials","true");

        //该响应的资源是否被允许与给定的origin共享 通常在允许携带cookie时需要设置
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
