# Day13 Servlet

## 概念

Servlet是什么？为什么要学习Servlet？

Serlvet = Server + applet.运行在服务器上面的小程序，也就是运行在服务器上面的代码片段。希望可以在服务器中运行代码。

希望在服务器中运行代码，那么就得学习Servlet。

JavaEE阶段。企业版开发。企业中，开发一个项目的基本架构模式是什么样的呢？

下图可以理解为是一个简化版的java ee项目的模式图。

![image-20240426100716666](assets/image-20240426100716666.png)

## 开发Servlet

To implement this interface, you can write a generic servlet that extends `javax.servlet.GenericServlet` or an HTTP servlet that extends `javax.servlet.http.HttpServlet`.

上述介绍了编写Servlet的两种方式。

### 继承GenericServlet

```java
import javax.servlet.*;
import java.io.IOException;

public class Servlet1 extends GenericServlet{

    public void service(ServletRequest req, ServletResponse resp) throws ServletException,IOException{
        System.out.print("hello world");
    }
}
```

### 编译

编译会报错，显示无法识别符号，原因在于GenericServlet不在jdk中，此时无法解析这个类究竟是什么。实际上javax.servlet里面的所有的类都是位于一个第三方的jar包中的。所以我们需要做的事情就是将这个jar包加载到内存中。需要借助于类加载器来完成这个事情。我们需要做的事情便是提供这个jar包的路径  

javac -classpath xxxx.jar xxx.java



### 运行(失败了)

使用java指令来运行对应的class文件，提示无法找到主类。没有main方法。根据Servlet的定义，它是运行在服务器里面的小程序，所以首先需要将Servlet部署在tomcat中。



### 部署

tomcat中部署资源有两种方式：一种是直接部署、一种是虚拟映射。

虚拟映射：配置一个应用；一个叫做应用名，一个叫做应用路径

conf/Catlalina/localhost目录下：新建一个58.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<Context docBase="D:\app"/>
```

部署完毕之后，通过路径去访问Servlet，会发现此时是下载文件，而不是运行文件



### 配置

针对服务器上面的资源可以被下载到本地，需要在应用的根目录下新建一个WEB-INF目录，该目录用来去保护服务器上面的资源。也就是任何文件只要放在WEB-INF目录下，均不可能通过直接访问的方式访问到。

虽然此时Servlet源代码文件安全了，但是程序依然没有运行。如何运行Servlet呢?实际上，这里面做了一个映射关系。

比如设置/ss1和Servlet1的映射关系，只要后续用户在浏览器地址栏输入/ss1，那么服务器就去运行Serlvet1的代码。

应该如何进行配置呢？

**下面的内容一定要记住，这是规定**：

应用根目录/WEB-INF/classes/全限定类名(源代码文件)

应用根目录/WEB-INF/lib/运行时需要的jar包(依赖的第三方的jar包类库)

应用根目录/WEB-INF/web.xml(用来配置访问的路径和全限定类名的映射关系)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
  version="3.1"
  metadata-complete="true">

  <servlet>
    <servlet-name>s1</servlet-name>
    <servlet-class>Servlet1</servlet-class>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>s1</servlet-name>
    <url-pattern>/ss1</url-pattern>
  </servlet-mapping>
 
</web-app>
```

### 访问

http://localhost:8080/{应用名}/{url-pattern}



