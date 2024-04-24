package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.User;

import java.util.List;

public interface UserMapper {

    String selectNameById(Integer id);


    //查询用户所有的姓名
    List<String> selectNames();


    //查询一行数据------> 封装到一个对象中
    User selectById(Integer id);

    List<User> selectAll();
}
