import com.cskaoyan.th58.bean.User;
import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void test2(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectByCondition2(null, "18823288226", "86546783@qq.com", "admin12333");
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();
    }

    @Test
    public void test3(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();
    }

    @Test
    public void test4(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectByCondition3(new User(1, "aaa123", null, null, null));
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();
    }

    @Test
    public void test5(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        userMapper.updateUserById(new User(1, "admin123",null, null, null));
        session.commit();
        session.close();
    }

    @Test
    public void test6(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //根据id值只去修改username
        userMapper.updateUserById2(new User(2, "admin456", "13678654278", null, null));
        session.commit();
        session.close();
    }

    @Test
    public void test7(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //根据id值只去修改username
        userMapper.updateUserById3(new User(3, "admin456", "13678654278", null, null));
        session.commit();
        session.close();
    }

    @Test
    public void test8(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = new ArrayList<>();
        users.add(new User(null, "kongling", "13565478972", "8765432@qq.com", "kongling12323"));
        users.add(new User(null, "aqi", "237123127362836", "87788282@qq.com", "ajksdjsadjlkklad"));
        userMapper.insertUsers(users);
        session.commit();
        session.close();
    }
}
