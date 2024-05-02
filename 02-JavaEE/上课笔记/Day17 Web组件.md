# Day17 Web组件

指的是java ee规范体系中一共制定了三个标准组件用于去进行web开发工作，分别是Listener、Filter、Servlet。

Servlet：主要作用是用于去开发动态web资源。

Listener：一共有三大类，8种，但是使用最多的其实只有ServletContextListener，主要负责去监听SerlvetContext对象的创建和销毁工作，主要用于项目启动时、项目卸载时的一些配置工作。

Filter：过滤器、拦截器。主要做的事情是用于权限的控制。比如哪些人能够访问哪些页面等。



## Listener

监听器，比如监听ServletContext对象的创建和销毁。

ServletContext对象被创建的时候是在什么时候？应用启动的时候

ServletContext对象被销毁的时候是在什么时候？应用卸载的时候

所以，我们编写一个Listener，可以监听应用启动时、应用卸载时状态。如果我们有这样的一个需求，我们需要再应用启动、应用销毁时做一些事情，那么便可以把代码逻辑写在该listener中。

Listener所做的事情和Serlvet的init方法所做的事情的确有一些相似之处。为什么还需要listener呢？

比如购物车案例中，进行了商品的初始化工作，我们的代码逻辑写在IndexServlet中的，可能部分同学会有疑问，为什么不能够写在ItemServlet中呢？也是可以写在ItemSerlvet中的，在维护的时候其实并不会特别容易维护。所以，**listener的出现其实就是希望开发者可以将全局性的代码逻辑写在listener中**。比如读取配置文件，进行全局配置等工作。

Servlet的init方法专门用来去写和当前servlet的功能具有强相关性的代码。

比如有一个用户模块，编写了一个UserServlet,希望能够去进行用户信息的统计等处理，那么可以写在Serlvet的init方法中。



### 使用

1.编写一个类实现ServletContextListener接口

2.向容器中去注册该Listener(一种是web.xml或者注解)

```java
@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //应用启动时，会调用当前方法
        //如果希望在项目启动时读取配置文件，那么便可以将代码写在当前方法中
        System.out.println("context init");
        ServletContext servletContext = sce.getServletContext();
        // context域   获取绝对路径
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //应用卸载时，会调用该方法
    }
}
```



### 原理(了解)

涉及到多态。

在ServletContext对象的内部其实是持有ServletContextListener接口的引用，在ServletContext对象创建和销毁的时候，会分别调用接口的contextInitialized以及contextDestroyed方法。

```
public class ServletContext{

//ServletContext对象的内部持有一个接口的引用
List<ServletContextListener> listeners;

//该方法可以理解为tomcat会调用，解析到一个listener之后，会将listener添加到list中
void addListener(ServletContextListener listner){
	listeners.add(listener);
}

//servletContext对象的创建和销毁
 void init(){
     listeners.for{
     	listener.contextInitialized();
     }
 }
 
 void destroy(){
 listeners.for{
     	listener.contextDestroyed();
     }
 }


}
```







## Filter

过滤器，也叫做拦截器。主要作用是负责去拦截客户端的请求或者对服务器产生的响应进行校验，设置等。

比如：设定订单页面、个人中心页面没有登录的情况下不允许访问；屏蔽一些脏话；



### 原理图(熟悉)

Filter的功能定位位于客户端和Servlet等资源之间的。对于与过滤器关联的Servlet来说，Filter可以在请求到达Servlet之前检查修改request对象，也可以在响应到达客户端之前检查修改response对象。

相当于城门的作用。

![image-20240502150656199](assets/image-20240502150656199.png)

### 使用(掌握)

1.编写类实现Filter接口

2.向容器中去注册当前配置的Filter

```java
/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 15:08
 * 类比Servlet来进行学习：需要关注的是哪些和servlet时一致的；哪些和servlet时不同的
 * @Version 1.0
 */
@WebFilter("/f1")
public class Filter1 implements Filter {

    //应用启动的时候便会调用init方法；当前filter被创建的时候会调用init；说明了filter在运行期间也只有一个实例对象
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
    }

    //该方法类似于servlet的service方法
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter doFilter");
    }

    //应用卸载的时候会调用destroy方法
    @Override
    public void destroy() {
        System.out.println("filter destroy");
    }
}
```





### 思考题(熟悉)

1.filter如何和Serlvet产生关联？最简单的方式便是通过url-pattern产生关联。也就是将servlet的url-pattern赋值给filter即可。filter和servlet设置相同的url-pattern。

> 正常情况下来说，filter和servlet产生关联之后，默认情况下，filter执行的是拦截功能；如果希望filter执行的是放行功能，需要设置一行代码。
>
> ```java
> @Override
>     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
>         System.out.println("filter doFilter");
> 
>         //具有这行代码，那么便是放行；如果没有这行代码，那么便是拦截
>         chain.doFilter(request, response);
>     }
> ```
>
> 





2.filter可以设置和Serlvet相同的url-pattern，那么filter可以(推荐)设置/*吗？可以，并且非常推荐。因为设置了

/*之后，便可以实现filter和servlet之间一对多的关系。那么后续在设定哪些人能够访问哪些页面时就会非常的方便，或者说设置编码格式也会非常的轻松。





3.多个filter之间可不可以设置相同的url-pattern呢？可以的。





4.多个filter执行先后顺序满足什么样的顺序呢？

如果是注解进行配置，那么按照全限定类名首字母的ASCII先后顺序

如果是web.xml配置，那么满足filter-mapping声明的先后顺序进行配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <filter>
        <filter-name>f1</filter-name>
        <filter-class>com.cskaoyan.th58.Filter1</filter-class>
    </filter>

    <filter>
        <filter-name>f2</filter-name>
        <filter-class>com.cskaoyan.th58.Filter2</filter-class>
    </filter>

   <filter-mapping>
       <filter-name>f2</filter-name>
       <url-pattern>/*</url-pattern>
   </filter-mapping>

    <filter-mapping>
        <filter-name>f1</filter-name>
        <url-pattern>/s1</url-pattern>
    </filter-mapping>
</web-app>
```



5.根据Filter执行图示，请求和响应应该两次经过filter，那么为什么打印的日志只有一行？

其实是以chain.doFilter(request, response);位分界线，去往servlet只会执行上半部分代码；从serlvet执行完之后到返回给客户端执行的是下半部分的代码。

背后的原理其实就是这些需要执行的组件形成一个链表，通过这行代码递归调用链上的下一个组件。



![image-20240502155839787](assets/image-20240502155839787.png)



### 使用场景(掌握)

1.设置编码格式



2.进行权限控制：即哪些人可以访问哪些页面

```java
@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //因为我们设置的是/*，所以无论访问哪个页面，哪个servlet，均会经过当前filter
        //但是目前来说，只有/user/info才需要进行处理，其他是不需要处理的
        //需要知道当前访问的是哪个资源
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/user/info")){
            //如果访问的是info页面，要求是什么？必须登录过后才可以访问
            //如何判断用户是否登录呢？
            HttpSession session = request.getSession();
            Object attribute = session.getAttribute("username");
            if(attribute == null){
                //没有登录
                response.sendRedirect(request.getContextPath() + "/login.html");
                return;
            }
        }

        //直接放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
```

上述案例中，关于访问的地址，是进行硬编码的；如果今后订单等其他页面也需要判断是否登录，那么又需要重新设置。所以我们可以设置一个黑名单，位于黑名单里面的请求地址，必须登录过后才可以访问。

```java
/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 16:13
 * @Version 1.0
 * 关于当前filter的url-pattern的写法有两种:
 * 1.直接去写/user/info：表示的是只去处理这个页面；后续的业务逻辑非常简单；只需要判断是否登录即可；如果今后还有订单页面也需要处理，那么又需要进一步去修改url-pattern
 * 2.写/*，后续的业务逻辑比较复杂，需要识别出是哪个请求、识别出访问的是否是info页面，然后才进行处理
 */
@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //因为我们设置的是/*，所以无论访问哪个页面，哪个servlet，均会经过当前filter
        //但是目前来说，只有/user/info才需要进行处理，其他是不需要处理的
        //需要知道当前访问的是哪个资源
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String requestURI = request.getRequestURI();

        //获取servletContext对象 该对象时一个非常重要的对象，request中持有该对象的引用
        ServletContext servletContext = request.getServletContext();
        List<String> uris = (List<String>) servletContext.getAttribute("uris");
        //关于这部分如何处理？1.uris遍历，遍历出的每一个地址和当前访问的请求资源地址进行比对，如果包含，则表示需要登录之后才可以访问
        //2.直接利用uris.contains方法； 将requestURI中的应用名部分去掉  /app/user/info
        //将requestURI中应用名的部分去掉
        requestURI = requestURI.replace(request.getContextPath(), "");
        System.out.println(requestURI);
        //将应用名去掉之后，便可以使用contains方法来进行处理了
        if(uris.contains(requestURI)){
        //if(requestURI.contains("/user/info")){
            //如果访问的是info页面，要求是什么？必须登录过后才可以访问
            //如何判断用户是否登录呢？
            HttpSession session = request.getSession();
            Object attribute = session.getAttribute("username");
            if(attribute == null){
                //没有登录
                response.sendRedirect(request.getContextPath() + "/login.html");
                return;
            }
        }

        //直接放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
```





## 完整请求处理流程(熟悉)

整个课程学完之后，写完简历，能够掌握即可。

http://localhost:8080/app/servlet1为例

1.域名解析

2.建立TCP连接

3.客户端发送HTTP请求

4.HTTP请求报文到达服务器，被监听8080端口号的Connector接收到；将请求报文解析成为Request对象，与此同时还会提供一个空的response对象

5.Connector会将这两个对象传递给Engine，Engine进一步传递给Host，Host去挑选一个Context(/app)

6.Context接收到这两个对象之后，此时需要进行处理的有效路径部分为/serlvet1，首先去查找在当前项目中有没有编写对应的filter可以处理该请求，如果有，则加入到请求处理的链表中；如果有多个，则按照先后顺序组织好；随后再查看有没有配置对应的Servlet可以处理该请求，如果有，则将对应的Serlvet加入到链表的末尾；如果没有，则将缺省Servlet加入到链表的末尾

7.Context会按照链表的顺序依次去调用链上的每一个组件，如果是filter，则调用其doFilter()方法；如果是serlvet，则调用其service()方法，调用方法时，需要传递两个参数，刚好把request、response作为 参数传递进去

8.最终Connector读取response里面的数据，生成HTTP响应报文

![image-20240502164635120](assets/image-20240502164635120.png)































