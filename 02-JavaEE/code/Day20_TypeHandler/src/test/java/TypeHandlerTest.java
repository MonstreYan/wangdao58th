import com.cskaoyan.th58.MybatisUtils;
import com.cskaoyan.th58.domain.User;
import com.cskaoyan.th58.mapper.UserMapper;
import lombok.ToString;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/6 10:53
 * @Version 1.0
 */
public class TypeHandlerTest {

    @Test
    public void test1(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectOne(1);
        System.out.println(user);
        session.commit();
        session.close();
    }

    @Test
    public void test2(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.insertOne(new User(null, "空灵", "male"));
        session.commit();
        session.close();
    }
}
