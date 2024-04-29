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





伪代码：

```java
public class Response{
    
    int code = 200;
    
    Map<String,String> headers;
    
    //往这里面写入数据，这部分数据会最终出现在响应体中response.getWriter().println(xxxx)
    byte[] body;
    
    void setStatus(code){
        this.code = code;
    }
    
    void setHeader(key,value){
        this.headers.put(key,value)
    }
    
    //服务器会读取该方法，利用该方法生成HTTP响应报文
    void responde(){
        HTTP/1.1 + code + \r\n
        headers.for{
            key : value + \r\n
        }
        \r\n
        body
    }
    
    
}
```



## 输出字符数据(掌握)

输出字符信息。response.getWriter().println(xxxx)。这个代码背后的原理是response对象内部持有一个数组，通过该方法最终是往数组里面写入数据，后续服务器会读取这部分数据，生成HTTP响应报文。

```java
/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 14:38
 * @Version 1.0
 */
@WebServlet("/char2")
public class CharServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //输出字符数据
        //中文乱码？如何解决呢？
        //可以借鉴req的来；
        //为什么设置utf-8之后还是乱码？原因在于编解码不一致
        //分析：响应报文从服务器出去的时候，以及到达客户端之前的编码格式utf-8
        // 响应报文被浏览器解析之后，浏览器使用的是什么编码格式？？？？gbk，和操作系统、语言有关 默认选择gbk
        //从根本上解决该问题：设置一个编码格式 + 把设置的编码格式告诉给客户端（响应头、响应体）
//        resp.setCharacterEncoding("utf-8");
        //设置的编码格式告诉给客户端
        //实际上，如果设置了下面这行代码，上面这行代码就无需开发人员自己主动去设置了，服务器会帮助我们设置
//        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        //因为content-type这个响应头用的比较多，所以ee规范又单独给它封装了一个方法，下面方法完全等价
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("你好！！！！");
    }
}
```



## 输出字节数据(掌握)

输出二进制数据。ServletOutputStream继承自OutputStream，OutputStream表示的是输出流，所以ServletOutputStream也表示的是输出流。不同的输出流之间的区别主要在哪呢？主要在于输出的目的地不同。但是输出的行为是一致的。所以，后续学习过程中，如果大家遇到一个新的类对象，不知道该如何使用时，直接去看类继承关系；如果和之前学习的某个类非常相似(类继承关系上面比较接近),那么90%的情况下，是可以和之前的类使用相同的步骤去实现的。

```java
@WebServlet("/stream")
public class StreamServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //位于resources目录下有一个1.png，希望你可以将该图片响应给客户端 io流
        //需要有一个输入流、输出流
        ServletOutputStream outputStream = resp.getOutputStream();

        //从硬盘上面某一处来获取文件的输入流
        //文件经过部署之后位于classpath目录下
        ClassLoader classLoader = StreamServlet3.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("1.png");
        //写入的长度
        int length = 0;
        //往数组里面写入数据
        byte[] buffer = new byte[1024];
        while ((length = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();
    }
}
```



案例：要求在当前项目中实现缺省Serlvet。





## 页面跳转(了解)

大家如果时间来不及，可以不练习，看我演示即可。重点是能够理解原理过程。

凡是涉及到页面的部分全部都是了解的内容，因为后续的开发工作基本上都是前后端分离，前端负责页面的渲染显示等，后端负责获取接收数据。

### refresh响应头

给客户端返回一个refresh响应头，指示客户端经过指定秒数之后再次刷新页面；或者跳转到一个新的页面。

```java
@WebServlet("/refresh")
public class RefreshServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //每隔一段时间，刷新页面  时刻刷新显示最新的时间
        resp.setHeader("refresh", "1");
        resp.getWriter().println(new Date());
    }
}
```



```java
@WebServlet("/refresh2")
public class RefreshServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //每隔一段时间，刷新页面  时刻刷新显示最新的时间
        //登录成功，即将跳转至新的页面，如果没有自动跳转，可以点击下方的链接进行手动跳转
        resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/stream");

    }
}
```





### 重定向

301、302、307状态码搭配着Location响应头，指示客户端下一次跳转到Location地址处。

```java
@WebServlet("/direct")
public class DirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重定向
        resp.setStatus(302);
        resp.setHeader("Location", req.getContextPath() + "/stream");
    }
}
```



案例：登录，登录成功之后，跳转到一个页面





