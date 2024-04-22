# Day9 代理

## 概念及静态代理

假设我们的业务代码中，需要新增一个功能，要求：可以记录下来当前业务方法的执行时长。如何来操作？

可以采取如下的方式来进行操作，后面需求已经设计完毕，故障也排查到了。那么日志已经不需要了，此时需要将代码去掉。又需要修改一遍代码。

```java
package com.cskaoyan.th58;
//需要统计以下三个方法的执行时长
//大家思考一下：为什么会需要统计执行时长呢？
//肯定是因为遇到了一些问题，排查究竟哪个步骤出现了问题
//如果比较顺利，排查到了问题，那么接下来，是否意味着就不再需要使用这部分代码了
public class UserService {


    public void addUser(){
        long begin = System.currentTimeMillis();
        System.out.println("add user");
        long end = System.currentTimeMillis();
        System.out.println("add user took " + (end - begin) + "ms");
    }

    public void updateUser(){
        long begin = System.currentTimeMillis();
        System.out.println("update user");
        long end = System.currentTimeMillis();
        System.out.println("update user took " + (end - begin) + "ms");

    }

    public void deleteUser(){
        long begin = System.currentTimeMillis();
        System.out.println("delete user");
        long end = System.currentTimeMillis();
        System.out.println("update user took " + (end - begin) + "ms");

    }
}
```

怎么设计，才能够让业务需求变更的时候，尽量少去修改代码呢？

设计一个接口，编写一个类实现该接口

```java
public interface UserService {
    
    void addUser();
    
    void updateUser();
    
    
    void deleteUser();
}
```

```java
public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("add user");
    }

    @Override
    public void updateUser() {
        System.out.println("update user");

    }

    @Override
    public void deleteUser() {
        System.out.println("delete user");
    }
}
```

还缺少一个统计时间的代码功能：

我们重新编写了一个类实现了接口，在内部进一步去调用了原来的功能类对象。

```java
package com.cskaoyan.th58.update;
//增强的类，统计时间的类功能
public class UserServiceStaticProxy implements UserService{

    //使用接口类型来接收
//    UserServiceImpl userService;
    UserService userService;


    public UserServiceStaticProxy(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void addUser() {
        long begin = System.currentTimeMillis();
        //进一步去调用userServiceImpl.addUser
        userService.addUser();
        long end = System.currentTimeMillis();
        System.out.println("add user took :" + (end - begin) + " ms");
    }

    @Override
    public void updateUser() {
        long begin = System.currentTimeMillis();
        userService.updateUser();
        long end = System.currentTimeMillis();
        System.out.println("update user took :" + (end - begin) + " ms");

    }

    @Override
    public void deleteUser() {
        long begin = System.currentTimeMillis();
        userService.deleteUser();
        long end = System.currentTimeMillis();
        System.out.println("delete user took :" + (end - begin) + " ms");

    }
}
```

便可以实现一步切换。如果接口指向子类实现，是指向的是业务功能类，那么执行的就是没有统计时间的代码逻辑；如果指向的是代理的类对象，那么执行的便是带有统计时间的代码逻辑；如果后期不希望再去使用统计时间功能了，那么也是接口指向子类实现变更一处即可，无需修改业务代码内部的逻辑。

```java
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
```



上述这个案例其实便是代理设计模式。从代码层面去看待，那么是和Connection的包装设计模式是一样的，只是同样的代码在不同的业务场景中，叫法是不同的。

典型的使用场景：房东、中介；房东可以选择房屋直接出租，也可以将服务委托给中介，让中介代为处理。

```java
public interface HouseRent {


    double rent();
}
```

```java
public class HouseOwner implements HouseRent{
    @Override
    public double rent() {
        double v = 2100.0;
        System.out.println(v);
        return v;
    }
}
```



```java
//房屋中介 房东报价的基础上 + 10%手续费
public class HouseProxy implements HouseRent{

//    HouseOwner houseOwner;

    HouseRent houseRent;

    public HouseProxy(HouseRent houseRent) {
        this.houseRent = houseRent;
    }

    //中介的报价就是在原有基础上增加10%
    @Override
    public double rent() {

        double v = 1.1 * houseRent.rent();
        System.out.println(v);
        return v;
    }
}
```

上述便是我们介绍的静态代理设计模式。什么叫做静态代理呢？

静态代理其实是相对于动态代理相对而言的。

静态代理：是指的是我们在业务开发过程中，我们的确需要去编写这样的一个**代理类**对象去代理原来的**委托类**的功能。

动态代理：不需要在开发过程中去编写这样的一个类，而是在程序运行期间动态地去产生代理类对象去执行代理功能。

为什么要有动态代理呢？

在前面的案例中，我们是对userService的功能进行了增强，后续如果我们希望对于orderService、goodsService也进行增强，那么应该怎么办呢？

1.只要有一个业务功能模块需要进行增强，那么我们便要去实现对应的代理类对象的功能。2.如果我们编写了代理类对象，那么当前接口的维护成本是否意味着加倍了？(接口中如果出现了一点修改，那么委托类和代理类的功能都需要进行修改)

真是因为有上述的原因，我们希望可以在程序运行期间动态地去产生代理类对象，也就是希望可以进行动态代理。







