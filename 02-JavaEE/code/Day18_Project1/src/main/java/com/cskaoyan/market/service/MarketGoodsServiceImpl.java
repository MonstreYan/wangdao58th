package com.cskaoyan.market.service;

import com.cskaoyan.market.db.domain.*;
import com.cskaoyan.market.db.mapper.MarketBrandMapper;
import com.cskaoyan.market.db.mapper.MarketCategoryMapper;
import com.cskaoyan.market.db.mapper.MarketGoodsMapper;
import com.cskaoyan.market.util.MybatisUtils;
import com.cskaoyan.market.vo.CatAndBrandVo;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

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
    @Override
    public List<MarketGoods> list(Integer page, Integer limit, String sort, String order, String goodsId, String goodsSn, String name) {
        SqlSession session = MybatisUtils.getSession();
        MarketGoodsMapper marketGoodsMapper = session.getMapper(MarketGoodsMapper.class);
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
        PageHelper.startPage(page, limit);
        List<MarketGoods> marketGoods = marketGoodsMapper.selectByExample(goodsExample);
        session.commit();
        session.close();
        return marketGoods;
    }

    @Override
    public Map<String, Object> catAndBrand() {
        //首先需要查询数据库，查询两张表：category  brand
        SqlSession session = MybatisUtils.getSession();
        MarketCategoryMapper categoryMapper = session.getMapper(MarketCategoryMapper.class);
        MarketBrandMapper brandMapper = session.getMapper(MarketBrandMapper.class);

        List<MarketCategory> categories = categoryMapper.selectByExample(new MarketCategoryExample());
        List<MarketBrand> brands = brandMapper.selectByExample(new MarketBrandExample());

        session.commit();
        session.close();

        //返回响应需要的内容
        Map<String, Object> result = new HashMap<>();
        //填充
        List<CatAndBrandVo> brandList = new ArrayList<>();
        List<CatAndBrandVo> categoryList = new ArrayList<>();
        //同样是根据pid将商品的分类类目信息进行分组
        Map<Integer, List<MarketCategory>> categoriesByPid = groupByPid(categories);

        //先去获取一级类目
        List<MarketCategory> l1Categories = categoriesByPid.get(0);
        for (MarketCategory l1 : l1Categories) {
            //得到的是当前l1类目下的所有的l2类目信息
            List<CatAndBrandVo> childrenOfl1 = new ArrayList<>();

            CatAndBrandVo l1Vo = new CatAndBrandVo(l1.getName(), l1.getId(), childrenOfl1);
            categoryList.add(l1Vo);
            List<MarketCategory> l2Categories = categoriesByPid.get(l1.getId());
            //判断二级类目不为空
            if(l2Categories != null && l2Categories.size() > 0){
                for (MarketCategory l2 : l2Categories) {

                    childrenOfl1.add(new CatAndBrandVo(l2.getName(), l2.getId(), null));
                }
            }
        }

        //随后再去处理品牌信息
        for (MarketBrand brand : brands) {
            //做一个类型的适配转换，因为页面需要的是vo里面的label、value但是实体对象里面不是这个名称
            brandList.add(new CatAndBrandVo(brand.getName(), brand.getId(), null));
        }


        result.put("categoryList", categoryList);
        result.put("brandList", brandList);

        return result;
    }

    //下面的代码主要是根据pid进行分组；新建一个map，遍历每一个分类，利用pid从map中获取数据
    //如果获取不到，则创建一个list，并且把它放入map中。。。。。循环往复进行
    private Map<Integer, List<MarketCategory>> groupByPid(List<MarketCategory> categories) {
        Map<Integer, List<MarketCategory>> categoriesByPid = new HashMap<>();
        for (MarketCategory category : categories) {
            Integer pid = category.getPid();
            List<MarketCategory> list = categoriesByPid.get(pid);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(category);
            categoriesByPid.put(pid, list);

        }
        return categoriesByPid;
    }
}
