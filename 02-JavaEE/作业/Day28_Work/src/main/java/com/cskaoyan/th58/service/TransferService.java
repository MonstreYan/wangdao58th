package com.cskaoyan.th58.service;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 9:39
 * @Version 1.0
 */
public interface TransferService {

    void transfer(String from, String to, Double amount);
}
