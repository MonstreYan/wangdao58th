import com.cskaoyan.th58.mapper.SalaryMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TypeAliasTest {


    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SalaryMapper salaryMapper = sqlSession.getMapper(SalaryMapper.class);
        Integer rows = salaryMapper.deleteByPrimaryKey(3);
        System.out.println(rows);
        sqlSession.commit();
        sqlSession.close();
    }
}
