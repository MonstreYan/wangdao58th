# Day15 ServletResponse

## 概念

Defines an object to assist a servlet in sending a response to the client. The servlet container creates a `ServletResponse` object and passes it as an argument to the servlet's `service` method.

该对象的功能是用来协助Servlet给客户端返回响应信息。tomcat创建了一个serlvetResponse对象，传递给service方法的形参。

To send binary data in a MIME body response, use the [`ServletOutputStream`](https://tomcat.apache.org/tomcat-8.5-doc/servletapi/javax/servlet/ServletOutputStream.html) returned by [`getOutputStream()`](https://tomcat.apache.org/tomcat-8.5-doc/servletapi/javax/servlet/ServletResponse.html#getOutputStream()). To send character data, use the `PrintWriter` object returned by [`getWriter()`](https://tomcat.apache.org/tomcat-8.5-doc/servletapi/javax/servlet/ServletResponse.html#getWriter()).

如果你需要返回二进制数据，应该xxxx；如果需要返回字符信息，应该xxx



## 使用

设置响应报文的各个部分。

```java
@WebServlet("/resp1")
public class ResponseServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //设置响应报文
       //设置响应行
        resp.setStatus(404);

        //设置响应头
        resp.setHeader("Server", "Apache Software Foundation");

        //设置响应体
        resp.getWriter().println("hello world");
    }
}
```

ServletResponse充当的相当于超市购物时小推车的功能。ServletResponse的使命就是在开发人员在编写业务代码时，也就是在service方法中暂时性存储需要返回给客户端的响应信息。后续服务器会读取ServletResponse里面的数据，生成HTTP响应报文，此时ServletResponse的使命就已经终结了。



