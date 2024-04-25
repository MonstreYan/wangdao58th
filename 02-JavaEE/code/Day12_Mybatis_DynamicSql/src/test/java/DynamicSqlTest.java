import com.cskaoyan.th58.bean.User;
import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DynamicSqlTest {

    @Test
    public void test1(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectByCondition("aaa123", 1, "18823288226");
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();
    }
}
