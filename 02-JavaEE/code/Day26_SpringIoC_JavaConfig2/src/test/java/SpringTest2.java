import com.cskaoyan.th58.config.SpringConfig;
import com.cskaoyan.th58.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 10:13
 * @Version 1.0
 */
//spring整合junit的环境所必须要处理的步骤
    //实例化容器
@RunWith(SpringJUnit4ClassRunner.class)
//用来进行读取配置类或者读取xml配置文件的，用于实例化容器
//@ContextConfiguration(classes = {SpringConfig.class})
//但是上述写法可以进一步优化，如果数组里面只有一个值，可以不用写大括号
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest2 {

    //如果希望在某个类中可以直接通过autowired来获取容器中的对象，那么当前类对象也必须要交给spring来进行管理
    @Autowired
    UserService userService;


    @Test
    public void test1(){
        System.out.println(userService);
    }
}
