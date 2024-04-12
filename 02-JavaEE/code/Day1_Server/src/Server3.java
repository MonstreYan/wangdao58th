import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server1
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/12 16:05
 * @Version V1.0
 **/
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
