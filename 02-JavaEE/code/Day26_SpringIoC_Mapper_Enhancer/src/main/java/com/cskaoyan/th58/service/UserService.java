package com.cskaoyan.th58.service;

import com.cskaoyan.th58.domain.User;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 15:15
 * @Version 1.0
 */
public interface UserService {

    void addUser(User user);


    User getUserById(Integer id);
}
