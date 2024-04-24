import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class OutputTest {

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        String name = userMapper.selectNameById(1);
        System.out.println(name);
        sqlSession.commit();
        sqlSession.close();
    }
}
