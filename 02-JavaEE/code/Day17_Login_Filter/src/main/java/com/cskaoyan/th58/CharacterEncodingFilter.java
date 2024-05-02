package com.cskaoyan.th58;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 16:06
 * @Version 1.0
 */
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        //写在上面、下面，还是均可以？？？？只可以写上面
        response.setContentType("text/html;charset=utf-8");

        chain.doFilter(request, response);
        //执行完servlet的代码之后才会执行到这
    }

    @Override
    public void destroy() {

    }
}
