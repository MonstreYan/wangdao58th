import com.cskaoyan.th58.bean.Salary;
import com.cskaoyan.th58.mapper.SalaryMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class InputTest {

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SalaryMapper salaryMapper = sqlSession.getMapper(SalaryMapper.class);
        Salary salary = salaryMapper.selectOneById(4);
        System.out.println(salary);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SalaryMapper salaryMapper = sqlSession.getMapper(SalaryMapper.class);
        Salary salary = salaryMapper.selectOneById2(4);
        System.out.println(salary);
        sqlSession.commit();
        sqlSession.close();
    }
}
