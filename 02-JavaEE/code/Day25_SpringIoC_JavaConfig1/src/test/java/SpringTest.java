import com.cskaoyan.th58.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/11 11:33
 * @Version 1.0
 */
public class SpringTest {

    @Test
    public void test1(){
        //之前使用xml文件时，读取xml文件，读取bean的元数据信息，比如id编号，比如全限定类名等信息
        //现在，基于配置类的形式，能否得到这些信息呢？找到包含@Bean注解的方法，能否得到id编号(方法的名称),全限定类名(可以)
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //依然是利用编号来从容器中获取对象  @Bean注解方法的名称便是注册到spring容器中该对象的编号
        Object userService = context.getBean("userService");
        Object userMapper = context.getBean("userMapper");
        Object orderService = context.getBean("orderService");
        System.out.println(userService);
        System.out.println(userMapper);
        System.out.println(orderService);
    }
}
