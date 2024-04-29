package com.cskaoyan.th58._02param;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/27 11:26
 * @Version 1.0
 */
@WebServlet("/param3")
public class ParamServlet3 extends HttpServlet {

    //使用反射来进行处理的思路：

    /**
     * 目前有一个请求参数的键值对 username:xxx;password:xxxx;gender:xxxx;course:xxxx;province:xxxxx
     * 还有一个user对象，里面有对应的成员变量，变量的名称和请求参数的key的值是相同的
     * 需要做的事情便是利用Class对象，去查找到对应的成员变量或者set方法(set + key首字母大写)，利用反射去赋值，赋什么值呢？请求参数键值对的value值
     * 成员变量进行赋值：  field.set(obj, args);
     * set方法进行赋值：  method.invoke(obj, args);
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //把获取到的请求参数的数据封装到一个user对象中
        User user = new User();
        //工具类的这个方法就是把第二个参数map里面的键值对封装到第一个参数object对象中
        try {
            BeanUtils.populate(user, req.getParameterMap());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        System.out.println(user);
    }
}
