# Day7 ConnectionPool

## 概念

在前面的课程中，我们有提及过，数据库的连接是一个非常稀缺的资源。尽量遵循着晚创建、早释放的原则。数据库的连接创建过程也是比较消耗性能、消耗资源的步骤，如果在某一个时间点，大量的请求去访问数据库，创建多个连接，极易容易导致系统的宕机。所以基于上面这两部分考虑，我们引入了数据库连接池。

数据库连接池是什么？在系统空闲的时候，预先先将数据库的连接创建出来，等后续使用时，直接从池子中取出来一个连接来使用，而不是去创建。因为如果并发比较多的情况下，去创建很容易导致系统的宕机。

为什么要使用它？提升操作性能、提升效率。避免进行频繁地数据库连接的创建工作，减少系统宕机的风险。

今天介绍的数据库连接池和之前的JDBC又有什么样的区别和联系？之前我们是使用DriverManager.getConnection在使用的时候直接去创建连接，但是现在是提前先创建好，使用的时候直接从连接池中获取，而不是再去创建。



## 自己实现简易数据库连接池

### v1

我们根据自己对于数据库连接池的理解，自己去实现一个非常简易的数据库连接池。

```java
public class MyConnectionPool1 {

    //连接池，使用什么来充当池子呢？容器 list 存放的是什么呢？Connection
    //使用linkedlist来充当池子
    private static LinkedList<Connection> connectionPool = new LinkedList<>();

    static {
        //预先先创建好10个连接，放入池子中，后续客户端使用的时候，直接从池子中获取
        for (int i = 0; i < 10; i++) {
            Connection connection = null;
            try {
                //创建连接，自己封装编写的工具类
                connection = JdbcUtils.getConnection();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            connectionPool.addFirst(connection);
        }
    }


    public static Connection getConnection(){
        return connectionPool.pollLast();
    }

    public static void returnConnection(Connection connection){
        connectionPool.addFirst(connection);
    }
}
```



### v2

上述呢，是一个非常简易的连接池版本。其实sun公司针对数据库连接池这部分其实也是有一个标准规范的，叫做DataSource。所以，如果我们希望能够编写出一个符合JDBC规范的数据库连接池，那么我们应当实现DataSource接口。

```java
public class MyConnectionPool2 implements DataSource {

    private static LinkedList<Connection> connectionPool = new LinkedList<>();


    static {
        for (int i = 0; i < 10; i++) {
            try {
                connectionPool.addFirst(JdbcUtils.getConnection());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //只去实现接口中的这个方法
    @Override
    public Connection getConnection() throws SQLException {

        return connectionPool.removeLast();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
```



但是实现了DataSource接口的这个数据库连接池版本也会有一个问题，那就是接口中并没有定义回收连接的方法。为什么接口中没有定义该方法呢？

因为即使定义了该方法，也没有太大的意义，因为用户可以不去调用该方法，而是直接调用了close方法。导致了你做的一切白费。所以sun公司希望你采用另外一种方式去解决该问题。



### v3

包装设计模式。思想：重写close方法，将连接放回连接池，而不是关闭。











