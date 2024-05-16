package com.cskaoyan.th58.bo;

import com.cskaoyan.th58.db.domain.MarketGoods;
import com.cskaoyan.th58.db.domain.MarketGoodsAttribute;
import com.cskaoyan.th58.db.domain.MarketGoodsProduct;
import com.cskaoyan.th58.db.domain.MarketGoodsSpecification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/7 11:13
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddGoodsBo {

    private MarketGoods goods;

    private List<MarketGoodsSpecification> specifications;

    private List<MarketGoodsProduct> products;

    private List<MarketGoodsAttribute> attributes;
}
