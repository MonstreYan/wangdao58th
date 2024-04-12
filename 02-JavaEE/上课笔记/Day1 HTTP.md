# Day1 HTTP

## 介绍

自我介绍：远志。

课程内容：6周。数据库阶段、EE规范阶段、**项目一阶段**、Spring全家桶框架阶段、**项目二阶段**



## 学习方法

比较高效的学习方法：

1.上课的时候跟着思路走。上课的时候遇到听不懂的地方怎么办？发弹幕、记录下时间，课后提问(千万不要自己去搜索)

2.写代码。如何去写呢？上课代码建议都敲一遍。根据自己的思考结果，写代码  > 对照着参考代码写一遍 > 不写代码

3.提问。多提问，半个小时没思路，直接提问。提问的时候重点关注老师和同学是如何解决问题的。(如何怕记不住过程，可以录屏，如果有精力，可以自己总结一份bug-list(你在开发过程中遇到什么难题、挑战吗？))



## HTTP协议

### 协议

日常生活中，接触过很多的协议，比如三方协议、购房协议、租房协议。

协议是用来去约定合同双方的权利和义务。

但是，在我们网络中，我们提及的协议指的是什么意思呢？

网络中的协议指的便是通讯双方在通讯过程中应当遵循的规范，也就是指的是请求和响应应该如何去发送。请求和响应的格式约束。

举一个案例：

甲乙双方通过网络去传输学生的信息，乙方接收到学生的信息之后，需要取出性别，来安排宿舍。

甲方：

空灵 28 男 湖北省

远志 30 男 安徽省

阿齐 28 女 湖北省

乙方：

（应该如何去解析？）

1.接收到全部的字符信息之后，利用换行符来进行分割，分割的每一部分便是一个学生的信息

2.在上述处理的基础上，再利用空格来进行分割，取出第3部分数据，里面的值便是性别

上述甲乙双方能够正常通讯的前提是什么呢？甲乙双方都知道数据的格式。数据的格式需要约定好。这个便是协议。

### HTTP协议

根据上述概念，HTTP协议是什么？是指的是使用HTTP来进行通讯时，通讯双方传输数据时，数据具有的特定的格式。

所以HTTP可以分为HTTP请求、HTTP响应。就是指的是HTTP请求时，请求的格式以及HTTP响应时，响应的格式。

HTTP究竟是什么呢？Hyper Text Transfer Protocol.超文本传输协议。

超文本：超越了普通的文本，不止是普通的文本文件，还有图片、音频、视频等资源类型

传输：通讯双方

协议：通讯双方在传递信息时，信息应当具有的格式

> HTTP协议和HTML之间的关系
>
> tim bernes lee：做实验、写论文
>
> HTTP：超文本传输协议。HTTP诞生之初就是为了去解决论文的传输问题
>
> HTML：超文本标记语言。html诞生之初就是为了去解决论文的写作的问题。

### 网络模型

模型说白了便是分层。分层并不是指的是物理上面的分层，切割，而是指的是逻辑上面的划分。将相关功能、相似的供代码放在一起，作为一个层，另一部分代码和这部分代码差异比较的话，那么归属于另外一个层。

比如说：传输层，有TCP和UDP；网络层协议IP协议

常见的网络模型有两种：

1.OSI参考模型：这个更多只是一个理论基础。将网络进一步细分解耦成了7个层。物联网输会示用

**2.TCP/IP模型**：真正落地的。按照从上到下(何为下？越靠近硬件叫做下)分为：应用层、传输层、网络层、数据层、链路层

今天给大家介绍的HTTP协议属于应用层的一个协议。指的是应用和应用之间传输数据时，使用的协议。比如说浏览器、客户端(微信、qq客户端....)和服务器之间的通讯使用的格式。



### HTTP协议工作流程(掌握)

1.域名解析

2.建立TCP连接

3.发送HTTP请求

4.返回HTTP响应

5.客户端进行解析、渲染

以输入http://www.cskaoyan.com为例

#### 域名解析

域名：域名其实就是一个具有特定含义的字符，用这串字符来代替网络中的一个ip地址。

字符-------IP映射

IP地址对于人来说，是不容易记忆的，对人比较容易记忆的是具有特定含义的字符；对于计算机来说，比较容易进行处理的是ip地址。所以我们需要设定一个域名解析过程，将特定的字符转换成ip地址。

jd.com------360buy.com



浏览器会根据以下过程，依次去查找域名对应的ip地址：

1.浏览器缓存：浏览器访问过某个网站之后会记忆，这也就是为什么第一次访问的时候速度会比较慢一些

2.操作系统缓存

3.hosts文件

4.dns域名解析服务器：一般情况下由网络供应商来提供。



#### 建立TCP连接

建立TCP连接，其实就是建立生成一个Socket.

Socket四要素：客户端ip地址、客户端端口号、服务器ip地址、服务器端口号

只要保证四要素唯一，那么就是一个新的Socket。

建立TCP连接的过程中，需要经历三次握手。为什么是三次呢？

至少要保障三次。



#### 发送HTTP请求

建立TCP连接之后，**浏览器(客户端)**会发送HTTP请求信息，经过传输层、网络层、链路层等从计算机出去，在网络中进行中转传输，到达目标机器主机，被监听指定端口号的程序接收到，进行解析处理



#### 返回HTTP响应

**服务器**会根据客户端请求的资源或者意图，返回对应的数据内容.同样也是需要再网络中进行中转传输,返回给客户端.



#### 客户端进行渲染解析

如果服务器返回的是一个html页面,浏览器便会对html页面里面的标签进行解析,如果遇到了img标签.则浏览器会再次去发送HTTP请求,直至获取到所有的资源文件之后呢,将页面进行渲染呈现出来.





### HTTP请求详解

客户端发送的HTTP请求信息,一般情况下,我们也称之为HTTP请求报文.

HTTP请求报文具有以下格式:

请求行

请求头

空行

请求体

#### 请求行(掌握)

分为三部分组成:请求方法、请求资源、版本协议

##### 请求方法

指的是当前的HTTP请求所使用的方法类型。常见的有GET或者POST.

GET和POST究竟有什么区别呢？

**最根本的区别在于语义上面的差异。GET的语义表示查询、POST表示提交。**

查看某个商品：GET

注册、登录：POST

GET:

GET http://www.cskaoyan.com/ HTTP/1.1
Host: www.cskaoyan.com
Connection: keep-alive
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
Accept-Encoding: gzip, deflate
Accept-Language: zh-CN,zh;q=0.9
Cookie: cZBD_2132_saltkey=tDd7Dw6d; cZBD_2132_lastvisit=1712887470; Hm_lvt_5f3c4e32676aacc710ede84276010d9b=1712891146; cZBD_2132_sid=JiGG5C; cZBD_2132_st_t=0%7C1712891734%7C8e212f9f3bb1e15720e15532a8ddf35b; cZBD_2132_forum_lastvisit=D_280_1712891726D_279_1712891734; cZBD_2132_lastact=1712892506%09home.php%09misc; cZBD_2132_sendmail=1; Hm_lpvt_5f3c4e32676aacc710ede84276010d9b=1712892507

POST:

POST http://www.cskaoyan.com/ HTTP/1.1
Host: www.cskaoyan.com
Connection: keep-alive
Content-Length: 87
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
Origin: http://localhost:63342
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
Referer: http://localhost:63342/
Accept-Encoding: gzip, deflate
Accept-Language: zh-CN,zh;q=0.9
Cookie: cZBD_2132_lastact=1712892505%09forum.php%09ajax

username=admin&password=admin123&gender=female&course=java&course=python&course=c%2B%2B

> 1.什么情况下会发送GET请求、什么情况下会发送POST请求？
>
> 正常情况下俩说，如果希望发送POST请求，则需要大家去通过form表单去发送，因为通过浏览器直接访问的话，99%情况下都是GET请求。
>
> 2.表单回顾
>
> form标签，具备method=get/post；action地址表单提交的地址
>
> form表单里面可以进一步去编写input标签
>
> 3.发送GET请求时，不会有请求体

##### 请求资源

指的是访问服务器上面的哪个资源。访问两个不同的页面，区别主要在于请求行的第二部分。服务器需要获取这部分数据，确定客户端需要访问哪个页面资源。

> 为了能够让大家很直观地看到这部分内容，我们需要给大家介绍抓包。抓取网络传输过程中的数据。fiddler
>
> http://www.cskaoyan.com/forum-280-1.html
>
> http://www.cskaoyan.com/forum-279-1.html
>
> 上述是两个不同的页面，通过抓包，查看彼此之间的差异
>
> GET http://www.cskaoyan.com/forum-280-1.html HTTP/1.1
> Host: www.cskaoyan.com
> Connection: keep-alive
> Upgrade-Insecure-Requests: 1
> User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36
> Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
> Referer: http://www.cskaoyan.com/forum.php
> Accept-Encoding: gzip, deflate
> Accept-Language: zh-CN,zh;q=0.9
> Cookie: cZBD_2132_saltkey=tDd7Dw6d; cZBD_2132_lastvisit=1712887470; cZBD_2132_sid=wf6ssp; cZBD_2132_lastact=1712891089%09home.php%09misc; Hm_lvt_5f3c4e32676aacc710ede84276010d9b=1712891146; Hm_lpvt_5f3c4e32676aacc710ede84276010d9b=1712891146
>
> ===================================================================================================================================================================================================================================================
>
> GET http://www.cskaoyan.com/forum-279-1.html HTTP/1.1
> Host: www.cskaoyan.com
> Connection: keep-alive
> Upgrade-Insecure-Requests: 1
> User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36
> Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
> Referer: http://www.cskaoyan.com/forum.php
> Accept-Encoding: gzip, deflate
> Accept-Language: zh-CN,zh;q=0.9
> Cookie: cZBD_2132_saltkey=tDd7Dw6d; cZBD_2132_lastvisit=1712887470; Hm_lvt_5f3c4e32676aacc710ede84276010d9b=1712891146; cZBD_2132_sid=JiGG5C; cZBD_2132_st_t=0%7C1712891726%7Ccaa4e20078695f8c1c2c022be7e68778; cZBD_2132_forum_lastvisit=D_280_1712891726; cZBD_2132_lastact=1712891726%09home.php%09misc; cZBD_2132_sendmail=1; Hm_lpvt_5f3c4e32676aacc710ede84276010d9b=1712891734



##### 版本协议

就是前面看到的HTTP/1.1部分的内容。指的是HTTP协议的版本信息。

目前的版本是1.1版本，前一版本是1.0版本。二者的最大差异是是否支持长连接。

何为长连接呢？是否可以在一个TCP连接内去发送多个HTTP请求。

目前在实验室阶段的还有2.0和3.0版本，倾向于设计成二进制协议的。



#### 请求头(了解)

请求头可以理解为是对于请求行的一个额外补充。请求行其实说的是使用何种请求方法向哪个地址去发送请求，请求头可以理解为是对于上述信息的一个进一步补充说明。比如约定可以接受的数据类型、是否需要压缩等等。

- Accept:浏览器可接受的    MIME类型 */*   (大类型)/(小类型)。

​	浏览器可以接受的类型，如果服务器需要返回资源类型，那么应当返回客户端可以接受的资源类型。

​	MIME：就是用一种大类型/小类型的方式将互联网上面的资源进行分类，比如文本 text/html、text/txt；音频	audio/mp3、视频video/mp4

- Accept-Charset: 浏览器通过这个头告诉服务器，它支持哪种字符集

- Accept-Encoding:浏览器能够进行解码的数据编码方式，比如gzip 。如果服务器你返回给我的内容需要进行压缩，那么选择gzip或者deflate

- Accept-Language: 浏览器所希望的语言种类，当服务器能够提供一种以上的语言版本时要用到,
  可以在浏览器中进行设置。访问https://twitter.com/

- Host:初始URL中的主机和端口 。表示的是当前请求访问的主机、端口号

- Referer:包含一个URL，用户从该URL代表的页面出发访问当前请求的页面 （防盗链）

  ​    用户直接访问A页面和先访问B页面，通过B页面再次访问A页面，能否知晓是使用的哪种方式？

  ​    可行的。就是借助于referer请求头。

  ​	如果直接访问B页面，那么不会有该请求头；如果访问了A页面，再次访问B页面，那么会有一个referer请求头

  ​	有什么用呢？引流。

  > 通过页面跳转：
  >
  > GET http://www.cskaoyan.com/forum-280-1.html HTTP/1.1
  > Host: www.cskaoyan.com
  > Connection: keep-alive
  > Upgrade-Insecure-Requests: 1
  > User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36
  > Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
  > Referer: http://www.cskaoyan.com/forum.php
  > Accept-Encoding: gzip, deflate
  > Accept-Language: zh-CN,zh;q=0.9
  > Cookie: cZBD_2132_saltkey=tDd7Dw6d; cZBD_2132_lastvisit=1712887470; Hm_lvt_5f3c4e32676aacc710ede84276010d9b=1712891146; cZBD_2132_sid=JiGG5C; cZBD_2132_st_t=0%7C1712891734%7C8e212f9f3bb1e15720e15532a8ddf35b; cZBD_2132_forum_lastvisit=D_280_1712891726D_279_1712891734; Hm_lpvt_5f3c4e32676aacc710ede84276010d9b=1712892564; cZBD_2132_lastact=1712894028%09forum.php%09ajax
  >
  > 直接访问：
  >
  > GET http://www.cskaoyan.com/forum-280-1.html HTTP/1.1
  > Host: www.cskaoyan.com
  > Connection: keep-alive
  > Upgrade-Insecure-Requests: 1
  > User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36
  > Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
  > Accept-Encoding: gzip, deflate
  > Accept-Language: zh-CN,zh;q=0.9
  > Cookie: cZBD_2132_saltkey=tDd7Dw6d; cZBD_2132_lastvisit=1712887470; Hm_lvt_5f3c4e32676aacc710ede84276010d9b=1712891146; cZBD_2132_sid=JiGG5C; cZBD_2132_st_t=0%7C1712894068%7C74bd3a3ce256f402ee29af0e615f6115; cZBD_2132_forum_lastvisit=D_279_1712891734D_280_1712894068; cZBD_2132_sendmail=1; Hm_lpvt_5f3c4e32676aacc710ede84276010d9b=1712894069; cZBD_2132_lastact=1712894098%09forum.php%09ajax

- Content-Type:内容类型。如果是GET请求，则不会有该请求头。

- If-Modified-Since: Wed, 02 Feb 2011 12:04:56 GMT 服务器利用这个头与服务器的文件进行比对，如果一致，则告诉浏览器从缓存中直接读取文件。

- User-Agent:浏览器类型.

- Content-Length:表示请求消息正文的长度 。GET请求时，不会有这个头。

- Connection:表示是否需要持久连接。如果服务器看到这里的值为“Keep -Alive”，或者看到请求使用的是HTTP 1.1（HTTP 1.1默认进行持久连接 

- Cookie:这是最重要的请求头信息之一 

- Date: Mon, 22 Aug 2011 01:55:39 GMT请求时间GMT



#### 请求体

这里面一般用来去存放大量的数据，可以是文本数据，也就是字符数据，也可以是二进制数据。

比如form表单提交了字符信息；微信更换头像，提交的是二进制文件信息。



### HTTP响应详解

#### 响应行

响应行又进一步分为：版本协议、状态码、原因短语

状态码：

200   ok  一切正常

301、302、307 重定向(一定需要搭配着一个Location响应头才可以使用)

> http://www.bing.com---------->  https://www.bing.com----------> https://cn.bing.com
>
> 

304 未修改 使用的是缓存

404 未找到 当前位置该文件不存在

500 服务器异常(服务器代码发生了故障)

#### 响应头

- Location: http://www.cskaoyan.com/指示新的资源的位置。需要搭配着重定向状态码一起使用。 
- Server: apache tomcat 指示服务器的类型。
- Content-Encoding: gzip 服务器发送的数据采用的编码类型。和之前学习的Accept-Encoding是对应的
- Content-Length: 80 告诉浏览器正文的长度
- Content-Language: zh-cn服务发送的文本的语言
- Content-Type: text/html;  服务器发送的内容的MIME类型
- Last-Modified: Tue, 11 Jul 2000 18:23:51 GMT文件的最后修改时间
- Refresh: 1;url=http://www.cskaoyan.com指示客户端刷新频率。单位是秒
- Content-Disposition: attachment; filename=aaa.zip指示客户端保存文件
- Set-Cookie: SS=Q0=5Lb_nQ; path=/search服务器端发送的Cookie
- Expires: 0
- Cache-Control: no-cache (1.1)  
- Connection: close/Keep-Alive  
- Date: Tue, 11 Jul 2000 18:23:51 GMT

#### 响应体

服务器返回给客户端的大量的数据信息会放置在响应体中。响应体里面的内容，一般情况下，在没有特殊设置的情况下，会出现在浏览器的主窗口界面中。



## HTTPS

可以理解为是http协议的升级版本，加密版本。

http协议有什么问题？

1.全文没有加密，可以直接抓包获取到内容

2.没有验证通讯另一方的身份，可能被挟持

3.没有完整性校验，篡改部分数据之后，依然无法发现



https主要就是解决了上述三个问题：

1.https采用了加密。采取的是混合加密。

> 加密：对称加密（加密解密使用的是同一把秘钥 字符串；不够安全，速度块）、非对称加密（加密和解密使用的是不同的秘钥：公钥加密 私钥解；私钥加密 公钥解；公钥加密 公钥无法解；私钥加密 私钥无法解；安全，速度慢）

2.采取了证书的形式。证书一般是由第三方的权威机构所颁发的。

