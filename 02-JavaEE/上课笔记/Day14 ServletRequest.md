# Day14 ServletRequest

## 概念

1.是什么？ServletRequest是一个提供给servlet的关于客户端请求信息的封装对象。Servlet容器也就是tomcat服务器创建了该对象，并且在调用servlet的service方法时，将其传递了进去。ServletRequest其实就是对于客户端请求信息的封装。

Defines an object to provide client request information to a servlet. The servlet container creates a `ServletRequest` object and passes it as an argument to the servlet's `service` method.

为什么是interface？设计成接口的好处是什么？规范、统一。不同的服务器针对该接口做不同的实现。只需要写一份通用的代码，那么便可以在不同的服务器中运行。

2.为什么要学习它？处理请求信息时更加的方便。如果没有servletRequest，那么我们得到的是一个字符串的请求报文，如果想获取某个部分，需要自己去解析，非常的麻烦。借助于servletRequest，可以将请求报文预先先拆解封装到一个对象中，使用的时候，直接从对象中获取即可。



3.ServletRequest和HttpServletRequest有什么关系？父子接口的关系。

ServletRequest你可以理解为是对应请求报文的封装。

HttpServletRequest你可以理解为是对于HTTP请求报文的封装。

二者之间的区别在于协议的不同。

一般情况下，我们发送请求时，都发送的是HTTP请求报文，所以二者可以看做是等价的。

## 常用功能

1.获取请求报文的各个部分

请求行：请求方法 请求资源 版本协议

请求头

请求体



