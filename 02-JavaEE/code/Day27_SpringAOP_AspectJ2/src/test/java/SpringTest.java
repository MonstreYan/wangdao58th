import com.cskaoyan.th58.config.SpringConfig;
import com.cskaoyan.th58.service.GoodsService;
import com.cskaoyan.th58.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 9:51
 * @Version 1.0
 */
//spring整合junit所必须要提供的上下文的配置环境信息
@RunWith(SpringJUnit4ClassRunner.class)
//需要去读取元数据信息，创建一个容器实例对象
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @Autowired
    GoodsService goodsService;

    @Autowired
    UserService userService;

    @Test
    public void test(){
        goodsService.addOne();

        System.out.println("=================");
        goodsService.selectOne();
    }

    @Test
    public void test2(){
        userService.addOne();

        System.out.println("=================");
        userService.selectOne();
    }
}
