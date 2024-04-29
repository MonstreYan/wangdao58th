package com.cskaoyan.th58.page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 15:17
 * @Version 1.0
 */
@WebServlet("/refresh")
public class RefreshServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //每隔一段时间，刷新页面  时刻刷新显示最新的时间
        resp.setHeader("refresh", "1");
        resp.getWriter().println(new Date());
    }
}
