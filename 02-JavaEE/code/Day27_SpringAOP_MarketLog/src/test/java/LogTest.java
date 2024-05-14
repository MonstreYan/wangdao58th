import com.cskaoyan.th58.config.SpringConfig;
import com.cskaoyan.th58.domain.MarketAdmin;
import com.cskaoyan.th58.service.MarketAdminService;
import com.cskaoyan.th58.service.OrderService;
import com.cskaoyan.th58.service.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 11:28
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class LogTest {

    @Autowired
    MarketAdminService adminService;

    @Autowired
    OrderService orderService;


    @Test
    public void test1(){
        MarketAdmin login = adminService.login("admin123", "admin123");
    }

    @Test
    public void test2(){
       orderService.ship();


       orderService.delete();
    }
}
