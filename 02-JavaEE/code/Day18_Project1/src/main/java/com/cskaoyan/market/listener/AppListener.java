package com.cskaoyan.market.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/8 10:06
 * @Version 1.0
 */
@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //读取配置文件
        loadProperties(sce.getServletContext());
        loadWhiteList(sce.getServletContext());
    }

    //加载白名单
    private void loadWhiteList(ServletContext servletContext) {
        ClassLoader classLoader = AppListener.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("whitelist.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> whiteuris = new ArrayList<>();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null){
                whiteuris.add(line);
            }
            //放入context域中
            servletContext.setAttribute("white", whiteuris);
        }catch (Exception e){

        }


    }

    private void loadProperties(ServletContext servletContext) {
        //读取位于classpath目录下的app.properties文件
        //借助于类加载器来获取
        ClassLoader classLoader = AppListener.class.getClassLoader();
        //利用类加载器提供的获取位于classpath目录下文件输入流的方法来获取文件输入流信息
        InputStream inputStream = classLoader.getResourceAsStream("app.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String path = properties.getProperty("uploadPath");
            String domain = properties.getProperty("domain");
            //直接放入context域
            servletContext.setAttribute("path", path);
            servletContext.setAttribute("domain", domain);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
