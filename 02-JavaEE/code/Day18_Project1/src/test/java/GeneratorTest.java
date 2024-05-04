import com.cskaoyan.market.db.domain.MarketAdmin;
import com.cskaoyan.market.db.domain.MarketAdminExample;
import com.cskaoyan.market.db.mapper.MarketAdminMapper;
import com.cskaoyan.market.util.MybatisUtils;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/4 10:32
 * @Version 1.0
 */
public class GeneratorTest {

    //通过逆向工程生成的方法，可以帮助我们进行基础的增删改查等操作
    //大家需要做的事情就是知道哪些方法在哪些场景下使用
    @Test
    public void testSelect(){
        SqlSession session = MybatisUtils.getSession();
        MarketAdminMapper marketAdminMapper = session.getMapper(MarketAdminMapper.class);
        MarketAdminExample marketAdminExample = new MarketAdminExample();
        //criteria用来存储构造出来的条件
        MarketAdminExample.Criteria criteria = marketAdminExample.createCriteria();
        criteria.andUsernameEqualTo("admin123");
        //表示的是根据example构造的条件查询一个对象
        MarketAdmin marketAdmin = marketAdminMapper.selectOneByExample(marketAdminExample);
        //根据example构造的条件查询多个对象
        List<MarketAdmin> marketAdmins = marketAdminMapper.selectByExample(marketAdminExample);
        //指的是根据example构造的条件查询多个对象，但是并不会查询全部列，而是查询指定的列
        List<MarketAdmin> marketAdmins2 = marketAdminMapper.selectByExampleSelective(marketAdminExample, MarketAdmin.Column.id, MarketAdmin.Column.username, MarketAdmin.Column.password, MarketAdmin.Column.avatar);
        //根据主键进行查询
        MarketAdmin marketAdmin2 = marketAdminMapper.selectByPrimaryKey(1);
        session.commit();
        session.close();
    }
}
