import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server1
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/12 16:05
 * @Version V1.0
 **/
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
