package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.domain.User;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 15:11
 * @Version 1.0
 */
public interface UserMapper {

    void insertOne(User user);

    User selectOne(Integer id);
}
