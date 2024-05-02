package com.cskaoyan.th58;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 11:11
 * @Version 1.0
 */
@WebServlet("/item")
public class ItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        /item?id=1 统一的使用request.getParameter来获取
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        //做一些校验
        if(StringUtils.isEmpty(id)){
            resp.getWriter().println("参数不可以为空");
            return;
        }
        List<Product> productList = (List<Product>) getServletContext().getAttribute("productList");
        //判断id是否和某个商品的编号一致，那么便打印该信息，但是不要较真，这里面只是做一个演示
        for (Product product : productList) {
            if(product.getId().equals(id)){
                resp.getWriter().println(product);
            }
        }
        String index = resp.encodeURL(req.getContextPath() + "/index");
        String addCart = resp.encodeURL(req.getContextPath() + "/addCart?id=" + id);
        String viewCart = resp.encodeURL(req.getContextPath() + "/viewCart");

        resp.getWriter().println("<div><a href='" + index + "'>返回首页</a></div>");
        resp.getWriter().println("<div><a href='" + addCart + "'>加入购物车</a></div>");
        resp.getWriter().println("<div><a href='" + viewCart + "'>查看购物车</a></div>");


    }
}
