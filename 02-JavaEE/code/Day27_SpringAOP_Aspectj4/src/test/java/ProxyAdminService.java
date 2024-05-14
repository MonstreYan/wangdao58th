/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 10:26
 * @Version 1.0
 */
public class ProxyAdminService implements AdminService{

    AdminService adminService;

    public ProxyAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public Integer login() {
        //现在写的代码，就相当于环绕通知的代码
        //这行代码就相当于joinPoint.proceed()
        Integer login = adminService.login();
        return login;
    }
}
