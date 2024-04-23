import com.cskaoyan.th58.bean.Salary;
import com.cskaoyan.th58.mapper.SalaryMapper;
import com.cskaoyan.th58.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CRUDTest {

    @Test
    public void testQuery(){
        //获取操作数据库的一个连接
        SqlSession session = MybatisUtils.getSession();
        //程序运行期间动态地产生一个mapper实例对象，该对象内部封装了对应的sql语句，我们可以直接使用对象的方法来进行操作
        SalaryMapper salaryMapper = session.getMapper(SalaryMapper.class);
        Salary salary = salaryMapper.selectOne(2);
        System.out.println(salary);
        session.commit();
        session.close();
    }


    @Test
    public void testQuery2(){
        //获取操作数据库的一个连接
        SqlSession session = MybatisUtils.getSession();
        //程序运行期间动态地产生一个mapper实例对象，该对象内部封装了对应的sql语句，我们可以直接使用对象的方法来进行操作
        SalaryMapper salaryMapper = session.getMapper(SalaryMapper.class);
        List<Salary> salaries = salaryMapper.selectAll();
        for (Salary salary : salaries) {
            System.out.println(salary);
        }
        session.commit();
        session.close();
    }


    @Test
    public void testInsert(){
        SqlSession session = MybatisUtils.getSession();
        SalaryMapper salaryMapper = session.getMapper(SalaryMapper.class);
        Salary salary = new Salary();
        salary.setName("空灵");
        salary.setSalary(12000.0);
        Integer rows = salaryMapper.insertOne(salary);
        Assert.assertEquals(1,rows.longValue());
        //增删改一定得记得提交
        session.commit();
        //无论查询还是增删改都必须得close
        session.close();
    }

    @Test
    public void testUpdate(){
        SqlSession session = MybatisUtils.getSession();
        SalaryMapper salaryMapper = session.getMapper(SalaryMapper.class);
        Salary salary = new Salary();
        salary.setId(7);
        salary.setName("kongling");
        salary.setSalary(15000.0);
        Integer rows = salaryMapper.updateByPrimaryKey(salary);
        Assert.assertEquals(1, rows.longValue());
        session.commit();
        session.close();
    }

    @Test
    public void testDelete(){
        SqlSession session = MybatisUtils.getSession();
        SalaryMapper salaryMapper = session.getMapper(SalaryMapper.class);
        Integer rows = salaryMapper.deleteByPrimaryKey(2);
        Assert.assertEquals(1, rows.longValue());
        session.commit();
        session.close();
    }
}
