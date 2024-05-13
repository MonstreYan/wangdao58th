import com.cskaoyan.th58.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 10:13
 * @Version 1.0
 */
public class SpringTest {

    @Test
    public void test() {
        //首先进行容器的实例化
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object userServiceImpl = context.getBean("userServiceImpl");
        Object orderServiceImpl = context.getBean("orderServiceImpl");
        Object userMapperImpl = context.getBean("userMapperImpl");
        Object userMapperImpl2 = context.getBean("userMapperImpl2");
        System.out.println(userServiceImpl);
        System.out.println(orderServiceImpl);
        System.out.println(userMapperImpl);
        System.out.println(userMapperImpl2);
    }
}
