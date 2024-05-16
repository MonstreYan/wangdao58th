package com.cskaoyan.th58.controller;

import com.cskaoyan.th58.model.MarketAdmin;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 16:44
 * @Version 1.0
 */
@RestController
@RequestMapping("admin/auth")
public class AdminAuthController {

    @PostMapping("login")
    public Object login(@RequestBody Map map, HttpSession session){
        String username = (String) map.get("username");
        String password = (String) map.get("password");

        return null;
    }

    @GetMapping("info")
    public Object info(@SessionAttribute("admin") MarketAdmin admin){

        return null;
    }
}
