import com.cskaoyan.th58.rent.HouseOwner;
import com.cskaoyan.th58.rent.HouseProxy;
import com.cskaoyan.th58.rent.HouseRent;
import com.cskaoyan.th58.update.UserService;
import com.cskaoyan.th58.update.UserServiceImpl;
import com.cskaoyan.th58.update.UserServiceStaticProxy;
import org.junit.Test;

public class ProxyTest {


    @Test
    public void test1(){
        //没有增强  没有打印时间
        UserService userService = new UserServiceImpl();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();


        System.out.println("=============================");

//        UserService userServiceProxy = new UserServiceStaticProxy((UserServiceImpl) userService);
        UserService userServiceProxy = new UserServiceStaticProxy(userService);
        userServiceProxy.addUser();
        userServiceProxy.updateUser();
        userServiceProxy.deleteUser();
    }


    @Test
    public void test2(){
        HouseRent houseRent = new HouseOwner();
        houseRent.rent();


        houseRent = new HouseProxy(houseRent);
        houseRent.rent();
    }
}
