package com.cskaoyan.market.controller;

import com.cskaoyan.market.service.MarketRegionService;
import com.cskaoyan.market.service.MarketRegionServiceImpl;
import com.cskaoyan.market.util.JacksonUtil;
import com.cskaoyan.market.util.ResponseUtil;
import com.cskaoyan.market.vo.MarketRegionVo;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/6 9:36
 * @Version 1.0
 */
@WebServlet(value = "/admin/region/*",loadOnStartup = 1)
public class AdminRegionController extends HttpServlet {

    private MarketRegionService regionService = new MarketRegionServiceImpl();

    @Override
    public void init() throws ServletException {
        //list代码写在这
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/admin/region/", "");
        if("list".equals(op)) {
            list(req, resp);
        }
    }

    //无论任何一个接口，都分为三步：1.接收请求参数 抓包  本地  2.处理业务逻辑 思考 3，返回响应 抓包 抓取公网上面部署的项目
    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //行政区域数据需要每次都查询吗？会经常变化吗？可不可以查询一次之后，放入内存中
        //先尝试从context域中获取，如果获取不到，再进行数据库查询
        ServletContext servletContext = getServletContext();
        List<MarketRegionVo> marketRegionVoList = (List<MarketRegionVo>) servletContext.getAttribute("region");
        if(marketRegionVoList == null){
            //如果context域获取不到，则从数据库查询，但是随后需要把查询到的结果更新到context域
            marketRegionVoList = regionService.list();
            servletContext.setAttribute("region", marketRegionVoList);
        }

        Object o = ResponseUtil.okList(marketRegionVoList);
        resp.getWriter().println(JacksonUtil.getObjectMapper().writeValueAsString(o));
    }
}
