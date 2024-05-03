package com.cskaoyan.th58.controller;

import com.cskaoyan.th58.mapper.UserJsonMapper;
import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.model.User;
import com.cskaoyan.th58.model.UserDBModel_deprecate;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 10:35
 * @Version 1.0
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {

    //思考一个问题：如果注册时候使用的是json文件，那么登录的时候也应该要使用json文件
    //那么是否意味着下面的这一个接口指向之类实现，可以写成成员变量
    //写成成员变量之后，那么方法内部还有没有需要变更的部分？？？？？？？？
    UserMapper userMapper = new UserJsonMapper();


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
        //UserMapper userMapper = new UserJsonMapper();
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
        //变更这一行代码 进行下面两行代码的切换即可

        Integer code = userMapper.register(new User(username, password));

//        Integer code = UserDBModel_deprecate.register(new User(username, password));
//        Integer code = UserJsonModel.register(new User(username, password));

        if(code == 404){
            resp.getWriter().println("当前用户名已经被注册");
        }else if(code == 200){
            resp.getWriter().println("注册成功");
        }else {
            resp.getWriter().println("服务器繁忙");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
