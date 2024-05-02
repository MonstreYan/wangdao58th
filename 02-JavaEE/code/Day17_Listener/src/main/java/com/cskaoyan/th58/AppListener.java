package com.cskaoyan.th58;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 14:46
 * @Version 1.0
 */
@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //应用启动时，会调用当前方法
        //如果希望在项目启动时读取配置文件，那么便可以将代码写在当前方法中
        System.out.println("context init");
        ServletContext servletContext = sce.getServletContext();
        // context域   获取绝对路径
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //应用卸载时，会调用该方法
    }
}
