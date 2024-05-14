package com.cskaoyan.th58.service;

import com.cskaoyan.th58.annotation.Log;
import org.springframework.stereotype.Service;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 11:20
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Log(type = "订单操作", action = "发货")
    @Override
    public void ship() {

    }

    @Log(type = "订单操作", action = "删除")
    @Override
    public void delete() {

    }
}
