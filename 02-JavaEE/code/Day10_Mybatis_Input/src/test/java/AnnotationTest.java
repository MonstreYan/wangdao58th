import com.cskaoyan.th58.annotation.Log;
import org.junit.Test;

public class AnnotationTest {

    @Test
    public void test1(){
        //如果我们希望对注解进行处理，那么需要借助于反射
        try {
            Class<?> aClass = Class.forName("com.cskaoyan.th58.annotation.AdminLogin");
            Log log = aClass.getAnnotation(Log.class);
            System.out.println(log.name());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
