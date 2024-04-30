# Day16 会话技术

## HTTP协议无状态性

接下来，通过一个实验案例来展示一下HTTP协议无状态性。

案例：要求在访问Servlet时，可以打印处客户端对应的请求报文信息以及客户端的ip地址信息。

```java
@WebServlet("/status")
public class HttpStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //打印一下客户端的ip地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("client address: " + remoteAddr + " visit this page: ");

        //要求：可以打印处当前请求报文
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String protocol = req.getProtocol();
        System.out.println(method + " " + requestURI + " " + protocol);

        //请求头
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + " " + headerValue);
        }
    }
}
```





```
client address: 192.168.102.23 visit this page: 
GET /app/status HTTP/1.1
host 192.168.102.23:8080
connection keep-alive
upgrade-insecure-requests 1
user-agent Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36
accept text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
accept-encoding gzip, deflate
accept-language zh-CN,zh;q=0.9
===========================================================================
client address: 192.168.102.124 visit this page: 
GET /app/status HTTP/1.1
host 192.168.102.23:8080
connection keep-alive
upgrade-insecure-requests 1
user-agent Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36 Edg/122.0.0.0
accept text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
accept-encoding gzip, deflate
accept-language zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6
```

通过上面的案例，我们可以发现，不同客户端发送过来的HTTP请求报文基本上是一模一样的。对于服务器来说，不可能通过请求报文区分出彼此才对。这个称之为HTTP协议无状态性。

但是，在实际的web访问过程中，你会发现，这个现象其实并不存在：实际上服务器是可以区分客户端的。它是怎么做到的呢？实际上便是借助了会话技术。

https://shopping.dangdang.com/shoppingcart/shopping_cart.aspx?product_ids=0&referer=null&prev_referer=null

## 什么是会话技术

会话技术主要是为了去解决HTTP协议无状态性的一种解决方案。引入会话技术，就是为了去解决HTTP协议的无状态性。

会话如何理解呢？你可以理解为交谈的上下文。因为HTTP协议无状态性，所以对于服务器的程序来说，是无法理解"我",”这个商品“等这些字样代表的含义的。

会话技术一共有两种，一种是客户端技术，一种是服务器技术。关键在于数据存储在哪，如果存储在客户端，那么便是客户端技术；如果存储在服务器，那么便是服务器技术。

客户端技术的典型代表是Cookie

服务器技术的典型代表是HttpSession

## Cookie

Cookie是一个客户端技术。数据的产生是位于服务器，但是数据的存储是位于客户端。此时需要借助于**HTTP响应报文(set-Cookie:key=value响应头)**，将Cookie数据发送给客户端；客户端随即会将该Cookie数据保存下来，当客户端下一次再次访问服务器时，那么便会借助于**HTTP请求报文(Cookie:key=value)**把这个数据再次携带回去；服务器通过取出里面的值，便可以知道数据来自于哪个客户端。

**所以，Cookie的本质其实就是在HTTP请求报文和HTTP响应报文中额外再次引入了两个头信息**。

我和大家的区别主要在于我执行了加入购物车操作，服务器将Cookie信息返回给了我；而大家是没有这步操作的。

![image-20240430115206359](assets/image-20240430115206359.png)







