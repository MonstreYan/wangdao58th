import com.cskaoyan.th58.component.LifeCycleBean;
import com.cskaoyan.th58.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 11:48
 * @Version 1.0
 */
//表示的是spring整合junit所必须要做的配置
@RunWith(SpringJUnit4ClassRunner.class)
//实例化容器需要的bean的配置信息
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {


    @Autowired
    LifeCycleBean lifeCycleBean;


    @Test
    public void test1(){
        System.out.println(lifeCycleBean);
    }
}
