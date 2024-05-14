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
 * @Date 2024/5/14 15:16
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SMTest {

    @Autowired
    UserService userService;

    @Test
    public void test1(){
        userService.addUser(new User(null, "kongling", "admin123"));
    }

    @Test
    public void test2(){
        User user = userService.getUserById(1);
        System.out.println(user);
    }
}
