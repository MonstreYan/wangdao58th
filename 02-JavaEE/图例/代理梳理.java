静态代理：

public interface HouseRent{

    void rent();
}

委托类：
public class HouseOwner implements HouseRent{

    public void rent(){
        
    }
}

静态代理类对象：
public class HouseProxy implements HouseRent{

    HouseRent houseRent;

    public HouseProxy(HouseRent houseRent){
        this.houseRent = houseRent;
    }

    public void rent(){
        //在前、后进行增强
        //进一步去调用owner的行为
        houseRent.rent();
        //进行增强
    }
}


动态代理：运行时生成字节码技术
public interface HouseRent{

    void rent();
}

委托类：
public class HouseOwner implements HouseRent{

    public void rent(){
        
    }
}

动态代理类对象：
Object proxy = Proxy.newProxyInstance(classloader,interfaces, new InvocationHandler(){

    //这个方法会在代理类对象的方法调用时，调用
    public Object invoke(Object proxy, Method method, Object args){
            //进一步去调用委托类
            method.invoke(target, args);
    }
});

public class Proxy{

    protected InvocationHandler h;


    public static Object newProxyInstance(classloader,interfaces,invocationHandler){
        this.h = invocationHandler;

        return ......
    }
}


代理类对象反编译之后的结果：
public final class $Proxy0 extends Proxy implements HouseRent{
    //继承自Proxy，内部肯定也会有一个h

    //代理类对象的rent方法中做了什么事情呢？
    public void rent(){
        h.invoke(this, "rent", args);
    }

}