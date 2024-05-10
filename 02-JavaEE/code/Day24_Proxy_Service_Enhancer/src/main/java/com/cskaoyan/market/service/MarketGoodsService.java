package com.cskaoyan.market.service;

import com.cskaoyan.market.db.domain.MarketGoods;
import com.cskaoyan.market.db.domain.MarketGoodsAttribute;
import com.cskaoyan.market.db.domain.MarketGoodsProduct;
import com.cskaoyan.market.db.domain.MarketGoodsSpecification;

import java.util.List;
import java.util.Map;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/7 9:44
 * @Version 1.0
 */
public interface MarketGoodsService {
    List<MarketGoods> list(Integer page, Integer limit, String sort, String order, String goodsId, String goodsSn, String name);

    void create(MarketGoods goods, List<MarketGoodsSpecification> specifications, List<MarketGoodsProduct> products, List<MarketGoodsAttribute> attributes);
}
