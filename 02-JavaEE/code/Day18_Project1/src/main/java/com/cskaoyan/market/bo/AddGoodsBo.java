package com.cskaoyan.market.bo;

import com.cskaoyan.market.db.domain.MarketGoods;
import com.cskaoyan.market.db.domain.MarketGoodsAttribute;
import com.cskaoyan.market.db.domain.MarketGoodsProduct;
import com.cskaoyan.market.db.domain.MarketGoodsSpecification;
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
