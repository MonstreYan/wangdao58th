package com.cskaoyan.th58.service;

import com.cskaoyan.th58.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 9:39
 * @Version 1.0 SSM架构来开发
 */
@Service
public class TransferServiceImpl implements TransferService{

    @Autowired
    UserMapper userMapper;

    @Transactional
    @Override
    public void transfer(String from, String to, Double amount) {

        userMapper.updateMoneyByName(from, amount);
        //int i = 1 /0;
        userMapper.updateMoneyByName(to, -amount);
    }
}
