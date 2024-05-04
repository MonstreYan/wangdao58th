package com.cskaoyan.market.controller;

import com.cskaoyan.market.db.domain.MarketUser;
import com.cskaoyan.market.service.MarketUserService;
import com.cskaoyan.market.service.MarketUserServiceImpl;
import com.cskaoyan.market.util.JacksonUtil;
import com.cskaoyan.market.util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/4 11:20
 * @Version 1.0
 */
@WebServlet("/admin/user/*")
public class AdminUserController extends HttpServlet {

    private MarketUserService userService = new MarketUserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/admin/user/", "");
        if("list".equals(op)){
            list(req, resp);
        }
    }

    //展示所有的用户信息，分页查询
    //逻辑：根据用户输入的查询条件，查询到符合条件的用户信息列表，但是需要注意的是，需要使用分页来操作，并且还需要设定一个排序规则
    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接收用户提交过来的请求参数信息
        String pageParam = req.getParameter("page");
        String limitParam = req.getParameter("limit");
        String username = req.getParameter("username");
        String mobile = req.getParameter("mobile");
        String sort = req.getParameter("sort");
        String order = req.getParameter("order");
        Integer page = null;
        Integer limit = null;
        try {
            page = Integer.parseInt(pageParam);
            limit = Integer.parseInt(limitParam);
        } catch (NumberFormatException e) {
            Object object = ResponseUtil.badArgument();
            String s = JacksonUtil.getObjectMapper().writeValueAsString(object);
            resp.getWriter().println(s);
            return;
            //throw new RuntimeException(e);
        }
        //处理具体的业务逻辑
        List<MarketUser> marketUserList = userService.list(limit,page, username, mobile, sort, order);
        //返回响应
        Object o = ResponseUtil.okList(marketUserList);
        resp.getWriter().println(JacksonUtil.getObjectMapper().writeValueAsString(o));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
