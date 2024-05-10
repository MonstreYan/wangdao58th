package com.cskaoyan.market.service;

import com.cskaoyan.market.db.domain.*;
import com.cskaoyan.market.db.mapper.*;
import com.cskaoyan.market.util.MybatisUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/7 9:44
 * @Version 1.0
 */
public class MarketGoodsServiceImpl implements MarketGoodsService {

    //这些成员变量mapper，此时肯定为null，所以运行绝对会出现空指针异常，需要做的事情便是在代理类对象里面帮助我们做两件事：
    //1.获取session，最后进行session的commit和close  2.给mapper成员变量进行赋值操作
    MarketGoodsMapper marketGoodsMapper;

    MarketGoodsSpecificationMapper specificationMapper;
    MarketGoodsProductMapper productMapper;
    MarketGoodsAttributeMapper attributeMapper;


    @Override
    public List<MarketGoods> list(Integer page, Integer limit, String sort, String order, String goodsId, String goodsSn, String name) {
        MarketGoodsExample goodsExample = new MarketGoodsExample();
        //设置排序规则
        goodsExample.setOrderByClause(sort + " " + order);
        MarketGoodsExample.Criteria criteria = goodsExample.createCriteria();
        if(!StringUtils.isEmpty(goodsId)){
            criteria.andIdEqualTo(Integer.parseInt(goodsId));
        }
        if(!StringUtils.isEmpty(goodsSn)){
            criteria.andGoodsSnEqualTo(goodsSn);
        }
        if(!StringUtils.isEmpty(name)){
            criteria.andNameLike("%"+name+"%");
        }

        //分页查询 代码一定要紧跟着查询语句，不要中间间隔很多行代码，如果中间代码出现问题，很容易会出现分页异常
        List<MarketGoods> marketGoods = marketGoodsMapper.selectByExample(goodsExample);
        return marketGoods;
    }


    @Override
    public void create(MarketGoods goods, List<MarketGoodsSpecification> specifications, List<MarketGoodsProduct> products, List<MarketGoodsAttribute> attributes) {
        //存储几张表 4张表
        //需要先插入goods表

        //首先插入goods表
        //零售价格---所有规格中较低的一个价格
        //获取所有的货品价格，取一个较低的价格
        //在外部设置一个较大的变量，如果遇到小值，则更新；取index=0下标的；如果后续遇到小值，也是更新
        BigDecimal price = products.get(0).getPrice();
        for (int i = 1; i < products.size(); i++) {
            //如果后续出现了一个更小的值，则更新price的值
            BigDecimal decimal = products.get(i).getPrice();
            if(price.compareTo(decimal) == 1){
                //表示price 大于decimal的值，出现更小值，则把更小的值赋值给price
                price = decimal;
            }
        }
        goods.setRetailPrice(price);
        goods.setAddTime(LocalDateTime.now());
        goods.setUpdateTime(LocalDateTime.now());
        goods.setDeleted(false);

        //最终要保障事务
            marketGoodsMapper.insertSelective(goods);
            Integer id = goods.getId();
            //插入规格
            //对于另外三张表来说，需要goods的编号，怎么获取goods的编号？？？？？goods.getId即可
            for (MarketGoodsSpecification sp : specifications) {
                sp.setGoodsId(id);
                sp.setAddTime(LocalDateTime.now());
                sp.setUpdateTime(LocalDateTime.now());
                sp.setDeleted(false);
                specificationMapper.insertSelective(sp);
            }
            for (MarketGoodsProduct product : products) {
                product.setGoodsId(id);
                product.setAddTime(LocalDateTime.now());
                product.setUpdateTime(LocalDateTime.now());
                product.setDeleted(false);
                productMapper.insertSelective(product);
            }
            for (MarketGoodsAttribute attribute : attributes) {
                attribute.setGoodsId(id);
                attribute.setAddTime(LocalDateTime.now());
                attribute.setUpdateTime(LocalDateTime.now());
                attribute.setDeleted(false);
                attributeMapper.insertSelective(attribute);
            }
    }

}
