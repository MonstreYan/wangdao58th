package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 11:01
 * jd  :item.jd.com/xxxx.html -------------   *.html
 * taobao  item.taobao.com/item.htm?id=xxx
 * @Version 1.0
 */
//使得init方法随着应用的启动而调用
@WebServlet(value = "/index",loadOnStartup = 1)
public class HomeIndexServlet extends HttpServlet {

    //让init方法提前执行
    @Override
    public void init() throws ServletException {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("1", "问界M5", "入门款智驾车"));
        productList.add(new Product("2", "问界M7", "中级智驾车"));
        productList.add(new Product("3", "小米su7", "明星流量车型"));
        productList.add(new Product("4", "极氪001", "猎装车"));
        getServletContext().setAttribute("productList", productList);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接下来，我们自己去创建几个商品，用来去模拟从数据库中检索出的商品信息
        resp.setContentType("text/html;charset=UTF-8");

        List<Product> productList = (List<Product>) getServletContext().getAttribute("productList");
        for (Product product : productList) {
            String item = resp.encodeURL(req.getContextPath() + "/item?id=" + product.getId());
            resp.getWriter().println("<div><a href='" + item + "'>" + product.getName() + "</a></div>");
        }
    }
}
