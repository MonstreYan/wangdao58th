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

正是因为有上述的原因，我们希望可以在程序运行期间动态地去产生代理类对象，也就是希望可以进行动态代理。



## 动态代理

顾名思义，便是在程序运行期间动态地产生代理类对象。

理论基础：

编写的java代码，首先需要进行编译，形成class文件字节码文件(本质上来说，该文件就是二进制文件)。那么该会被加载到内存中，然后读取里面的数据。

那么，现在如果有一种技术，可以直接在内存中生成对应的字节码文件，可不可以起到相同的效果？这个不要去深究，如果想研究，那么工作三年以后可以去研究一下ASM字节码框架。

动态代理分为两种实现方式，一种是jdk动态代理；一种是cglib动态代理。

### JDK动态代理(重点关注)

指的是无需借助于第三方的框架、类库，jdk中提供的动态代理解决方案技术。

使用jdk动态代理的前提条件：委托类对象必须要实现接口。

> 思考：jdk动态代理是如何产生代理类对象的？
>
> 1.先拿到委托类对象实现的接口
>
> 2.程序运行期间动态地生成代理类对象，实现这些接口
>
> 3.在代理类对象的代码中进一步去调用委托类代码

> 反射是什么东西？
>
> java代码首先需要进行编译，形成class文件；class文件被类加载器加载到内存中之后，会创建一个Class对象，该对象里面会包含了当前class文件里面的全部语法信息。比如构造函数、成员变量、方法等等
>
> 反射便是java语言给我们提供了另外一种操作代码的机制，利用反射其实本质上来说，便是利用Class对象来获取类的信息，比如获取构造函数，再利用反射提供的机制，去调用构造函数，那么便可以实例化对象，或者说给属性赋值、调用方法等等。
>
> 







接口：

```java
public interface UserService {

    int addUser();

    int updateUser();

    int deleteUser();
}
```

委托类对象：

```java
//委托类
public class UserServiceImpl implements UserService{
    @Override
    public int addUser() {
        System.out.println("add user");
        return 0;
    }

    @Override
    public int updateUser() {
        System.out.println("update user");
        return 0;
    }

    @Override
    public int deleteUser() {
        System.out.println("delete user");
        return 0;
    }
}
```

生成代理类对象：

```java
public class DynamicProxy {

    public static void main(String[] args) {
        //提供三个参数：1.加载委托类对象的类加载器  2.委托类对象实现的接口  3.要求提供一个InvocationHandler:代理策略，究竟应该如何去行使代理功能
        //委托类
        UserService userService = new UserServiceImpl();
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            //当前invoke方法其实就是指的是代理类对象如何去发挥代理功能的逻辑
            //需要做的事情便是进一步去调用委托类的代码
            //这个invoke方法 代理类对象会调用；代理类对象需要在内部进一步去调用委托类对象才可以

            //第一个参数：proxy表示的是代理类对象
            //第二个参数：method表示的是代理类对象中正在执行的方法的名称
            //第三个参数：args表示的是method执行的时候需要传递的参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println(method.getName() + " invoke before");
                //进一步去调用委托类的代码.方法的返回结果便是指的是当前方法的返回值
                Object invoke = method.invoke(userService, args);
                System.out.println(method.getName() + " invoke after");
                return invoke;
            }
        });


        proxyInstance.addUser();

        proxyInstance.updateUser();

        proxyInstance.deleteUser();

    }
}
```



接下来，我们通过反编译，查看一下代理类的源码。

```java
public final class $Proxy0
extends Proxy
implements UserService {
    private static final Method m0;
    private static final Method m1;
    private static final Method m2;
    private static final Method m3;
    private static final Method m4;
    private static final Method m5;

    static {
        try {
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m3 = Class.forName("com.cskaoyan.th58.proxy.UserService").getMethod("addUser", new Class[0]);
            m4 = Class.forName("com.cskaoyan.th58.proxy.UserService").getMethod("updateUser", new Class[0]);
            m5 = Class.forName("com.cskaoyan.th58.proxy.UserService").getMethod("deleteUser", new Class[0]);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new NoSuchMethodError(noSuchMethodException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    public final int addUser() {
        try {
            return (Integer)this.h.invoke(this, m3, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int updateUser() {
        try {
            return (Integer)this.h.invoke(this, m4, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int deleteUser() {
        try {
            return (Integer)this.h.invoke(this, m5, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public $Proxy0(InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    

    public final boolean equals(Object object) {
        try {
            return (Boolean)this.h.invoke(this, m1, new Object[]{object});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final String toString() {
        try {
            return (String)this.h.invoke(this, m2, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int hashCode() {
        try {
            return (Integer)this.h.invoke(this, m0, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    private static MethodHandles.Lookup proxyClassLookup(MethodHandles.Lookup lookup) throws IllegalAccessException {
        if (lookup.lookupClass() == Proxy.class && lookup.hasFullPrivilegeAccess()) {
            return MethodHandles.lookup();
        }
        throw new IllegalAccessException(lookup.toString());
    }
}
```





### Cglib动态代理

如果某些类没有实现接口，是否意味着就无法进行代理增强了呢？此时可以选择另外一种方式，叫做cglib动态代理。

cglib动态代理：通过继承自委托类的方式来进行增强。要求委托类对象不可以是final修饰。

> 需要特别注意的是：cglib的jar包已经很久没有维护了，如果希望使用cglib，需要切换一下jdk版本，改为jdk8.

```java
public class CglibProxyDemo {

    public static void main(String[] args) {
        //增强器，便是cglib中用来去创建代理类对象的
        Enhancer enhancer = new Enhancer();

        //为什么需要设置super class呢？cglib使用的是继承自委托类的方式来实现的
        UserComponent userComponent = new UserComponent();


        enhancer.setSuperclass(userComponent.getClass());

        //非常类似于invocationHandler的功能
        enhancer.setCallback(new MethodInterceptor() {

            //该方法便是代理类对方法调用时，会调用该方法
            //第一个参数：obj指的是代理类对象
            //第二个参数：method指的是当前代理类对象中正在执行的方法
            //第三个参数：args指的是代理类对象的方法运行时，传递的参数
            //第四个参数：一般是指的是代理类的方法
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

//                method.invoke(userComponent, args)
                //进一步去调用委托类的方法
                //这行代码的作用是通过调用代理类对象的方法，代理类对象的方法会进一步调用super也就是父类的同名方法
                System.out.println("before");
                //此处是直接调用了代理类的方法，因为代理的方法内部会进一步去调用super，也就是调用了委托类的同名方法
                Object o = proxy.invokeSuper(obj, args);
                System.out.println("after");
                return o;
            }
        });

        UserComponent proxy = (UserComponent) enhancer.create();
        proxy.function();
    }
}
```





