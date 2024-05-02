package com.cskaoyan.th58;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 15:08
 * 类比Servlet来进行学习：需要关注的是哪些和servlet时一致的；哪些和servlet时不同的
 * @Version 1.0
 */
@WebFilter("/s1")
public class Filter2 implements Filter {

    //应用启动的时候便会调用init方法；当前filter被创建的时候会调用init；说明了filter在运行期间也只有一个实例对象
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter2 init");
    }

    //该方法类似于servlet的service方法
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter2 doFilter");

        //具有这行代码，那么便是放行；如果没有这行代码，那么便是拦截
        chain.doFilter(request, response);
    }

    //应用卸载的时候会调用destroy方法
    @Override
    public void destroy() {
        System.out.println("filter2 destroy");
    }
}
