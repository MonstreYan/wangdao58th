import com.cskaoyan.th58.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentTest {

    @Test
    public void test1() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        //Class-------对于.class文件的封装
        //Student------对于学生信息的封装
        Class<Student> studentClass = Student.class;
        Student student = new Student();
        Student student2 = new Student();

        Class<? extends Student> aClass = student.getClass();
        Class<? extends Student> aClass1 = student2.getClass();


        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if(constructor.getParameterCount() == 0){
                Object o = constructor.newInstance();
                System.out.println(o);
            }

        }
        Field[] declaredFields = studentClass.getDeclaredFields();
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        System.out.println("====================");
    }
}
