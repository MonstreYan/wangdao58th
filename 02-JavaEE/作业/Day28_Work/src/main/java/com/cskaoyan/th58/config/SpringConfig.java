package com.cskaoyan.th58.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 9:36
 * @Version 1.0
 */
@Configuration
@ComponentScan(value = "com.cskaoyan.th58",excludeFilters = @ComponentScan.Filter({Controller.class, EnableWebMvc.class}))
@EnableTransactionManagement
public class SpringConfig {


    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/tx?characterEncoding=utf-8&useSSL=false");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        return druidDataSource;
    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean;
    }

    @Bean
    public MapperScannerConfigurer configurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //这个扫描包目录必须指定到mapper的那一级，否则会扫描serivce等
        //invalid bond statement:1.mapper接口和mapper映射文件在不在一起
        configurer.setBasePackage("com.cskaoyan.th58.mapper");
        return configurer;
    }

    //事务
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
      return  new DataSourceTransactionManager(dataSource);
    }
}
