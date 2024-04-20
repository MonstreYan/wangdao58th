import com.cskaoyan.th58.Student;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testAge(){
        Student student = new Student();
        Assert.assertEquals(18, student.age());
    }
}
