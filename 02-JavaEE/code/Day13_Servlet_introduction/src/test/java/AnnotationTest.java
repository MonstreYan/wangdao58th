import org.junit.Test;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnnotationTest {

    //@Test
    public void test(){
        //如果我们需要解析注解，那么需要使用反射，而反射需要借助于Class对象
        Map<String ,String > map = new HashMap<String ,String >();
        try {
            String className = "com.cskaoyan.th58.Servlet3";
            Class<?> aClass = Class.forName(className);
            //查看当前类的头上有没有标注该注解
            WebServlet webServlet = aClass.getAnnotation(WebServlet.class);
            String[] urls = webServlet.urlPatterns();
            String[] value = webServlet.value();
            System.out.println(Arrays.toString(urls));
            System.out.println(Arrays.toString(value));
            map.put(value[0], className);
            System.out.println("==============");

            Constructor<?> constructor = aClass.getConstructor();
            //创建了一个servlet实例对象
            Object o = constructor.newInstance();
            Method method = aClass.getMethod("service", ServletRequest.class, ServletResponse.class);
            // tomcat：通过反射去调用servlet的service方法
            Object invoke = method.invoke(o, null, null);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
