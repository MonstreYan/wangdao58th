import com.cskaoyan.th58.bean.User;
import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {


    @Test
    public void testRegister(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("zhangsan123");

        //准备表名
        int index = user.getName().hashCode() % 3;
        System.out.println(index);
        userMapper.insertUser(user, "user" + index);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testLogin(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        String name = "zhangsan";
        String password = "zhangsan123";

        int index = name.hashCode() % 3;

        User user = userMapper.selectUser(name, password, "user" + index);
        sqlSession.commit();
        sqlSession.close();
        Assert.assertNotNull(user);
    }
}
