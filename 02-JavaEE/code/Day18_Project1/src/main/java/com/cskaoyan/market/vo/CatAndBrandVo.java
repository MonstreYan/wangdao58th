package com.cskaoyan.market.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/7 10:04
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatAndBrandVo {

    private String label;

    private Integer value;

    private List<CatAndBrandVo> children;
}
