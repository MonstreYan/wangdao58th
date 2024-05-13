import com.cskaoyan.th58.config.SpringConfig;
import com.cskaoyan.th58.domain.User;
import com.cskaoyan.th58.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 15:29
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {

    //能够使用这个注解的前提是需要再spring维护管理的类中才可以使用；需要将这个对象放入spring容器中
    @Autowired
    UserService userService;


    @Test
    public void test1(){
        userService.addUser(new User("admin123", "admin", null));
    }

    @Test
    public void test2(){
        User user = userService.getUserById(1);
        System.out.println(user);
    }
}
