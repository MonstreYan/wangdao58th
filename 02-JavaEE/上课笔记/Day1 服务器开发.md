# Day1 服务器开发

## 概念

服务器：提供网络访问服务的一台机器。提及服务器，一般有两层含义，一层指的是硬件层面，指的是一台性能比较高效的计算机主机；另外一层指的是软件层面，可以将本地的资源发布到网络中，供网络上面的其他用户来访问。在没有特殊说明的情况下，我们指的都是软件层面。

静态web资源：一成不变的，无论任何人、任何时间看到的内容都是完全一致的。早期的互联网上面的资源基本都是这种形式。访问静态web资源时，实际上访问的就是这个页面。

动态web资源：具有交互性、变化性。不同时间、不同人看到的内容可能都是完全不同的。目前互联网上面的资源主要就是动态web资源。访问动态web资源时，实际上访问是程序。在java语言中，开发动态web资源的技术便是叫做Servlet。



## 手写简易web服务器

通过这个案例，我们并不是要求开发一个服务器产品，而是通过该案例，能够让大家对于服务器的原理、概念有所了解即可。另外一方面，对HTTP协议去做一个复习总结。

web服务器：软件，这个软件可以干什么？可以将本地的资源发布到网络中，供网络上面的其他用户来访问。如果用户访问的是一个不存在的资源，需要返回404状态码。

### v1

最简易的v1版本。可以接收到了客户端发送过来的数据。

```java
public class Server1 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //当前计算机中创建一个应用程序 ，持续不断地去监听8080端口号
            serverSocket = new ServerSocket(8080);
            //每当有一个客户端连接进来，那么便会创建一个Socket，java语言中对应的封装形式就是Socket对象
            Socket client = serverSocket.accept();
            //如果想要获取客户端发送过来的数据信息，使用下面的代码
            InputStream inputStream = client.getInputStream();
            byte[] bytes = new byte[1024];
            //如果没有数据过来的情况下，也会阻塞在这一行
            int length = inputStream.read(bytes);
            String request = new String(bytes, 0, length);
            System.out.println(request);
            //如果希望给客户端返回响应信息
            OutputStream outputStream = client.getOutputStream();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

```



### v2

服务器程序不应该结束；在一个循环中accept以及read均是阻塞步骤，那么如果有一个客户端建立了tcp连接，但是不发送数据，会一致阻塞在read步骤，后续客户端就无法建立tcp连接，服务器便不可用了，使用多线程。

```java
public class Server2 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //当前计算机中创建一个应用程序 ，持续不断地去监听8080端口号
            serverSocket = new ServerSocket(8080);
            while (true){
                //每当有一个客户端连接进来，那么便会创建一个Socket，java语言中对应的封装形式就是Socket对象
                Socket client = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //如果想要获取客户端发送过来的数据信息，使用下面的代码
                        InputStream inputStream = null;
                        try {
                            inputStream = client.getInputStream();
                            byte[] bytes = new byte[1024];
                            //如果没有数据过来的情况下，也会阻塞在这一行
                            int length = inputStream.read(bytes);
                            String request = new String(bytes, 0, length);
                            System.out.println(request);
                            //如果希望给客户端返回响应信息
                            OutputStream outputStream = client.getOutputStream();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

### v3

在这一版本，我们就需要进一步去解析请求报文了.

这一版本的代码有一些难度，但是需要大家重点关注的部分就是协议解析的部分。

```java
public class Server3 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //当前计算机中创建一个应用程序 ，持续不断地去监听8080端口号
            serverSocket = new ServerSocket(8080);
            while (true){
                //每当有一个客户端连接进来，那么便会创建一个Socket，java语言中对应的封装形式就是Socket对象
                Socket client = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //如果想要获取客户端发送过来的数据信息，使用下面的代码
                        InputStream inputStream = null;
                        OutputStream outputStream = null;
                        try {
                            inputStream = client.getInputStream();
                            byte[] bytes = new byte[1024];
                            //如果没有数据过来的情况下，也会阻塞在这一行
                            int length = inputStream.read(bytes);
                            //请求报文
                            String request = new String(bytes, 0, length);
                            //获取请求资源部分（获取第一个换行符，利用空格分割，取出中间部分），查看该文件是否存在
                            int index = request.indexOf("\r\n");
                            //substring:截取部分字符串信息，里面的参数表示的开始、结束的位置
                            String line = request.substring(0, index);
                            //split:分割
                            String[] parts = line.split(" ");
                            //表示的是请求资源部分
                            String requesturi = parts[1];
                            //如果文件存在，将文件响应出去，返回200状态码
//                            System.out.println(requesturi);
                            //拿到请求资源之后，希望去到当前项目的根目录中去查找对应的文件是否存在
                            //特别说明一点：如果路径中以/开头，那么file会把这个路径当做一个绝对的路径去解析，linux里面的路径就是这样的  /usr/local/app/xxx,需要将第一个/去掉
                            StringBuffer stringBuffer = new StringBuffer();
                            outputStream = client.getOutputStream();
                            File file = new File(requesturi.substring(1));
                            if(file.exists() && file.isFile()){
                                //文件存在，并且不是目录  200
                                stringBuffer.append("HTTP/1.1 200 OK\r\n");
                                stringBuffer.append("Content-Type:text/html\r\n");
                                //空行
                                stringBuffer.append("\r\n");
                                //目前只是把响应行、响应头、空行写出去了，但是响应体还没有写
                                outputStream.write(stringBuffer.toString().getBytes("utf-8"));

                                //响应体
                                FileInputStream fileInputStream = new FileInputStream(file);
                                int read = 0;
                                byte[] bs = new byte[1024];
                                while ((read = fileInputStream.read(bs)) != -1){
                                    outputStream.write(bs, 0, read);
                                }
                            }else {
                                //404
                                stringBuffer.append("HTTP/1.1 404 File Not Found\r\n");
                                stringBuffer.append("Content-Type:text/html\r\n");
                                stringBuffer.append("Server:kongling\r\n");
                                stringBuffer.append("\r\n");
                                stringBuffer.append("<div>File Not Found</div>");
                                outputStream.write(stringBuffer.toString().getBytes("utf-8"));
                            }
                            //如果文件不存在，返回404状态码
                            //如果希望给客户端返回响应信息
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }finally {
                            if(outputStream != null){
                                try {
                                    outputStream.close();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```



### v4

思考题：这一次，我们获取的是请求报文的请求资源部分，下一次我希望获取referer请求头，意味着我需要重新再次解析一遍嘛？能否一次性将整个请求报文解析封装成为一个对象，每次获取哪个部分，直接从对象中获取指定的位置即可。思路：数据解析封装到一个request对象中，里面存储请求行、请求头的各部分数据。



