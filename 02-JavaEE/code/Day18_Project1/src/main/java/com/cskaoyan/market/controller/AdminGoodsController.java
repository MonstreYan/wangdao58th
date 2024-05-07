package com.cskaoyan.market.controller;

import com.cskaoyan.market.db.domain.MarketGoods;
import com.cskaoyan.market.service.MarketGoodsService;
import com.cskaoyan.market.service.MarketGoodsServiceImpl;
import com.cskaoyan.market.util.JacksonUtil;
import com.cskaoyan.market.util.ResponseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/7 9:39
 * @Version 1.0
 */
@WebServlet("/admin/goods/*")
public class AdminGoodsController extends HttpServlet {

    private MarketGoodsService goodsService = new MarketGoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/admin/goods/", "");
        if("list".equals(op)){
            list(req, resp);
        }else if("catAndBrand".equals(op)){
            catAndBrand(req, resp);
        }
    }

    //这个接口我们需要做的事情便是返回品牌和商品分类的信息，商品的分类需要注意有一二级分类
    private void catAndBrand(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> data =  goodsService.catAndBrand();
        Object ok = ResponseUtil.ok(data);
        resp.getWriter().println(JacksonUtil.getObjectMapper().writeValueAsString(ok));
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pageParam = req.getParameter("page");
        String limitParam = req.getParameter("limit");
        String goodsSn = req.getParameter("goodsSn");
        String name = req.getParameter("name");
        String sort = req.getParameter("sort");
        String order = req.getParameter("order");
        String goodsId = req.getParameter("goodsId");

        Integer limit = null;
        Integer page = null;
        try {
            limit = Integer.parseInt(limitParam);
            page = Integer.parseInt(pageParam);
        }catch (Exception e){
            //直接返回一个响应结果
            resp.getWriter().println(JacksonUtil.getObjectMapper().writeValueAsString(ResponseUtil.badArgument()));
            return;
        }
        List<MarketGoods> goodsList = goodsService.list(page, limit, sort, order, goodsId, goodsSn, name);
        Object o = ResponseUtil.okList(goodsList);
        resp.getWriter().println(JacksonUtil.getObjectMapper().writeValueAsString(o));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
