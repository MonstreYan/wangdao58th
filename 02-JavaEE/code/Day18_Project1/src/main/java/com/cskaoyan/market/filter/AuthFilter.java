package com.cskaoyan.market.filter;

import com.cskaoyan.market.util.JacksonUtil;
import com.cskaoyan.market.util.ResponseUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/8 9:41
 * @Version 1.0
 */
//@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //在这里面去编写认证逻辑：除了登录、注销之外的其他全部接口，都需要进行登录才可以访问
        //登录了之后，我们会往session域里面写入数据，所以只需要去判断session域里面是否有数据，那么便可以知道是否登录
        //如何得知用户访问的是登录、注销？？？？？请求资源路径  /admin/auth/login /admin/auth/logout
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //通过打印日志，查看究竟在哪一步出现了跨域问题
        //访问/admin/auth/info接口时，OPTIONS方法获取不到session域里面的数据，为什么获取不到？？？？？？
        //不是同一个session对象--------> 没有携带Cookie:JSESSIONID=xxx(OPTIONS请求时不会携带Cookie)
        String method = request.getMethod();
        //通过打印日志我们可以发现，每次OPTIONS请求时，由于不会携带Cookie，都会创建一个新的session对象
        //虽然对于我们业务没有影响，但是每次请求都创建session对象，着实有一些浪费资源，所以options请求时直接忽略
        if(!"OPTIONS".equals(method)){
            HttpSession session = request.getSession();
            //获取请求资源
            String requestURI = request.getRequestURI();
            System.out.println(method + " " + requestURI + " " + session.getId() + " " + session);
            //
            //希望可以直接从context域中获取
            ServletContext servletContext = request.getServletContext();
            List<String> whiteUris = (List<String>) servletContext.getAttribute("white");
//            /admin/auth/login-------/app/admin/auth/login
            //希望可以直接使用list.contains方法，但是因为requesturi里面包含应用名，所以需要把应用名去掉
            requestURI = requestURI.replace(request.getContextPath(), "");
            if(!whiteUris.contains(requestURI)){
//            if(!requestURI.contains("/admin/auth/login") && !requestURI.contains("/admin/auth/logout")){
                //既不是登录也不是注销------进行认证，也就是需要登录之后才可以访问
                Object attribute = session.getAttribute("admin");
                if(attribute == null){
                    //没有登录
                    response.getWriter().println(JacksonUtil.getObjectMapper().writeValueAsString(ResponseUtil.unlogin()));
                    return;
                }
            }
        }

        //放行
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
