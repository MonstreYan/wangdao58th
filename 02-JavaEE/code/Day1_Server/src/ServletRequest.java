import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ServletRequest
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/13 9:38
 * @Version V1.0
 **/
public class ServletRequest {

    private String requestMessage;

    private String method;

    private String requestURI;

    private String protocol;

    private Map<String, String> headers = new HashMap<>();

    public ServletRequest(Socket client){
        parseRequest(client);
        //进一步去解析请求行
        parseRequestLine();
        //进一步去解析请求头
        parseRequestHeader();
    }

    //解析请求头 开始\r\nHost:localhost:8080  结束的位置 \r\n\r\n

    private void parseRequestHeader() {
        //找到开始的位置
        int begin = requestMessage.indexOf("\r\n");
        int end = requestMessage.indexOf("\r\n\r\n");
        // Host:localhost:8080
        // Accept:xxxx
        String substring = requestMessage.substring(begin + 2, end);
        String[] parts = substring.split("\r\n");
        for (String part : parts) {
            int index = part.indexOf(":");
            //trim修剪两端的空格
            String key = part.substring(0, index).trim();
            String value = part.substring(index + 1).trim();
            headers.put(key, value);
        }
    }

    //解析请求行  \r\n
    //请求行里面包含三部分：请求方法、请求资源、版本协议
    private void parseRequestLine() {
        int index = requestMessage.indexOf("\r\n");
        String line = requestMessage.substring(0, index);
        String[] parts = line.split(" ");
        this.method = parts[0];
        this.requestURI = parts[1];
        this.protocol = parts[2];
    }

    //将客户端的请求报文解析出来
    private void parseRequest(Socket client) {
        InputStream inputStream = null;
        try {
            inputStream = client.getInputStream();
            byte[] bytes = new byte[1024];
            //如果没有数据过来的情况下，也会阻塞在这一行
            int length = inputStream.read(bytes);
            //请求报文
            this.requestMessage = new String(bytes, 0, length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //向外暴露get方法

    public String getMethod() {
        return method;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public String getProtocol() {
        return protocol;
    }

    //暴露请求头
    //下面两个方法组合在一起，可以获取全部的请求头
    public String getHeader(String key){
        return headers.get(key);
    }

    public Set<String> getHeaderNames(){
        return headers.keySet();
    }

}
