package com.cskaoyan.th58.mapper;

import com.cskaoyan.th58.bean.UserDetail;

import java.util.List;

public interface UserDetailMapper {

    List<UserDetail> selectByUserIds(List<Integer> userIds);

    UserDetail selectByUserId(Integer userId);
}
