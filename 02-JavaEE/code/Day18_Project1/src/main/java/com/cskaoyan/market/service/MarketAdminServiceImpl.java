package com.cskaoyan.market.service;

import com.cskaoyan.market.db.domain.MarketAdmin;
import com.cskaoyan.market.db.domain.MarketAdminExample;
import com.cskaoyan.market.db.mapper.MarketAdminMapper;
import com.cskaoyan.market.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/4 9:26
 * @Version 1.0
 */
public class MarketAdminServiceImpl implements MarketAdminService {
    @Override
    public MarketAdmin login(String username, String password) {
        //紧接着应该在service中调用mapper，因为我们使用的是mybatis，所以不需要再去编写mapper实现类对象
        //mapper接口，mapper映射文件里面都是关于表的一系列的操作，其实可以通过模板去生成
        //逆向工程还可以帮助我们去生成实体类对象
        SqlSession session = MybatisUtils.getSession();
        MarketAdminMapper marketAdminMapper = session.getMapper(MarketAdminMapper.class);
        MarketAdminExample marketAdminExample = new MarketAdminExample();
        //criteria用来构造一系列的where条件
        MarketAdminExample.Criteria criteria = marketAdminExample.createCriteria();

        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        MarketAdmin marketAdmin = marketAdminMapper.selectOneByExample(marketAdminExample);
        //todo  判断是否为null， logService.addLog
        session.commit();
        session.close();
        return marketAdmin;
    }
}
