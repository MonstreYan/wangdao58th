import com.cskaoyan.th58.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Method;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 9:45
 * @Version 1.0
 */
public class AnnotationTest {


    @Test
    public void test() {
        Class<SpringConfig> springConfigClass = SpringConfig.class;
        Method[] methods = springConfigClass.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Bean.class)){
                System.out.println(method.getName());
//                Object bean = method.invoke();
//                map.put(method.getName(), bean);
            }
        }
    }
}
