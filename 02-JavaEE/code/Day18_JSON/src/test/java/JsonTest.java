import com.cskaoyan.th58.bean.Student1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 10:08
 * @Version 1.0
 */
public class JsonTest {

    @Test
    public void test1(){
        Student1 student1 = new Student1();
        student1.setPassword("admin123");
        student1.setUsername("admin");

        //把student对象转换成json字符串
        //使用一些json校验网站校验json格式是否合理
        String jsonStr = "{\"username\":\"" + student1.getUsername() + "\",\"password\":\"" + student1.getPassword() + "\"}";
        System.out.println(jsonStr);
    }

    //自己进行json字符串和java对象的想换转换工作，其实非常的麻烦，可以使用一些专业化的工具来实现
    //常用的json解析类库：gson（google的json解析工具）、jackson（spring框架默认的json解析工具）、fastjson（alibaba的json解析工具）
    //将使用jackson来进行json字符串和java对象之间的相互转换工作

    @Test
    public void test2() throws JsonProcessingException {
        Student1 student1 = new Student1();
        student1.setPassword("admin123");
        student1.setUsername("admin");

        ObjectMapper objectMapper = new ObjectMapper();
        //可以把一个java对象转换成json字符串
        String s = objectMapper.writeValueAsString(student1);
        System.out.println(s);
    }

    @Test
    public void test3() throws JsonProcessingException {
        Student1 student1 = new Student1();
        student1.setPassword("admin123");
        student1.setUsername("admin");

        Student1 student2 = new Student1();
        student2.setPassword("admin12213");
        student2.setUsername("jjjjjj");


        //如果是List<Student>类型呢？
        List<Student1> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);

        ObjectMapper objectMapper = new ObjectMapper();
        //可以把一个java对象转换成json字符串
        // [{"username":"admin","password":"admin123"},{"username":"jjjjjj","password":"admin12213"}]
        String s = objectMapper.writeValueAsString(list);
        System.out.println(s);
    }

    //反方向：json字符串转换成java对象
    @Test
    public void test4() throws JsonProcessingException {
        String jsonStr = "{\"username\":\"admin\",\"password\":\"admin123\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        Student1 student1 = objectMapper.readValue(jsonStr, Student1.class);
        System.out.println(student1);
    }

    @Test
    public void test5() throws JsonProcessingException {
        String jsonStr = "[{\"username\":\"admin\",\"password\":\"admin123\"},{\"username\":\"jjjjjj\",\"password\":\"admin12213\"}]";
        ObjectMapper objectMapper = new ObjectMapper();
//        List list = objectMapper.readValue(jsonStr, List.class);
        //构建一个复杂的类型
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        //里面需要传递两个参数：构造一个集合的类型，集合用什么来充当，集合内部的元素是什么元素，也就是泛型的部分
        CollectionType collectionType = typeFactory.constructCollectionType(List.class, Student1.class);
        List<Student1> student1List = objectMapper.readValue(jsonStr, collectionType);
        for (Student1 student1 : student1List) {
            System.out.println(student1);
        }
    }
}
