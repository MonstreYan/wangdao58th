package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 11:40
 * @Version 1.0
 */
@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看购物车 ids
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        List<String> ids = (List<String>) session.getAttribute("ids");
        String index = resp.encodeURL(req.getContextPath() + "/index");

        if(ids == null){
            resp.setHeader("refresh", "2;url=" + index);
            return;
        }
        //商品中除了id编号之外的其他部分位于context域中
        List<Product> productList = (List<Product>) getServletContext().getAttribute("productList");
        for (String id : ids) {
            for (Product product : productList) {
                if(id.equals(product.getId())){
                   resp.getWriter().println(product);
                }
            }
        }

    }
}
