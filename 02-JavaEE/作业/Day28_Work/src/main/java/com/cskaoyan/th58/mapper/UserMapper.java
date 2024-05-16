package com.cskaoyan.th58.mapper;


import org.apache.ibatis.annotations.Param;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 9:39
 * @Version 1.0
 */
public interface UserMapper {

    void updateMoneyByName(@Param("name") String name,@Param("money") Double money);
}
