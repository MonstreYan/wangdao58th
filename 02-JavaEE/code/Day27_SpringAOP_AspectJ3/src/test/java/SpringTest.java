import com.cskaoyan.th58.config.SpringConfig;
import com.cskaoyan.th58.service.GoodsService;
import com.cskaoyan.th58.service.UserService;
import com.cskaoyan.th58.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 10:09
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @Autowired
    GoodsService goodsService;

    @Autowired
    UserService userService;


    @Test
    public void test(){
        goodsService.addOne();

        goodsService.selectOne();
        System.out.println("=================================");

        userService.addOne();

        userService.selectOne();
    }
}
