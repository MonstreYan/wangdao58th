package com.cskaoyan.th58.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 11:42
 * @Version 1.0
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //配置Spring的启动类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    //配置SpringMVC启动类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    //配置SpringMVC核心控制器DispatcherSerlvet的url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
