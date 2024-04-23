import com.cskaoyan.th58.bean.Account;
import com.cskaoyan.th58.mapper.AccountMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TransaferTest {


    @Test
    public void testTransfer(){
        SqlSession session = MybatisUtils.getSession();
        AccountMapper mapper = session.getMapper(AccountMapper.class);
        //此时就不需要再去开启事务之类的操作了，因为sqlSession封装的connection默认就是不会自动提交事务
        Account fromAccount = new Account();
        fromAccount.setName("boss");
        fromAccount.setMoney(12000.0);

        Account toAccount = new Account();
        toAccount.setName("zhangsan");
        toAccount.setMoney(-12000.0);

        try {
            mapper.updateMoneyByName(fromAccount);
            int i = 1 / 0;
            mapper.updateMoneyByName(toAccount);
            //session的commit其实就是对于jdbc的commit的封装
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }
}
