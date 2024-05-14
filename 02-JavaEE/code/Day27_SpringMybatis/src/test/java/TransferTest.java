import com.cskaoyan.th58.config.SpringConfig;
import com.cskaoyan.th58.service.TransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 15:26
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TransferTest {

    //直接从spring容器中取出service
    @Autowired
    TransferService transferService;


    @Test
    public void test(){
        transferService.transfer("boss","zhangsan", 10000.0);
    }
}
