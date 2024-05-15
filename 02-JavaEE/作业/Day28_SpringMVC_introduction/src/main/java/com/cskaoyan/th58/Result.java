package com.cskaoyan.th58;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 11:03
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer errno;

    private String errmsg;

    private Object data;
}
