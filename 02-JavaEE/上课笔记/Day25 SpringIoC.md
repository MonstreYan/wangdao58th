# Day25 SpringIoC

## 介绍

Spring的核心特性之一便是IoC或者说是DI，翻译成中文便是控制反转(依赖注入).这是同一个功能的两种不同角度的称呼。

控制反转：何为控制，何为反转？？？控制其实就是指的是对于某个对象的创建控制权，也就是说对象是由开发人员自主去创建的。反转指的什么意思呢？指的是这个权利由由开发人员转交给Spring框架。通俗的来说，就是将对象的创建过程交给Spring去创建。

依赖注入：使用这个对象时，我们只需要从Spring中获取即可。比如说之前项目一种，我们编写的Controller中持有一个Service的引用。

```java
public class GoodsController extends HttpServlet{
    
    private GoodsService goodsService = new GooodsServiceImpl();
}
```

首先，这里面是开发人员自己去创建一个GoodsService实现类对象，如果在其他功能模块中，我也需要使用当前的Service，怎么办？只能够再创建一个。但是，思考一个问题：必须得再创建吗？用同一个不行吗？可以的，但是在项目一中不太好实现。

再次，上述的代码也就是Controller层其实是和Service层之间是有耦合的。耦合的代码便是接口指向子类实现。如果今后Service实现类变更，那么controller也需要同步发生修改。那么能不能做到service实现类变更的同时，controller不需要做任何的改动呢？可以的。今后借助于Spring，可以实现如下的效果。

```java
public class GoodsController extends HttpServlet{
    
    private GoodsService goodsService;
}
```



> 这一点其实和tomcat服务器中的Servlet有些类似，但是比Servlet要高级的多，为什么呢？因为tomcat中的Servlet其实并不是完全只能够由tomcat来创建，我们依然可以自主去创建Serlvet对象。并且tomcat也并没有对于Servlet对象做进一步的处理。

Spring的核心特性之二便是AOP，AOP需要借助于Spring的IoC的功能。简单解释便是面向切面编程。其实就是我们之前的写的代理的进一步优化简化。后续，学完了Spring之后，我们希望保障事务，只需要添加一个注解即可。



关于IoC或者DI，其实底层原理便是Spring内部有一个容器(map)，Spring帮助开发人员去创建好实例对象(IoC)，并且把这些对象放入到Spirng容器中。后续使用的时候，直接从容器中取出来即可(DI).



## 入门案例

关于入门案例，我们使用xml来介绍，但是只是一个过渡，后续我们基本不会再去使用xml形式。目前主要流行的方式是java代码去配置。注解、java配置类的形式。

> 我们今天需要解决的事情就是把对象的创建工作交给Spring来进行，把创建好的对象放入到Spring容器中。

![image-20240511101914726](assets/image-20240511101914726.png)

1.导包

```xml
<dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.30</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
```



2.在resources目录下新建app.xml文件，编写如下内容：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <!--放入spring容器中的对象称之为bean；id是指的是放入容器中的对象的编号；class是其全限定类名-->
    <bean id="userService" class="com.cskaoyan.th58.service.UserServiceImpl"/>

    <bean id="userMapper" class="com.cskaoyan.th58.mapper.UserMapperImpl"/>
    
</beans>
```





3.编写单元测试用例，编写如下测试代码：

```java
public class SpringTest {

    @Test
    public void test1(){
        //1.使用Spring容器去管理对象，前提是需要有一个Spring容器
        //Spring容器在spring框架中是由ApplicationContext来充当的.ApplicationContext是一个接口，具体的子类实现我们此处选择的是读取xml来实例化容器
        //输入一个位于classpath目录下xml文件的信息
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        //Spring会帮助我们去创建对应的实例对象，并且放入到spring容器中

        //只需要利用容器的方法来获取位于容器中的组件对象即可
        //key值是什么呢？就是刚刚注册的时候设置的编号，编号要求唯一
        UserService userService = (UserService) context.getBean("userService");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        System.out.println(userService);
        System.out.println(userMapper);
    }
}
```



但是在上述案例中，其实对象和对象之间没有产生关联。需要进一步做如下设置：

```java
public class UserServiceImpl implements UserService{

    //希望从Spring容器中奖当前service实现类取出来的时候，mapper是有值的，不是null
    UserMapper userMapper;

    //如果希望spring帮助我们进行注入，那么需要提供一个set方法，暂时需要，后续学完注解之后就不再需要了
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}
```



```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--放入spring容器中的对象称之为bean；id是指的是放入容器中的对象的编号；class是其全限定类名-->
    <bean id="userService" class="com.cskaoyan.th58.service.UserServiceImpl">
        <!--第一个name里面的值指的是成员变量的名称；第二个ref指的是bean的id-->
        <property name="userMapper" ref="userMapper1"/>
    </bean>

    <bean id="userMapper1" class="com.cskaoyan.th58.mapper.UserMapperImpl"/>

</beans>
```



## 实例化Bean

### 构造函数

虽然Spring会借助于反射来创建出Bean对象，其实本质上来说依然是要借助于构造函数，绝大多数的情况下，使用的是无参构造函数。

### 静态工厂以及实例工厂

关于在xml文件中使用构造函数、静态工厂、实例工厂创建bean对象的方式了解即可，知道有这么一回事即可，后续基本不会用到，因为后面基本都会使用基于注解、配置类的方式。



### FactoryBean(掌握)

其中，有一种方式，是基于FactoryBean的方式，需要大家重点关注、重点掌握。

如果某个类实现了FactoryBean接口，那么直接利用其编号取出来的并不是该对象本身，而是getObject()返回值结果。

比如：

利用DBFactoryBean的编号，从容器中获取，其实并不能够获取DBFactoryBean对象，而是获取的是getObject()返回值，也就是db。

```java
public class DBFactoryBean implements FactoryBean{
    
    public Object getObject(){
        return db;
    }
}
```

配置：

```xml
    <bean id="userfb" class="com.cskaoyan.th58.factorBean.UserFactorBean"/>

```

代码：

```java
public class UserFactorBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
```

单元测试：

```java
@Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        //思考：类型究竟是什么类型？？？？是UserFactoryBean类型还是User类型？？？？？？User类型
        Object userfb = context.getBean("userfb");
        System.out.println(userfb);
    }
```

最终，我们利用编号取出来的却是User，而不是UserFactoryBean。

> 使用场景：
>
> 后续mybatis整合Spring需要导入一个jar包，叫做mybatis-spring jar包，里面有一个类叫做SqlSessionFactoryBean。
>
> 



## 组件注册方式

> 把一个大象放入冰箱需要几步？？？打开冰箱、放入大象、关上冰箱。
>
> 把一个对象放入spring容器中需要几步？？？需要创建对象，创建好的对象放入到spring容器中，但是其实在开发过程中，这两步基本是一起的。

### xml文件

也就是入门案例中，我们给大家介绍的这种方式。后续使用的场景不是特别多了，只是入门案例起到一个过渡作用即可。



### 配置类  + @Bean注解方式(掌握)

在前面的课程中，我们提及过ApplicationContext可以通过读取xml文件，也可以通过读取配置类、注解的方式来实例化Spring容器。这种方式是后续开发过程中使用的比较多的使用场景。

操作步骤：

1.新建一个config包，新建一个配置类，标注@Configuration注解，声明其是一个配置类

2.在配置类中去编写一个一个的方法，方法的要求如下：

原理：凡是配置类中标注了@Bean注解的方法，那么Spring会依次去扫描，依次去运行，得到一个实例对象，把该实例对象放入到spring容器中。

> 之前不是说，使用spring之后，不需要自己再去new对象了吗？为什么此处还是自己去new？？？？
>
> 不是说使用spring之后，绝对不会去使用new关键字，而是该对象有没有交给spring去管理维护。

- 编写一个方法，方法的修饰符要求是public
- 方法的返回值类型便是注册到Spring容器中的组件类型，一般建议使用父接口类型来接收
- 方法的名称便是注册到Spring容器中该组件的编号
- **如果需要注入依赖，那么使用@Bean注解的话非常简单：直接在方法的形参中编写你需要从容器中取出来的组件的类型，Spring容器便会自动从容器中取出对应的类型的组件。**

如果不需要维护对象和对象之间的依赖关系，那么下面的写法就ok了

```java
@Configuration
public class SpringConfig {

    //你希望向spring容器中去注册哪个组件，那么便编写哪个对象的创建语句
    @Bean
    public UserService userService(){
        UserServiceImpl userService = new UserServiceImpl();
        //userService.setUserMapper();
        return userService;
    }

    @Bean
    public OrderService orderService(){
        OrderServiceImpl orderService = new OrderServiceImpl();
       // orderService.setUserMapper();
        return orderService;
    }

    @Bean
    public UserMapper userMapper(){
        UserMapper userMapper = new UserMapperImpl();
        return userMapper;
    }
}
```

但是如果需要维护对象和对象之间的关系：

```java
//声明其是一个配置类
@Configuration
public class SpringConfig {

    //你希望向spring容器中去注册哪个组件，那么便编写哪个对象的创建语句
    @Bean
    public UserService userService(UserMapper userMapper){
        UserServiceImpl userService = new UserServiceImpl();
        //service实现类需要提供set方法即可
        userService.setUserMapper(userMapper);
        return userService;
    }

    //Spring处理过程：1.根据方法的返回值类型，得知最终注入到Spring容器中的是OrderService类型的对象
    //2.方法的名称叫做orderService，所以注册到spring容器中的对象的编号为orderService
    //3.方法的形参列表有一个叫做UserMapper，所以spring会扫描容器，从容器中取出一个UserMapper实例对象，在调用当前方法时传递进来
    @Bean
    public OrderService orderService(UserMapper userMapper){
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.setUserMapper(userMapper);
        return orderService;
    }

    @Bean
    public UserMapper userMapper(){
        UserMapper userMapper = new UserMapperImpl();
        return userMapper;
    }
}
```

使用场景：

主要用在整合第三方框架时，把第三方框架里面的类库放入到spring容器中。





![image-20240511114825770](assets/image-20240511114825770.png)





> 关于注解、反射的补充
>
> 注解可以有功能，也可以没有功能，和注释一样的效果。完全取决于开发人员有没有去编写代码去处理这个注解。
>
> 如果编译之后的class文件在运行时，依然存在该注解，那么利用Class对象(Class对象就是用来去记录每个class文件的信息的)是可以获取该注解的信息的。
>
> 如果某个class文件的类头上、方法的头上标注了某个注解，那么都会体现在Class对象里面。
>
> Class对象也可以扫描所有的方法，去查看某个方法上面有没有标注该注解
>
> 