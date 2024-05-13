import com.cskaoyan.th58.config.SpringConfig;
import com.cskaoyan.th58.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 17:13
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AOPTest {

    @Autowired
    @Qualifier("goodsServiceProxy")
    GoodsService goodsService;

    @Test
    public void test1(){
        goodsService.addOne();

        System.out.println("==============");

        //但是不希望对select进行增强
        goodsService.selectOne();
    }
}
