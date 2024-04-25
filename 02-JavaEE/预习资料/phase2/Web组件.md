# Web组件

sun公司制定的JavaEE规范中一共制定了三个Web组件。分别是Servlet、Listener、Filter。

servlet：开发动态web资源，对请求做出响应。

listener：监听器，比较常用的是SerlvetContextListener，主要负责去监听ServletContext对象的创建和销毁

filter：过滤器。可以对请求进行拦截或者放行。比如登录注销案例中，登录成功之后可以访问个人主页、注销之后无法访问个人主页。可以用来进行权限控制

## ServletContextListener

JavaEE规范中的Listener一共有8种之多，但是在实际的应用过程中，只有一种的应用场景比较广泛，也就是ServletContextListener。后续学到Spring框架时，该Listener会作为框架初始化的入口。

### 概念

该Listener主要的功能是负责监听ServletContext对象的创建和销毁。监听器的工作流程如下：

被监听对象：ServletContext对象

监听者：自己去编写的监听器

监听事件：该对象的创建和销毁工作

触发事件：调用自己编写的监听器中对应的方法

当我们编写的监听器监听到ServletContext对象的创建和销毁时，会调用编写的监听器中对应的方法。

这一过程和我们日常生活中的经历也非常类似。不信你看：

日常生活中的监听器

被监听对象：明星艺人

监听者：朝阳人民群众

监听事件：吸毒嫖娼

触发事件：报警

### 使用场景

将之前我们写在servlet中的init方法里面的一些全局性的代码逻辑，迁移到listener中。在购物车案例，商品的初始化工作。这部分代码写在listener中更为合适一些。关于商品初始化的代码逻辑我们是写在了IndexServlet的init方法中，但是对其他人来说，可能不会认为写在这里合适，他可能认识写在ItemServlet中更为合适一些。团队维护代码时，不好维护。写在某个servlet中的代码应当是和当前servlet息息相关的，但是初始化代码其实和Index关联并不是特别的大。listener主要的目的就是为了将一些全局性的代码逻辑迁移出来。

### 使用

- 编写一个类实现ServletContextListner接口


- 注册该listener(注解或web.xml)

  ```java
  import javax.servlet.ServletContext;
  import javax.servlet.ServletContextEvent;
  import javax.servlet.ServletContextListener;
  import javax.servlet.annotation.WebListener;
  
  /**
   * @ClassName MyServletContextListener
   * @Description: TODO
   * @Author 远志 zhangsong@cskaoyan.onaliyun.com
   * @Version V1.0
   **/
  @WebListener
  public class MyServletContextListener implements ServletContextListener {
      @Override
      public void contextInitialized(ServletContextEvent servletContextEvent) {
          System.out.println("当servletContext对象被创建时，会调用该方法");
          //TODO 购物车案例中的初始化商品业务逻辑写在该方法中 配置文件 读取配置文件
          ServletContext servletContext = servletContextEvent.getServletContext();
          
      }
  
      @Override
      public void contextDestroyed(ServletContextEvent servletContextEvent) {
          System.out.println("当servletContext对象被销毁时，会调用该方法");
  
      }
  }
  ```

  ### 原理

  ServletContext对象的创建和销毁代码是在Tomcat源码内部，在很早之前就已经写好了的。那么这部分代码运行时是如何调用我们现在编写的代码的呢？为了回答这个问题，我们可以从一个案例入手。

  比如：父母俩，有一个宝宝，当宝宝哭闹的时候，父母分别需要去做一些事情。比如此时父亲哄宝宝，母亲去喂奶。我们将这一过程尝试使用代码来表示。

  ```java
  package test;
  
  /**
   * @ClassName Baby
   * @Description:
   * 开闭原则：对于新增是开放的；对于修改是关闭的
   * @Author 远志 zhangsong@cskaoyan.onaliyun.com
   * @Version V1.0
   **/
  public class Baby {
  
      private Dad dad;
  
      private Mom mom;
  
      public Baby(Dad dad, Mom mom) {
          this.dad = dad;
          this.mom = mom;
      }
  
      public void cry(){
          dad.hong();
          mom.feed();
      }
  }
  ```

  ```java
  package test;
  
  /**
   * @ClassName Dad
   * @Description: TODO
   * @Author 远志 zhangsong@cskaoyan.onaliyun.com
   * @Version V1.0
   **/
  public class Dad {
      public void hong() {
          System.out.println("爸爸哄宝宝");
      }
  }
  ```

  ```java
  package test;
  
  /**
   * @ClassName Mom
   * @Description: TODO
   * @Author 远志 zhangsong@cskaoyan.onaliyun.com
   * @Version V1.0
   **/
  public class Mom {
      public void feed() {
          System.out.println("妈妈给宝宝喂奶");
      }
  }
  ```

  ```java
  package test;
  
  /**
   * @ClassName MainRun
   * @Description: TODO
   * @Author 远志 zhangsong@cskaoyan.onaliyun.com
   * @Version V1.0
   **/
  public class MainRun {
  
      public static void main(String[] args) {
          Baby baby = new Baby(new Dad(),new Mom());
          baby.cry();
      }
  }
  ```

  但是，该业务场景是有需要变更需求的可能的。比如工作日父母需要工作，那么可能需要家里的老人帮忙照看孩子，当宝宝再次哭的时候，爷爷奶奶的行为和爸爸妈妈应该是不一样的。并且这次需求的变更也不是永久的，当周末时，父母不上班时，依然是父母照看孩子。如果按照上述代码设计，我们的代码是需要进行频繁往复变更的。如果业务功能发生更改之后，我们需要频繁去修改现有代码才能适配需求的变更，那么我们的代码设计的是不够健壮的。**当需求变更时，我们尽量是扩展而不是修改现有代码**。

  此时，我们可以设计一个接口。

  ![image-20220623231749155](Web组件.assets/image-20220623231749155.png)

```java
package test.update;

/**
 * @ClassName Family
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Version V1.0
 **/
public interface Family {

    void action();
}
```

```java
package test.update;

/**
 * @ClassName Dad
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Version V1.0
 **/
public class Dad implements Family {
    @Override
    public void action() {

    }
}
```

```java
package test.update;

/**
 * @ClassName Mom
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Version V1.0
 **/
public class Mom implements Family {
    @Override
    public void action() {

    }
}
```

```java
package test.update;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Baby
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Version V1.0
 **/
public class Baby {

    private List<Family> familyList = new ArrayList<>();

    public void add(Family family){
        this.familyList.add(family);
    }

    public void cry(){
        for (Family family : familyList) {
            family.action();
        }
    }
}
```

```java
package test.update;

/**
 * @ClassName MainRun
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Version V1.0
 **/
public class MainRun {
    public static void main(String[] args) {
        Baby baby = new Baby();
        baby.add(new Dad());
        baby.add(new Mom());
        baby.cry();
    }
}
```

这个案例和我们介绍的Listener其实非常的类似。

Baby就相当于ServletContext对象

Family类比为ServletContextListener接口

Dad、Mom相当于我们编写的监听器

## Filter

### 概念

> ```
> public interface Filter
> ```
>
> A filter is an object that performs filtering tasks on either the request to a resource (a servlet or static content), or on the response from a resource, or both.
>
> Filters perform filtering in the `doFilter` method.
>
> Filter是一个执行过滤任务的一个对象。它既可以作用于request对象，也可以作用于response对象。或者两者均作用。

![image-20220623233251378](Web组件.assets/image-20220623233251378.png)

filter位于客户端和servlet等资源之间。filter可以在请求到达关联的servlet之前，检查修改request对象；也可以在响应返回给客户端之前，检查修改response对象。filter功能非常类似于边防。

### 开发Filter

整体来说，filter的使用方式以及行为特性和servlet都有很多相似之处，只需要关注和servlet的不同点即可。

1.编写一个类实现Filter接口

2.注册该Filter(注解、web.xml)

```java
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName FirstFiltere
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Version V1.0
 **/
@WebFilter("/filter1")
public class FirstFilter implements Filter {

    //filter的初始化阶段
    //init阶段和servlet略有不同；当应用的启动，init方法就会被执行
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    //类似于servlet的service方法，每次访问filter时，都会经过该方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
    }

    //当应用卸载、服务器关闭，会调用该方法
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
```

filter的生命周期和servlet基本一致，只是init阶段略有不同；filter的init会随着应用的加载而执行。

### 常见问题

- **Filter如何和servlet产生关联**

  filter通过url-pattern和servlet产生关联。最简单的关联方式就是将servlet的url-pattern直接赋值给filter即可。当filter和servlet产生关联之后，默认执行的是拦截操作。如果需要filter执行放行操作，那么需要有一个凭证，也就是filterChain.doFilter(req,resp)代码

- **filter可以设置和servlet相同的url-pattern吗？**完全可以。

- **多个filter之间可不可以设置相同的url-pattern呢？**也是可以的。允许的。

- **filter可不可以设置/*呢？** 可以。并且非常推荐设置 /*,因为这样可以实现filter一对多处理servlet，那么便可以将一些逻辑统一写在filter中进行处理。

- **既然filter可以设置相同的url-patten，那么多个filter执行的先后顺序如何呢？**

  如果是web.xml按照filter-mapping声明的先后顺序；如果是注解，那么按照类名首字母的ASCII先后顺序

- **根据Filter请求流程图，请求、响应应当两次经过Filter，为什么doFilter中打印的代码只有一次？**

  代码在执行时，以filterChain.doFilter(req,resp)为分界线，请求发往servlet时，只执行上半部分；响应从servlet返回时，只执行下半部分。

  ![image-20220624075548111](Web组件.assets/image-20220624075548111.png)

### 登录注销案例

在前面课程中编写的登录案例，登录之后，可以在个人主页中看到用户的用户名；但是如果注销登录之后，访问个人主页，依然可以访问，此时会显示null。我们希望加入设置，未登录的情况下，不允许访问个人主页。

![image-20220624075746057](Web组件.assets/image-20220624075746057.png)

本案例有两种思路。

方案一：Filter的url-pattern设置为个人主页所在的url-pattern。专门用来处理个人主页的逻辑。这种方式处理起来比较简单，但是后续如果新增其他页面也需要设置，那么需要重新修改filter的url-pattern。

方案二：Filter的url-pattern设置为/*,所有的请求都会交给filter来处理。filter根据请求的资源地址判断哪个是个人主页，进而处理业务逻辑。进而我们可以将需要进行判断的页面地址写入到配置文件中，从配置文件中去读取。

我们使用方案二加以实现。

整体业务逻辑为：

1.有的页面需要验证权限，有的页面不需要验证权限

2.针对需要验证权限的页面，登录之后可以访问，没有登录不允许访问

![image-20220624080431898](Web组件.assets/image-20220624080431898.png)

### 引入Filter之后的完整请求处理流程

http://xxx.xxx.xx.xx:80/app/servlet1   

1.域名解析

2.TCP连接建立

3.客户端帮助用户发送HTTP请求报文，请求报文传输到服务器之后

4.被监听着80端口号的Connector接收到，将其解析成为request对象，同时服务器还会提供一个response对象

5.Connector将这两个对象传给engine，engine进一步传递给host

6host去挑选一个合适的Context(首先尝试去查找一个叫做/app的应用)，将这两个对象进行进一步传递

7.Context接收到这两个对象之后进行后续处理，此时有效的路径部分为/servlet1,在当前应用下查找有没有匹配的filter可以处理该请求，如果有，则加入到一个链表中，如果有多个，则按照filter的先后顺序，加入到链表中

8.随后再次去查找有没有servlet可以处理该请求，如果找到，则将其加入到链表的末端；如果么有找到，则将缺省Servlet加入到链表中

9.依次去调用链表中每个组件对应的方法，filter.doFilter方法以及servlet的service方法，执行方法时，将这两个对象作为参数传递进行进行执行

10.所有的组件全部执行完一遍之后，最终Connector读取response里面的数据，按照HTTP响应报文的格式要求，生成HTTP响应报文

11.HTTP响应报文最终到达客户端，被客户端解析、渲染，最终呈现出页面

![image-20220624080523730](Web组件.assets/image-20220624080523730.png)



思考题：

根据图中所示的流程。尝试实现一个注册登录案例。

![image-20220624080707353](Web组件.assets/image-20220624080707353.png)