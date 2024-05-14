package com.cskaoyan.market.controller;

import com.cskaoyan.market.db.domain.MarketAdmin;
import com.cskaoyan.market.service.MarketAdminService;
import com.cskaoyan.market.service.MarketAdminServiceImpl;
import com.cskaoyan.market.util.JacksonUtil;
import com.cskaoyan.market.util.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 16:26
 * @Version 1.0
 */
@WebServlet("/admin/auth/*")
public class AdminAuthController extends HttpServlet {

    //@Autowired
    private MarketAdminService adminService;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/admin/auth/", "");
        if("login".equals(op)) {
            login(req, resp);
        }
    }

    //登录的流程：获取接收用户的请求参数信息；校验，系统中进行比对(调用service、mapper)，根据比对的结果返回一个回执信息
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //不能用，因为不是key=value&key=value格式
//        String username = req.getParameter("username");
        //下面两个方法都是可以获取请求体的，只不过第二个又进一步包装了一下，可以使用readLine方法，更加简化一些
//        req.getInputStream();
        String requestBody = req.getReader().readLine();
        System.out.println(requestBody);
        //可以使用之前介绍的方法，objectMapper.readValue使用一个对象来接收，便可以完成数据的封装工作
        //但是如果使用上述方案，那么需要去构建一个类Admin，此时我不想去额外再去构建一个类
        //可以使用objectMapper提供的另外的功能，将json字符串解析成为一棵树，去读取指定的节点
        //一般情况下，如果json字符串里面额度属性非常少，比如就一两个，那么此时额外构造一个类，就比较不划算，此时可以使用下面的方法来进行
        // {"username":"admin","password":"admin13"}或者{"id":5}建议直接使用下面的方法来去获取json字符串里面的数据，不需要准备额外构建一个类对象
        String username = JacksonUtil.parseString(requestBody, "username");
        String password = JacksonUtil.parseString(requestBody, "password");

        //做一些校验工作
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            //
            Object fail = ResponseUtil.fail(404, "用户名或者密码不能为空");
            String jsonStr = JacksonUtil.getObjectMapper().writeValueAsString(fail);
            resp.getWriter().println(jsonStr);

            return;
        }
        //调用模型的代码，也就是进一步去调用service，service进一步去调用mapper
        //返回一个对象还是返回一个数量，查询到的行数？？？？？？应该返回哪一个，取决于后面的业务有没有获取除了用户名以外的其他信息，比如头像等信息
        //返回一个MarketAdmin对象比较合适
        MarketAdmin marketAdmin = adminService.login(username, password);
        if(marketAdmin == null){
            //todo  记录用户登录失败 logService.addLog();
            //用户名、密码错误    {"errno":605,"errmsg":"用户帐号或密码不正确"}
            //状态码每个小组可以自定义，前端只会去判断是否为0，如果不为0，那么便是出错；至于具体的数字只是为了调用者可以很方便的地排查故障
            Object fail = ResponseUtil.fail(605, "用户名或者密码不正确");
            String jsonStr = JacksonUtil.getObjectMapper().writeValueAsString(fail);
            resp.getWriter().println(jsonStr);
            return;
        }
        //todo 记录用户登录成功 logService.addLog()
        //用户名、密码匹配------做到和公网具有相同的返回结果
        //设置响应体 字符流  字节流
        Map<String, Object> data = new HashMap<>();
        Map<String, String> adminInfo = new HashMap<>();
        adminInfo.put("nickName", marketAdmin.getUsername());
        adminInfo.put("avatar", marketAdmin.getAvatar());
        data.put("adminInfo", adminInfo);
        //token其实就是session域的编号
        HttpSession session = req.getSession();
        session.setAttribute("admin", marketAdmin);
        data.put("token", session.getId());
        Object ok = ResponseUtil.ok(data);
        resp.getWriter().println(JacksonUtil.getObjectMapper().writeValueAsString(ok));
//        resp.getWriter().println();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/admin/auth/", "");
        if("info".equals(op)) {
            info(req, resp);
        }
    }

    private void info(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //当前结果需要返回上述的json字符串
        //从session域里面获取
        HttpSession session = req.getSession();
        MarketAdmin admin = (MarketAdmin) session.getAttribute("admin");
        Map<String, Object> data = new HashMap<>();
        //roles和perms是关于权限相关的，大家项目一不用去操心，直接固定写死，让接口通过即可
        data.put("roles", Arrays.asList("超级管理员"));
        data.put("name", admin.getUsername());
        data.put("perms", Arrays.asList("*"));
        data.put("avatar", admin.getAvatar());
        Object ok = ResponseUtil.ok(data);
        resp.getWriter().println(JacksonUtil.getObjectMapper().writeValueAsString(ok));
    }
}
