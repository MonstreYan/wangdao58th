import com.cskaoyan.th58.bean.Student;
import org.junit.Test;

public class StudentTest {

    @Test
    public void test() {
        Student student = new Student();
        student.setId(1);
        student.setName("zhagnsan");
        System.out.println(student);
    }
}
