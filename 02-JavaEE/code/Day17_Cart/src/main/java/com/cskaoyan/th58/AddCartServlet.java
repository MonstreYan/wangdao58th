package com.cskaoyan.th58;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 11:30
 * @Version 1.0
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        //做一些校验
        if(StringUtils.isEmpty(id)){
            resp.getWriter().println("参数不可以为空");
            return;
        }
        //加入购物车：
        HttpSession session = req.getSession();
        String index = resp.encodeURL(req.getContextPath() + "/index");

        //每个人的购物车里面永远只有一个商品
//        session.setAttribute("id:" + id, null);
//        session.setAttribute("id", id);

        // todo 介绍一个思想：先get后set
        List<String> ids = (List<String>) session.getAttribute("ids");
        if(ids == null){
            ids = new ArrayList<>();
        }
        ids.add(id);
        session.setAttribute("ids", ids);
        resp.setHeader("refresh", "2;url=" + index);
    }
}
