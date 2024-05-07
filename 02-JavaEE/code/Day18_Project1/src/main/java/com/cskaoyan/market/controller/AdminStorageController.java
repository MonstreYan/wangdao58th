package com.cskaoyan.market.controller;

import com.cskaoyan.market.db.domain.MarketStorage;
import com.cskaoyan.market.service.MarketStorageService;
import com.cskaoyan.market.service.MarketStorageServiceImpl;
import com.cskaoyan.market.util.JacksonUtil;
import com.cskaoyan.market.util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/7 10:17
 * @Version 1.0
 */
@WebServlet("/admin/storage/*")
//让服务器帮助我们去解析上传的文件
@MultipartConfig
public class AdminStorageController extends HttpServlet {

    private MarketStorageService storageService = new MarketStorageServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/admin/storage/", "");
        if("create".equals(op)){
            create(req, resp);
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        String fileName = part.getSubmittedFileName();
        String contentType = part.getContentType();
        long size = part.getSize();
        String key  = UUID.randomUUID() + "-" + fileName;
        //打算把文件存储在任意目录下，不用限制一定得在应用根目录下
        //不在应用根目录下，那么便无法在借助于缺省Servlet，你必须得自己去写一个servlet来处理
        //文件假定放在D:/image/目录下 todo
        String basePath = "D:\\image";
        part.write(basePath + "\\" + key);

        //把上传的这条记录存储到数据库中
        MarketStorage marketStorage = new MarketStorage();
        marketStorage.setDeleted(false);
        marketStorage.setAddTime(LocalDateTime.now());
        //创建的时候设定两个时间，后续更改的时候只需要设置update time即可
        marketStorage.setUpdateTime(LocalDateTime.now());
        //url可以存储http://localhost:8083/wx/storage/fetch/xxx.jpg，但是以这种形式存储到数据库有一个风险
        //如果后续你的ip地址、端口号改变了，那么图片便无法正常显示了，此时你的改动就比较大
        //此时可以在数据库中存储主机端口号后面的部分；接口要求返回的内容，后续在追加上
        String relativePath = "/wx/storage/fetch/" + key;
        marketStorage.setUrl(relativePath);
        marketStorage.setType(contentType);
        //key是最终的名称；name是上传的名字
        marketStorage.setKey(key);
        marketStorage.setName(fileName);
        marketStorage.setSize((int) size);
        //随后将要保存到数据库
        storageService.create(marketStorage);

        //在这个地方再对url进行处理，追加上主机端口号
        //此时，经过数据库存储之后id便有了值，然后对url进行处理
        //todo 明天将其写入到配置文件中
        String url = marketStorage.getUrl();
        marketStorage.setUrl("http://localhost:8083" + url);
        //响应出去
        resp.getWriter().println(JacksonUtil.getObjectMapper().writeValueAsString(ResponseUtil.ok(marketStorage)));
    }
}
