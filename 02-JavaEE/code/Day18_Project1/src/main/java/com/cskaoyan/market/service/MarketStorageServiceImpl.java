package com.cskaoyan.market.service;

import com.cskaoyan.market.db.domain.MarketStorage;
import com.cskaoyan.market.db.mapper.MarketStorageMapper;
import com.cskaoyan.market.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/7 10:25
 * @Version 1.0
 */
public class MarketStorageServiceImpl implements MarketStorageService {
    @Override
    public void create(MarketStorage marketStorage) {
        SqlSession session = MybatisUtils.getSession();
        MarketStorageMapper storageMapper = session.getMapper(MarketStorageMapper.class);

        storageMapper.insert(marketStorage);
        session.commit();
        session.close();
    }
}
