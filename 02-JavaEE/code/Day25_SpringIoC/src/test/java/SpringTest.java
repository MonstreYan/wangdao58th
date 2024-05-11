import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/11 10:29
 * @Version 1.0
 */
public class SpringTest {

    @Test
    public void test1(){
        //1.使用Spring容器去管理对象，前提是需要有一个Spring容器
        //Spring容器在spring框架中是由ApplicationContext来充当的.ApplicationContext是一个接口，具体的子类实现我们此处选择的是读取xml来实例化容器
        //输入一个位于classpath目录下xml文件的信息
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        //Spring会帮助我们去创建对应的实例对象，并且放入到spring容器中

        //只需要利用容器的方法来获取位于容器中的组件对象即可
        //key值是什么呢？就是刚刚注册的时候设置的编号，编号要求唯一
        UserService userService = (UserService) context.getBean("userService");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper1");
        System.out.println(userService);
        System.out.println(userMapper);
    }


    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        //思考：类型究竟是什么类型？？？？是UserFactoryBean类型还是User类型？？？？？？User类型
        Object userfb = context.getBean("userfb");
        System.out.println(userfb);
    }
}
