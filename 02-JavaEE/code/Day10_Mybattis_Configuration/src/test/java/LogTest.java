import com.cskaoyan.th58.bean.Log;
import com.cskaoyan.th58.mapper.LogMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class LogTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        Log log = logMapper.selectOne(1);
        System.out.println(log);
        sqlSession.commit();
        sqlSession.close();
    }
}
