package com.cskaoyan.th58;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 16:25
 * @Version 1.0
 */
@WebListener
public class ConfigListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //读取位于classpath目录下的auth.txt文件
        //由于文件里面的请求资源是一行一行的；所以我希望可以readline
        //使用类加载器来获取位于classpath目录下文件的输入流
        InputStream inputStream = ConfigListener.class.getClassLoader().getResourceAsStream("auth.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        List<String> uris = new ArrayList<>();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null){
                //line就是一个请求的资源路径
                uris.add(line);
            }
            //最终放入context域中，和filter进行共享
            ServletContext servletContext = sce.getServletContext();
            servletContext.setAttribute("uris", uris);
        }catch (Exception e){

        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
