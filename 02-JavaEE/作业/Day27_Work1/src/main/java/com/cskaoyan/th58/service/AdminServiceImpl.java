package com.cskaoyan.th58.service;

import com.cskaoyan.th58.annotation.Log;
import org.springframework.stereotype.Service;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 9:39
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService{

    //需要对其进行增强，当执行当前方法时，需要去写一条操作记录
    @Log
    @Override
    public void addOne() {
        int i = 1 / 0;
        System.out.println("add a admin");
    }
}
