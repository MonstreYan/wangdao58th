package com.cskaoyan.th58.controller;

import com.cskaoyan.th58.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 10:35
 * @Version 1.0
 */
//@WebServlet("/user/*")
public class UserServlet_bak extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先先进行方法的分发
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("register".equals(op)){
            register(req, resp);
        }else if("login".equals(op)){
            login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {

    }

    //注册的业务逻辑：
    //接收用户提交过来的请求参数信息，进行校验，保障用户信息的唯一性，存储到系统中，给用户返回回执信息
    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接收用户提交过来的请求参数信息：还是使用的是form表单，依然是key=value&key=value
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPass = req.getParameter("confirmPass");
        //保障数据都不为空
        if(StringUtils.isEmpty(username)){
            resp.getWriter().println("用户名不能为空");
            return;
        }
        if(StringUtils.isEmpty(password)){
            resp.getWriter().println("密码不能为空");
            return;
        }
        if(StringUtils.isEmpty(confirmPass)){
            resp.getWriter().println("确认密码不能为空");
            return;
        }
        //确认密码和确认密码一致
        if(!password.equals(confirmPass)){
            resp.getWriter().println("两次密码不一致");
            return;
        }
        //因为我们先使用json文件来存储用户的信息，首先我们要确认当前用户名在json文件中是唯一的
        //如果json文件中最终存储了很多人的信息，那么应该是[{"username":"", "password": "sda"},{},{}]------》 List<User>
        //位于classpath目录下有这么一个文件，需要去做的事情便是去读取该文件里面的数据，确认当前用户名是否唯一
        String path = UserServlet_bak.class.getClassLoader().getResource("users.json").getPath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String content = bufferedReader.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> registeredUsers = new ArrayList<>();
        //文件里面的数据存储的是用户的信息，应该是一个json字符串，但是要考虑到文件为空的情况
        if(!StringUtils.isEmpty(content)){
            //不为空-----说明有人注册过程
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType collectionType = typeFactory.constructCollectionType(List.class, User.class);
            registeredUsers = objectMapper.readValue(content, collectionType);
            for (User registeredUser : registeredUsers) {
                if(username.equals(registeredUser.getUsername())){
                    resp.getWriter().println("当前用户名已经被注册");
                    return;
                }
            }
        }
        registeredUsers.add(new User(username, password));
        //空，说明直接没有人注册过，直接注册即可，无需去做任何的校验判断

        //最后，把registeredUsers全量的数据写回到文件中
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(objectMapper.writeValueAsString(registeredUsers));
        fileWriter.flush();
        fileWriter.close();
        resp.getWriter().println("注册成功");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
