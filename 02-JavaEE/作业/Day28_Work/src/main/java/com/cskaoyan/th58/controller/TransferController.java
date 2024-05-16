package com.cskaoyan.th58.controller;

import com.cskaoyan.th58.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 9:37
 * @Version 1.0
 */
@Controller
public class TransferController {

    @Autowired
    TransferService transferService;

    //  /transfer?from=boss&to=lisi&money=10000.0
    @RequestMapping("/transfer")
    @ResponseBody
    public Object transfer(String from, String to, Double money){
        //做一些校验工作
        transferService.transfer(from, to, money);
        return "success";
    }
}
