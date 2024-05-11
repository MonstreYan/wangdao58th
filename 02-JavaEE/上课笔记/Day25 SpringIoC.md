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



但是在上述案例中，其实对象和对象之间没有产生关联。



