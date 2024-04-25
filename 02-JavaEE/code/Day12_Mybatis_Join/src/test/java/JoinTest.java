import com.cskaoyan.th58.bean.Clazz;
import com.cskaoyan.th58.bean.User;
import com.cskaoyan.th58.bean.UserDetail;
import com.cskaoyan.th58.mapper.ClassMapper;
import com.cskaoyan.th58.mapper.UserDetailMapper;
import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JoinTest {

    @Test
    public void test1(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        UserDetailMapper userDetailMapper = session.getMapper(UserDetailMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        List<User> userList = userMapper.selectByIds(ids);
        List<UserDetail> userDetails = userDetailMapper.selectByUserIds(ids);
        for (User user : userList) {
            for (UserDetail userDetail : userDetails) {
                if(userDetail.getUserId().equals(user.getId())){
                    user.setUserDetail(userDetail);
                    System.out.println(user);
                }
            }
        }
        session.commit();
        session.close();
    }


    @Test
    public void test2(){
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
    public void test3(){
        SqlSession session = MybatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAll2();
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();
    }


    //封装class和studentList
    @Test
    public void test4(){
        SqlSession session = MybatisUtils.getSession();
        ClassMapper classMapper = session.getMapper(ClassMapper.class);
        List<Clazz> clazzes = classMapper.selectAll();
        for (Clazz clazz : clazzes) {
            System.out.println(clazz);
        }
        session.commit();
        session.close();
    }

    @Test
    public void test5(){
        SqlSession session = MybatisUtils.getSession();
        ClassMapper classMapper = session.getMapper(ClassMapper.class);
        List<Clazz> clazzes = classMapper.selectAll2();
        for (Clazz clazz : clazzes) {
            System.out.println(clazz);
        }
        session.commit();
        session.close();
    }
}
