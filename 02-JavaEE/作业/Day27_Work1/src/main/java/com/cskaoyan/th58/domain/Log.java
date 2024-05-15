package com.cskaoyan.th58.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 9:36
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    private Integer id;

    private String operationMethod;

    private Date addTime;

    private Integer success;

    private String errorMsg;


}
