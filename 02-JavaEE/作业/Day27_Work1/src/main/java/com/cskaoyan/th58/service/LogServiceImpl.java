package com.cskaoyan.th58.service;

import com.cskaoyan.th58.domain.Log;
import com.cskaoyan.th58.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 9:50
 * @Version 1.0
 */
@Service
public class LogServiceImpl implements LogService{

    @Autowired
    LogMapper logMapper;

    @Override
    public void addLog(Log log) {
        logMapper.addLog(log);
    }
}
