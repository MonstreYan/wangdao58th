import javax.servlet.*;
import java.io.*;

public class Servlet1 extends GenericServlet{


    public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
        System.out.println("hello world");
    }
} 