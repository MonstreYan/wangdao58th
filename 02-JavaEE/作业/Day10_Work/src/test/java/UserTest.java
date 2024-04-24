import com.cskaoyan.th58.bean.User;
import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testRegister(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setPhone("13966753654");
        user.setPassword("zhangsan1987");
        userMapper.insertUser(user);
        session.commit();
        session.close();
    }


    @Test
    public void testLogin(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        String userMessage = "13966753654";
        String password = "zhangsan1987";
        User user = userMapper.selectUser(userMessage, password);
        session.commit();
        session.close();
        Assert.assertNotNull(user);
    }

    @Test
    public void testDelete(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.deleteUser(1);
        session.commit();
        session.close();
    }
}
