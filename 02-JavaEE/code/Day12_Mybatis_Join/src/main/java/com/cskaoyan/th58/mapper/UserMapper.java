package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.User;

import java.util.List;

public interface UserMapper {

    List<User> selectByIds(List<Integer> ids);


    List<User> selectAll();

    List<User> selectAll2();
}
