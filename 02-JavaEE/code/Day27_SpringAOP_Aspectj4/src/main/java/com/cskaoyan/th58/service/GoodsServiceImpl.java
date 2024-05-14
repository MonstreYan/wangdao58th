package com.cskaoyan.th58.service;

import com.cskaoyan.th58.annotation.Log;
import org.springframework.stereotype.Service;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 9:41
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService{
    //对于当前方法进行增强
    @Log
    @Override
    public Integer addOne() {
        System.out.println("goods service addOne");
        int i  = 1 / 0;
        return 2;
    }

    @Override
    public void selectOne() {
        System.out.println("goods service selectOne");
    }
}
