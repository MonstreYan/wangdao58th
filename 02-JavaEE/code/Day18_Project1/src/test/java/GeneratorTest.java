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


    @Test
    public void testInsert(){
        SqlSession session = MybatisUtils.getSession();
        MarketAdminMapper marketAdminMapper = session.getMapper(MarketAdminMapper.class);
        //直接插入
        //如果执行插入操作，使用下面两个方法区别不大
        MarketAdmin marketAdmin = new MarketAdmin();
        marketAdmin.setUsername("admin123456");
        marketAdmin.setPassword("admin123456");
        //实际上，这个表设计的时候，考虑的删除方式是逻辑删除，就是给其设置一个状态位，让用户以为删除了，但是并没有删除
        //大家在写项目的时候，你可以使用deleted逻辑删除，也可以自己去真正删除这条记录，使用物理删除
        marketAdmin.setDeleted(false);
        marketAdminMapper.insert(marketAdmin);
        //属性不为null，才执行插入
        marketAdminMapper.insertSelective(marketAdmin);
        session.commit();
        session.close();
    }


    @Test
    public void testUpdate(){
        SqlSession session = MybatisUtils.getSession();
        MarketAdminMapper marketAdminMapper = session.getMapper(MarketAdminMapper.class);
        //根据example构造的条件去更新当前记录 更新修改全部列
        //比如修改密码时，我们在实体对象中只有id、密码等，没有其他属性，那么可以使用下面的selective，避免将其他属性修改成null
//        marketAdminMapper.updateByExample();
        //根据example构造的条件去修改指定列数据
//        marketAdminMapper.updateByExampleSelective();
        //根据主键修改
//        marketAdminMapper.updateByPrimaryKey();
        session.commit();
        session.close();
    }

    @Test
    public void testDelete(){
        SqlSession session = MybatisUtils.getSession();
        MarketAdminMapper marketAdminMapper = session.getMapper(MarketAdminMapper.class);
        //根据example(就是用来去构造where条件语句的)构造的条件删除当前记录
//        marketAdminMapper.deleteByExample();
        //根据主键去删除当前记录
//        marketAdminMapper.deleteByExample();
        session.commit();
        session.close();
    }
}
