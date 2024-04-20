# Day7 Maven

## 概念

Maven是一个项目构建工具和依赖管理工具。

**项目构建**：项目构建指的是从编写代码开始，到后面的编译、测试、部署、运行等这一整套流程。

在我们的整个软件开发过程中，存在着各种各样的难题问题，比如编写代码之后需要进行编译，虽然使用一些专业化的集成开发环境，可以帮助我们进行编译，但是无法替代各个环节。比如打包部署等环节，比如我希望将代码打成jar包，idea打包不是特别的方便。还比如说编写好的代码需要进行测试，需要提前编写好测试用例，需要运行测试用例。这些环节其实都不是特别的省心。maven是一个非常好用的项目构建工具，**借助于maven，我们如果希望进行编译、测试、打包等，只需要输入一个对应的指令即可，非常的简单**。

> 如果面试的时候问到你，你的团队有多少人，多少比较合理？6-7人左右是比较合理的。
>
> 项目经理(1名)、产品经理(1名)、前端开发人员(1-2名)、后端开发人员(2-3名)、测试人员(1名)

**依赖管理**：依赖其实就是指的是我们引入的第三方的jar包、类库。我们希望在我们的项目中使用第三方的jar包、类库，那么必须得保障该jar包、类库会被加载到内存中。将jar包放入到classpath目录下，随后会有类加载器负责将jar包加载到内存中。

在之前的开发过程中，我们每创建一个项目，就需要复制一份jar包到当前项目中，执行add as library，将jar包添加到classpath目录中。其实，**我们根本没有必要每次都去复制一份jar包，我们其实只需要jar包的坐标位置即可，即可将其加载到内存中**。

**所以，其实对于我们开发的项目来说，根本没有必要每次都去新建一个新的项目，然后复制一份jar包过去，add as library。其实只需要将jar包统一放在一个位置，使用的时候，直接去提供该jar包的路径位置即可**。



![image-20240419163741853](assets/image-20240419163741853.png)

![image-20240419164113864](assets/image-20240419164113864.png)

此外，还有另外一点，那就是maven会自动帮助我们去管理依赖和依赖之间的关系。比如我们的项目中使用dbcp数据源，maven会自动帮助我们去查找dbcp jar包是否需要其他的依赖jar包，如果需要，则会将其他的jar包也加加载到内存中，这样便可以减少我们项目开发过程中，导包遇到的很多的坑。

> 需要明白一点：我们最终的目的就是要把jar包加载到内存中。该过程是由类加载器去做的，也就是说只要类加载可以知道当前jar包的位置路径，那么是可以将当前jar包加载到内存中。
>
> javac -classpath D:\apache-tomcat-8.5.81\lib\servlet-api.jar Servlet1.java
>
> 当前指令 -classpath属性其实背后就是调用了类加载器负责将后面地址的jar包加载到内存中



## 安装

software目录中有对应的安装包，直接下载到本地进行解压缩即可。不建议大家将软件放置在很深的目录结构下、不要放在含有空格的目录、中文的目录下。

> 如果今后大家在企业中进行开发，需要学习新的内容，如何去查找资料，去下载软件？官网
>
> 下载软件的时候，最新版慎用。



随后进行环境变量的配置



## 配置

Maven是一个项目构建工具以及依赖管理工具，可以帮助我们去维护管理jar包，究竟是如何维护的呢？

以下配置都是需要去修改conf/settings.xml文件

1.配置中央仓库的国内镜像

在mirrors节点下新增一个mirror节点

```xml
<mirror>
        	<id>nexus-aliyun</id>
        	<mirrorOf>central</mirrorOf>
        	<name>Nexus aliyun</name>
        	<url>http://maven.aliyun.com/nexus/content/groups/public</url>
        </mirror>
```

![image-20240420095758992](assets/image-20240420095758992.png)

2.配置本地仓库（其实可以不用配置，因为会默认选择一个位置，但是该位置默认是c盘，可以更换一下本地仓库的路径）

```xml
<localRepository>E:\repository</localRepository>
```

![image-20240420095646908](assets/image-20240420095646908.png)

3.配置profile信息----设置maven编译的默认版本信息(要求和大家使用的jdk版本保持一致)如果你使用的是jdk8，那么下面配置jdk8的配置；如果你使用的是jdk17，那么配置jdk17的。**一定记得要去配置，如果不去配置，maven的默认编译器是1.5的，可能很多特性都是无法处理的。**

jdk17:

```xml
 <profile>
                <id>jdk-17</id>
                <activation>
                    <activeByDefault>true</activeByDefault>
                    <jdk>17</jdk>
                </activation>
                <properties>
                    <maven.compiler.source>17</maven.compiler.source>
                    <maven.compiler.target>17</maven.compiler.target>
                    <maven.compiler.compilerVersion>17</maven.compiler.compilerVersion>
                </properties>
        </profile>
```



jdk8:

```xml
 <profile>
                <id>jdk-1.8</id>
                <activation>
                    <activeByDefault>true</activeByDefault>
                    <jdk>1.8</jdk>
                </activation>
                <properties>
                    <maven.compiler.source>1.8</maven.compiler.source>
                    <maven.compiler.target>1.8</maven.compiler.target>
                    <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
                </properties>
        </profile>
```





## 项目构建

1.新建一个目录，作为当前的项目。

2.在项目中，我们编写一个HelloWorld.java代码

```java
public class HelloWorld{

    public static void main(String[] args){
        System.out.println("hello world");
    }
}
```

随后，我们希望进行编译操作；如果没有maven，此时我们应该怎么办？使用javac指令来进行编译

如果借助于maven，我们应该怎么办呢？非常简单，直接输入一条指令即可。

3.如果希望使用maven来进行项目构建，那么需要创建一个pom.xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.cskaoyan</groupId>
    <artifactId>cp</artifactId>
    <version>1.0-SNAPSHOT</version>

</project>
```

4.maven项目中文件的存储有着严格的要求：

​	源代码文件放置在src\main\java目录下

​	配置文件放置在src\man\resources目录下

​	测试文件放置在src\test\java目录下

​	测试配置文件放置在src\test\resources目录下



### 常见指令

1.mvn compile

可以帮助我们进行编译操作。maven会帮助我们开发者将所有的源代码文件全部进行编译。







2.mvn clean

可以帮助我们将编译的产物全部删除，也就是删除target目录





3.mvn package

默认情况下，maven会帮助我们进行打jar包操作，如果我们希望打war包，可以在pom.xml文件中设置<packaging>war</packaging>





4.mvn test

maven还可以帮助我们开发者进行单元测试。如果希望maven帮助我们进行测试，那么需要满足如下几个要求：

1.导入junit依赖(该jar包专门用于进行单元测试的)。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.cskaoyan</groupId>
    <artifactId>helloworld</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

2.编写对应的代码去测试即可(测试类一般情况下命名叫做XXXTest,里面的方法一般叫做testXXX)

3.测试类的测试方法的头上需要标注@Test注解

```java
import org.junit.*;

public class StudentTest{

    @Test
    public void testAge(){
         Student student = new Student();
         Assert.assertEquals(18, student.age());
    }
}
```

一切代码准备就绪，编写完毕，运行mvn test指令，那么maven便会帮助我们运行所有标注@Test注解的方法。



## 依赖管理

在maven项目中，如果我们进行依赖管理，是不需要再次去导入jar包的。只需要在maven项目的pom.xml文件中去配置对应的依赖说明即可。

<dependencies></dependencies>表示的是所有的依赖。<dependency></dependency>指的是其中的某一个依赖。依赖有以下几个属性所组成，分别是groupId、artifactId、version

> groupId、artifactId、version不知道怎么写？不用去记，直接去mvnrepository.com去查看

groupId：指的是公司的名称、组织的名称



