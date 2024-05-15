

# Day28 SpringMVC

## 概念

Spring是用于处理什么组件的框架？？？是不是Service？？？不是Service。Spring主要做的事情是去搭建一个框架的平台。无论各种框架类库，都可以运行在Spring体系内。

在前面的课程中，我们将三层架构中的功能模块的serivce组件以及mapper组件放入到spring容器中了，肯定希望将controller也放入到spring容器中。数据共享会非常方便。

针对展示层，也就是处理controller部分，spring提供的一个框架叫做SpringMVC。

SpringMVC有什么功能，为什么要去学习SpringMVC？项目一java web项目开发过程中的痛点

1.请求参数的接收过程中，比较繁琐，如果是json字符串，那么需要我们开发人员自行去解析处理

2.响应也不是特别的方便，尤其是结合着之前学习的Spring中的AOP之后，发现可以进行很大的优化(response.getWriter().println(new ObjectMapper.writeValueAsString(obj)));-----完全可以使用切面来实现

3.请求参数校验过程中也比较的繁琐。需要判断是否为空，需要判断是否是整数等。

4.项目一的controller中的doGet或者doPost中，都有分发的代码，着实有一些繁琐。

5.借助于SpringMVC框架，其实可以和其他的位于Spring容器中的组件共享spring容器的功能。





## SpringMVC入门案例(熟悉)

入门案例使用xml文件配置的方式，熟悉即可，后续主要使用配置类。

1.导入依赖



2.改造成java ee项目，pom.xml文件设置<packaging>war</packaging>,在src\main目录下新建webapp目录；

open module settings----选择+号，根据提示创建对应的web.xml文件

设置完之后，在webapp/WEB-INF目录下会有一个web.xml文件

![image-20240515103752870](assets/image-20240515103752870.png)



3.在web.xml文件中进行如下的配置：

```xml
<servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:application.xml</param-value>
        </init-param>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```







