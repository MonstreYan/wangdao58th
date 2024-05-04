package com.cskaoyan.market.service;

import com.cskaoyan.market.db.domain.MarketUser;
import com.cskaoyan.market.db.domain.MarketUserExample;
import com.cskaoyan.market.db.mapper.MarketUserMapper;
import com.cskaoyan.market.util.MybatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/4 11:28
 * @Version 1.0
 */
public class MarketUserServiceImpl implements MarketUserService {
    @Override
    public List<MarketUser> list(Integer limit, Integer page, String username, String mobile, String sort, String order) {
        SqlSession session = MybatisUtils.getSession();
        MarketUserMapper marketUserMapper = session.getMapper(MarketUserMapper.class);
        MarketUserExample marketUserExample = new MarketUserExample();
        // add_time desc 有sql注入的风险，因为此处接收用户的输入数据了
        marketUserExample.setOrderByClause(sort + " " + order);
        MarketUserExample.Criteria criteria = marketUserExample.createCriteria();
        if(!StringUtils.isEmpty(username)){
            criteria.andUsernameLike("%" + username + "%");
        }
        if(!StringUtils.isEmpty(mobile)){
            criteria.andMobileLike("%" + mobile + "%");
        }
        //  select xxx,xxx from market_user where xxx = xx and xx like xxx order by xx desc limit xx offset xxx;
        //在执行查询之前，添加一行代码即可；如果不添加这行代码，那么便是不分页
        //两个参数：当前页；每页数量
        PageHelper.startPage(page, limit);
        List<MarketUser> marketUsers = marketUserMapper.selectByExampleSelective(marketUserExample, MarketUser.Column.addTime, MarketUser.Column.avatar, MarketUser.Column.deleted, MarketUser.Column.gender, MarketUser.Column.id, MarketUser.Column.lastLoginIp, MarketUser.Column.lastLoginTime,
                MarketUser.Column.mobile, MarketUser.Column.nickname, MarketUser.Column.password, MarketUser.Column.sessionKey, MarketUser.Column.status, MarketUser.Column.updateTime,
                MarketUser.Column.userLevel, MarketUser.Column.username, MarketUser.Column.weixinOpenid);
        session.commit();
        session.close();
        return marketUsers;
    }
}
