# Day18 MVC

## JSON

### 概念

JSON:JavaScript Object Notation.翻译成中文就是js里面的对象。JSON并不从属于js语言，很多编程语言都有针对json的解析器。

JSON主要使用场景是用于数据传输过程中特定的数据格式。

比如说前后端分离的情况下，前端使用的是js语言，后端使用的是java语言。二者之间需要进行通讯，应该传递什么类型的数据呢？

之前，主要使用xml文件来进行存储，后续主要使用json文件来进行存储。使用json主要的原因在于json更加的高效。

**综上所述：JSON是一个数据传输的格式。用于去指定传输的数据的格式类型。**

### 为什么学习JSON

之前也是有学过一个数据传输格式的，key=value&key=value，那为什么现在又学习json了呢？

json其实是js里面的对象。对象里面包含的属性是可以有嵌套关系的，那么便可以表示出数据和数据之间的关系。

比如目前进行商品的发布，有商品的信息，还有规格的信息，商品和规格之间是一对多的关系，那么如果此时使用key=value能否表示出数据和数据之间的关系呢？

此时在服务器端能否确定specName和unitPrice哪个组合是相互对应的

``` 
name=iphone15&description=newIphone&specName=蓝色&unitPrice=5888&specName=红色&unitPrice=6899
```

如果此时使用json呢，能否表示出数据和数据之间的关系呢？

{"name":"iphone14","description":"newIphone",specs:[{"specName":"蓝色","unitPrice":5888},{"specName":"红色","unitPrice":6899}]}

**综上所述：JSON可以理解为是对于key=value&key=value数据格式的一个额外补充，可以描述处数据和数据本身之间的关系，但是如果使用key=value&key=value，此时就具有很大的局限性，没法表示出数据和数据之间的关系。**



### JSON语法

**1.如果是一个对象，那么使用{}来表示**

**2.如果是一个数组或者集合，则使用[]来表示**

**3.属性使用key:value来表示，多个属性之间使用,来进行分割**



下面是使用Java语言来描述的一个类，利用类可以创建一个对象。

```java
public class Student1 {
    
    private String username;
    
    private String password;
}
```

在js中，如何定义一个对象呢？也就是写一个json

```javasc
var student = {username:"admin13",password:"admin123445"}
```



如果使用java语言来描述一个类，该类的内部进一步持有了另外一个对象

```java
public class Student2 {
    
    private String username;
    
    private String password;
    
    //持有了一个爱好
    private Hobby hobby;
}

public class Hobby {

    private String name;

    private String description;
}

```

如果我们使用js来表示上述的关系，应该如何描述呢？

```js
var student2 = {username:"admin123",password:"admin1231",hobby:{name:"swim",description:"adads"}}
```





如果一个对象的内部持有了一个对象的集合，使用java语言按照下面的方式来进行描述

```java
public class Student3 {
    
    private String username;
    
    private String password;
    
    private List<Hobby> hobbyList;
}
```

如果使用js语言应该怎么描述呢？

```js
var student3 = {usernmae:"admin123", password:"admin1221323", hobbyList:[{name:"",description:""},{}]}
```



其中，上述关于json一共有两种写法，一种是：

```
var student3 = {usernmae:"admin123", password:"admin1221323", hobbyList:[{name:"",description:""},{}]}
```

另外一种是

```
{"name":"iphone14","description":"newIphone",specs:[{"specName":"蓝色","unitPrice":5888},{"specName":"红色","unitPrice":6899}]}
```

二者之间的区别，可以理解为是对象和对象的toString打印的结果。上述两种形式分别称之为**json对象**以及**json字符串**。

**我们在数据传输过程中，使用的是json字符串**。



### JSON使用场景

今后在没有特殊说明的情况下，我们指的json都是指的是json字符串。

json的使用场景主要是用于前后端分离的场景下。主要是两个场景：

1.页面中用户输入的数据，需要以json字符串的形式提交给服务端，对应服务端来说，我们需要做的事情便是接收传递过来的json字符串，进一步将其转换成java对象，进行后续的处理





2.页面中需要的数据来自于后端，后端使用java语言来实现的，后端查询得到的java对象需要转换成json字符串，再次响应给客户端



### Java语言中操作json

```java
public class JsonTest {

    @Test
    public void test1(){
        Student1 student1 = new Student1();
        student1.setPassword("admin123");
        student1.setUsername("admin");

        //把student对象转换成json字符串
        //使用一些json校验网站校验json格式是否合理
        String jsonStr = "{\"username\":\"" + student1.getUsername() + "\",\"password\":\"" + student1.getPassword() + "\"}";
        System.out.println(jsonStr);
    }

    //自己进行json字符串和java对象的想换转换工作，其实非常的麻烦，可以使用一些专业化的工具来实现
    //常用的json解析类库：gson（google的json解析工具）、jackson（spring框架默认的json解析工具）、fastjson（alibaba的json解析工具）
    //将使用jackson来进行json字符串和java对象之间的相互转换工作

    @Test
    public void test2() throws JsonProcessingException {
        Student1 student1 = new Student1();
        student1.setPassword("admin123");
        student1.setUsername("admin");

        ObjectMapper objectMapper = new ObjectMapper();
        //可以把一个java对象转换成json字符串
        String s = objectMapper.writeValueAsString(student1);
        System.out.println(s);
    }

    @Test
    public void test3() throws JsonProcessingException {
        Student1 student1 = new Student1();
        student1.setPassword("admin123");
        student1.setUsername("admin");

        Student1 student2 = new Student1();
        student2.setPassword("admin12213");
        student2.setUsername("jjjjjj");


        //如果是List<Student>类型呢？
        List<Student1> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);

        ObjectMapper objectMapper = new ObjectMapper();
        //可以把一个java对象转换成json字符串
        // [{"username":"admin","password":"admin123"},{"username":"jjjjjj","password":"admin12213"}]
        String s = objectMapper.writeValueAsString(list);
        System.out.println(s);
    }

    //反方向：json字符串转换成java对象
    @Test
    public void test4() throws JsonProcessingException {
        String jsonStr = "{\"username\":\"admin\",\"password\":\"admin123\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        Student1 student1 = objectMapper.readValue(jsonStr, Student1.class);
        System.out.println(student1);
    }

    @Test
    public void test5() throws JsonProcessingException {
        String jsonStr = "[{\"username\":\"admin\",\"password\":\"admin123\"},{\"username\":\"jjjjjj\",\"password\":\"admin12213\"}]";
        ObjectMapper objectMapper = new ObjectMapper();
//        List list = objectMapper.readValue(jsonStr, List.class);
        //构建一个复杂的类型
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        //里面需要传递两个参数：构造一个集合的类型，集合用什么来充当，集合内部的元素是什么元素，也就是泛型的部分
        CollectionType collectionType = typeFactory.constructCollectionType(List.class, Student1.class);
        List<Student1> student1List = objectMapper.readValue(jsonStr, collectionType);
        for (Student1 student1 : student1List) {
            System.out.println(student1);
        }
    }
}
```



## MVC

是一个设计模式。编程经验的总结。如何编写代码，能够使得程序更加的稳健、更加的高效。

其实就是一个代码经验的总结。

先不去介绍MVC的概念，先去写一个案例：

要求大家去实现一个注册登录案例，最开始时，要求大家使用json文件来存储用户的数据；后续进行需求的变更切换，切换到使用数据库，大家需要思考一个问题，代码究竟应该如何设计，能够让程序业务切换时，所做的改动尽可能小。







