import com.cskaoyan.th58.bean.Log;
import com.cskaoyan.th58.bean.User;
import com.cskaoyan.th58.mapper.LogMapper;
import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<String> names = userMapper.selectNames();
        for (String name : names) {
            System.out.println(name);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(1);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testLog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logList = logMapper.selectAll();
        for (Log log : logList) {
            System.out.println(log);
        }
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testLog2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logList = logMapper.selectAll2();
        for (Log log : logList) {
            System.out.println(log);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
