package com.cskaoyan.th58;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 16:13
 * @Version 1.0
 * 关于当前filter的url-pattern的写法有两种:
 * 1.直接去写/user/info：表示的是只去处理这个页面；后续的业务逻辑非常简单；只需要判断是否登录即可；如果今后还有订单页面也需要处理，那么又需要进一步去修改url-pattern
 * 2.写/*，后续的业务逻辑比较复杂，需要识别出是哪个请求、识别出访问的是否是info页面，然后才进行处理
 */
//@WebFilter("/*")
public class AuthFilter_bak implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //因为我们设置的是/*，所以无论访问哪个页面，哪个servlet，均会经过当前filter
        //但是目前来说，只有/user/info才需要进行处理，其他是不需要处理的
        //需要知道当前访问的是哪个资源
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/user/info")){
            //如果访问的是info页面，要求是什么？必须登录过后才可以访问
            //如何判断用户是否登录呢？
            HttpSession session = request.getSession();
            Object attribute = session.getAttribute("username");
            if(attribute == null){
                //没有登录
                response.sendRedirect(request.getContextPath() + "/login.html");
                return;
            }
        }

        //直接放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
