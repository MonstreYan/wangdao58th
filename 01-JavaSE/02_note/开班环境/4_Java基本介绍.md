[TOC]

# 初识Java

## Java语言的应用领域

- Web应用(Java EE方向)
- 大数据
- Android
- 桌面应用
- 游戏



**Web应用**

Web应用程序，顾名思义是一种可以通过Web（互联网）访问的应用程序。

Web应用具备以下特点：

1. 普遍采用B/S架构实现(Browser/Server)，用户只需要有浏览器即可访问使用，不需要再安装其他软件。
2. Web应用当然也可以采用C/S(Client/Server)架构实现。
3. 但不管采用何种架构实现，都需要连接互联网才能使用，能够脱机使用的应用程序不是Web应用。

我们日常生活中使用的大多数应用程序都是Web应用，比如各种管理系统，淘宝京东电商系统, 金融, 医疗等。Web应用通过浏览器访问，必然需要服务端作出响应，而 Java是当前最常见、最主流的服务器端语言 ，使用Java做服务器端最大的优点是稳定，开发效率也很高（依赖于Java成熟的类库和框架体系）

**当然，目前Java最主流的用途也是作为服务器端开发语言。**



**大数据**

大数据开发也是Java开发的另一个方向, 主要从事数据处理的工作, 数据采集, 数据清洗, 数据分析等工作. 基于Hadoop提供的分布式计算框架，可以用来统计和分析海量数据, 应用与金融风控、实时推荐等.



**Android**

在安卓刚问世并流行的早期，使用Java进行安卓开发十分流行，并且工资相当可观。但如今来看，用Java做安卓开发早已式微，越来越少人使用Java开发Android，相关的工作岗位非常少。

主要有以下原因：

1. Google和Oracle公司有一定的纠纷，导致Google不愿意再在安卓中使用Java语言。
2. 原生的安卓意味着公司还需要针对iOS等其它平台开发软件，增加成本，开发效率低。现在企业都倾向于使用使用Vue，H5这种可跨平台的开发语言。

最后，可以了解一下的是，现在安卓开发使用一种类Java的语言的**Kotlin** 语言，它是JetBrains公司开发的（也就是开发IDEA的公司）



**桌面应用**

狭义的桌面应用可以看成基于C/S架构的具有 GUI （图形用户界面）的定制软件，一般都是指PC端的桌面应用程序，不需要浏览器运行，而是直接运行在桌面操作系统上的应用，这意味桌面应用一般都可以单机使用，当然联网功能也完全可以具备。

Java也是可以做桌面级应用开发的，但普遍来说，桌面应用开发是C/C++的天下。

这是因为操作系统底层多是C语言开发的，使用C语言开发相关应用程序，实现功能可能会更加方便快捷，软件性能也会更加优越。

Java在某些特殊情况下会有一些用武之地，比如开发一个需要频繁和Java语言交互的应用程序，但绝大多数情况下，用Java都不是一个好的选择。

我们的开发工具IDEA就是依赖Java语言编写的



**游戏**

早在诺基亚, 摩托罗拉流行的年代, 还没有智能手机, 塞班系统非常普及, 搭载在塞班系统上的很多游戏都是Java开发的.

后来随着智能手机的普及, Java淡出游戏的舞台, 比较知名的一款游戏就是 我的世界, 是Java开发的.



综上, Java的主流还是Web应用的开发



## JDK与JRE

> **JRE（Java  Runtime Environment）**：全称Java运行时环境。

1. JRE包括Java虚拟机、运行时核心类库等Java程序运行时必备的环境。
2. JRE主要是给已经编写好的Java程序使用，也就是说操作系统中想要运行Java程序，必须要有JRE。

> **JDK（Java Development Kit）**：Java开发者工具包

1. JDK包含JRE。
2. 除了JRE外，JDK还提供了Java开发者需要使用的工具，比如javac.exe，java.exe（Windows）

JDK = JVM + 核心类库 + 开发工具包 

大部分企业中使用的是JDK8.



我们上课使用的是JDK17。JDK版本改动不大。没有JRE

## JDK使用

- JDK下载
- JDK配置

### 下载安装

<span style=color:red;background:yellow>**JDK的版本选择，大版本必须是17，小版本可以忽略不计。**</span>

JDK下载地址：

1. 官网下载

   > 下载地址：[Oracle官网下载JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
   >
   > 根据操作系统选择版本后，找到**Java17**进行下载，不要下载最新的JDK版本。

2. 百度云下载

   官网下载必须要注册Oracle账号（可能还需要科学手段），如果你不想注册可以选择百度云下载

   > 百度云下载：
   >
   > 链接：https://pan.baidu.com/s/1TUYom9Tvl6DaLRs0AvzS3g?pwd=h6uj 
   >提取码：h6uj 
   
3. 将安装包下载下来后，双击安装即可，安装过程直接全程 <font color=red>**下一步**</font> 即可。

稍微需要注意的是：

1. 不建议将JDK直接装在C盘，建议单独在其它磁盘找一个文件夹放开发相关的软件。

   > （这样开发环境不会因为重装系统而丢失）

2. JDK的安装目录<font color=red>**不要带中文，不要有空格**</font>，这有时候会造成一些奇怪的问题。

3. <span style=color:red;background:yellow>**一台计算机可以同时安装多个不同版本的JDK，在开发工具IDEA中可以选择使用的版本。**</span>

   > 当然我们在开发中仅会使用Java 17，没有必要装多个版本的JDK。

有的企业使用的是JDK8。有一些企业使用的是17，变动不大。

### 配置

**这里以Windows操作系统为例，如果是MacOS，可以自行百度配置一下，大体的思路是一样的。**

1. 首先，打开JDK的安装目录，然后复制当前的路径，D:\develop\Java\jdk-17.0.9

   ![image-20231226112127600](img/image-20231226112127600.png)

2. 然后右键**我的电脑-属性**，找到**高级系统设置**：

   如下图所示：                                                                                                                                                                                                                                   

<img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202202241358552.png?align=center" alt="配置JDK-2" style="zoom:50%;" />

3. 在上述弹出的窗口中，点击**高级 -> 环境变量**，如下图：

<img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202202241358421.png?align=center" alt="配置JDK-3" style="zoom:50%;" />

4. 在下面<font color=red>**系统变量**</font>的窗口当中，选择<font color=red>**新建**</font>一个变量，如下图所示：

   <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202212281434601.png?align=center&padding=true" alt="配置JDK-4" style="zoom:33%;" />

   变量名请固定写成：<font color=red>**JAVA_HOME**</font>

   变量值必须写出：<span style=color:red;background:yellow>**JDK安装目录的根目录**</span>，注意是根目录，就是刚才复制的那个目录

4. 在下面<font color=red>**系统变量**</font>的窗口中下拉，选择Path（不是上面用户变量中的Path），然后点击**编辑**按钮，如下图：

<img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202202241358854.png?align=center" alt="配置JDK-5" style="zoom:50%;" />

5. 在打开的窗口中，点击**新建**按钮，选择新建的值为<font color=red>**%JAVA_HOME%\bin**</font>，如下图：                                                                                               

<img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202202241358171.png?align=center" alt="配置JDK-6" style="zoom:50%;" />

最后，将上述打开的窗口全部点击 **确定** 即可。

以上，就完成了JDK的配置，接下来我们可以简单测试一下：

1. 打开命令行工具（**win + R输入cmd**），输入命令`java -version`，输出结果如下图：

![image-20231201203628915](img/image-20231201203628915.png)

2. 输入命令 `javac`，输出结果如下图：

<img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202110152151566.png?align=center" alt="cmd测试jdk配置-2" style="zoom:50%;" />

3. 还可以输入`java`、`java -help`等命令，发现有输出结果就可以断定配置成功了

<font color=red>**需要注意的是：**</font>

**有些机器在 C盘 目录下，操作指令可能无法正常显示结果，如果是这样，只需要换一个非C盘的目录就可以了。**



## 第一个Java程序

对于学习任何编程语言来说，业界有一个共识就是：

以实现在控制台打印**“Hello World！”**作为第一个入门程序。现在我们就来实现它，这也将是你的第一个Java程序。

这里给一个友情提示：如果你想尝试手动创建java文件并编译执行，请一定要打开操作系统中文件后缀名的显示！ 请打开文件资源管理器，进行如下图操作：

<img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202111051541168.png?align=center" alt="文件扩展名勾选" style="zoom:33%;" />

接下来按照下述步骤完成：

1. 首先，新建一个 **txt** 文本文件，起名字为 **HelloWorld.java** ，这时会提示**修改扩展名**点击确认即可。

   然后在打开的文本编辑框中写Java代码，如下：

   ``` java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello World");
       }
   }
   ```

   目前来说，我们可以把上述程序作为我们写Java代码的一个标准范式，即：

   1. 首先定义一个public修饰的class，**并且该class必须要和文件名同名**！
   2. 然后写main方法（格式固定，直接抄写即可）
   3. 最后在main方法中写要执行的代码。

   需要明确的是： main方法是Java程序的入口方法，任何要想被执行的代码要么直接写在main方法当中，要么就间接被main方法去调用执行！

2. 然后打开cmd命令行窗口，进入这个Java文件存放的目录（相关操作需要使用dos指令，自行百度）

3. 使用 `javac` 指令编译java文件（源代码文件），得到class文件（字节码文件）

4. 使用 `java` 指令解释执行class文件（字节码文件）即可得到结果

运行 `javac` 命令后，如果成功编译没有错误的话，会出现一个 HelloWorld.class 的文件，如果语法有错误，会给出相关的错误原因。`java`指令后面跟着的是java文件中的类名（而不是文件名）例如 HelloWorld 就是类名，直接` java HelloWorld ` 即可。

**动态Gif演示：**

<img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/helloworld.gif?align=center" alt="helloworld演示案例" style="zoom: 50%;" />



## Java程序的运行机制

第一个Java程序的运行过程如下:

<img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202201221444742.jpeg?align=center" alt="Java程序运行原理"  />

Java源代码总是要经过**编译**，得到class字节码文件，然后字节码文件在Java虚拟机中**解释**执行, 这就是Java程序的基本运行原理, 

**Java语言的跨平台性**

程序是由虚拟机(JVM)解释执行的, 并不是操作系统, 这样做的好处就是可以实现Java程序的跨平台运行(Write Once，Run Anywhere！), 也就是说, 在不同的操作系统上, 可以运行相同的Java程序, 只需要安装不同版本的Java虚拟机即可.

<img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202110152154187.jpg?align=center" alt="Java的跨平台性" style="zoom: 67%;" />

**Q:**

- Java可以跨平台吗?
  - 可以
- JVM可以跨平台吗?
  - 不可以