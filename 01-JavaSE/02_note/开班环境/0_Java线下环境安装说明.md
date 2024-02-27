###### <sub><font color = orange>JAVASE基础教程</font></sub><br />——<br /><font color=white>附录</font><br/><sup><font color=cyan>Java线下环境安装文档</font></sup><br/><br/>`已最新版本|V7.0`<br/>**长风**<br/>*COPYRIGHT ⓒ 2021. 王道版权所有*

[TOC]

# 概述

> `>(green!)`
>
> **本文档是提供给参考王道培训，在教室上课，在线下学习的同学们使用的环境配置文档。**
>
> 请按照以下顺序和相应的说明完成操作，如有疑问，请及时提出。
>
> <font color=red>**注，本文档下所有软件皆可在百度云盘中找到： **</font>
>
> > 链接：https://pan.baidu.com/s/1_DFuwAr8QIj1KSB8LLtv8g?pwd=ivat
> > 提取码：ivat
> > （如果百度云盘链接失效，请及时联系老师补链接。）
>
> **刚到线下学习的同学都要先看一看文档，包括晚到的同学。完成本文档的线下环境配置，从而更好的进行学习！**



# 开发环境

> `>(green!)`
>
> 对于Java程序员而言，需要安装的环境并不少，但是对于Java新手来说，安装以下两个软件足够了：
>
> 1. JDK
> 2. IDEA

> `>(green!)`
>
> 安装所需的文件、以及说明请参考百度云共享中 **"开发环境"** 文件夹 ，更多的细节请参考本教程中的[Java开发环境基础配置](SE01/V1/02_Java开发环境基础配置.html?ws=none)文档。
>
> 在这里我只想强调的点就是，软件的版本问题：
>
> 1.  <span style=color:red;background:yellow>**JDK的版本必须是17.xxx（小版本不计）**</span> 
> 2.  <span style=color:red;background:yellow>**IDEA的版本推荐是2023.2.5！**</span> 

> `>(red!)`
>
> 注：使用Windows操作系统的同学，建议勾选打开系统文件的扩展名，操作如下图所示：
>
> <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202112191737701.png?align=center" alt="打开win系统的文件扩展名" style="zoom: 50%;" />
> 
>**勾选扩展名后更容易分辨文件，其次不勾选扩展名文件会有默认扩展名，有时会带来麻烦。勾选文件扩展名后，效果如下图：**
> 
><img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202201211255271.png?align=center" alt="文件扩展名" style="zoom: 67%;" />
> 
>如果是MacOS的同学，也建议你打开文件扩展后缀名，如果不知道如何打开，可以百度一下。
> 
>比如：[MacOS中如何开启文件扩展名-百度经验 (baidu.com)](https://jingyan.baidu.com/article/bea41d436088acf5c41be64b.html)

# 极域的安装

> `>(green!)`
>
> <span style=color:red;background:yellow>**这一步是需要来到线下并使用网线连接教室局域网的，如果自己笔记本没有网线接口，请购买扩展坞。**</span>
>
> **推荐使用如下较为简单的USB-A或者Type-C的网线转接器，最好不要购买带充电功能的多功能扩展坞。**
>
> <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202112191737491.jpeg?align=center" alt="扩展坞推荐" style="zoom: 33%;" />
>
> **注：如果你不知道该买什么样的扩展坞，建议就购买绿联的单口（上图UBS-A或者Type-C接口的）网线扩展坞。**

> `>(red!)`
>
> 教室的上课需要将教师的屏幕投到每位同学的计算机上，使用的软件是**极域**。
>
> 软件可以在**"百度云盘 - 教室环境 - 极域"**中找到，双击`student.exe`即可进行安装。 <font color=red>**该软件只有win版本，如果你是macOS操作系统，请安装win虚拟机，如果没有安装且不懂得如何安装，请先完成操作步骤3，共享服务器上有mac虚拟器的安装教程。**</font>
>
> **极域的安装过程没什么可说的，基本就是下一步，下一步即可完成，但是需要注意以下细节：**
>
> 1. 安装目录：最好不要装在C盘，自己选择一个独立的非系统盘目录。软件安装在C盘里除了占用本身就不富裕的系统盘空间外，一旦重装系统，软件就全部没了。
> 2. **卸载密码不要填，保持空着！卸载密码不要填，保持空着！卸载密码不要填，保持空着！**
> 3. 频道选择，先直接选择默认频道1，如果老师有特殊要求，可以根据老师的需求去改。
> 4. **极域如果提示进行版本更新，则无需理睬，点`否`即可。**
> 5. 安装完毕后，软件会要求你重启电脑。实测不重启电脑，直接双击桌面上的快捷方式一样可以，到底是否重启，可以根据自己的情况而定。

## 注意事项

> `>(green!)`
>
> **使用极域的一些注意事项：**
>
> 1. 如果电脑存在虚拟机，需要关闭虚拟机网卡，否则可能出现黑屏无法连接教师端的问题。
> 2. 同上一条，如果黑屏还可以考虑关闭Windows防火墙。
> 3. 以上都做完了还黑屏考虑重启一下计算机。
> 4. **最后，如果始终无法解决问题，无法连接教师端，请联系老师进行协助！**

## 极域的设置问题

> `>(green!)`
>
> 安装完极域后，可以点击自己操作系统（Windows）右下角任务栏托盘处，就能找到极域图标了。一般来说，极域的图标有两种状态：
>
> 1. 灰色表示未连接教师端需要等待连接。
> 2. 橘黄色即表示已经连接教师端。
>
> 右键单击托盘极域图标，选择进入设置界面。**如果你在安装极域的时候没有填卸载密码，那么就可以直接进入设置界面，而不需填入任何密码。**当然，如果不巧你设置了，那就需要输入卸载密码（所以不要设置卸载密码，完全没有必要）。
> 然后进入设置界面后，大家就可以查看到极域的设置内容，这里简要说明一下。
>
> 1. **极域的登录模式分为两种：**
>
>    1. 选择教师登录
>    2. 自动登录
>
>    它们的区别就和它们名字写的一样，默认选择自动登陆就可以了。具体选择何种登录模式，请按照老师的要求而定，可以在设置中修改登陆模式。
>
> 2. **网段的选择：**
>
>    参考下图可以选择绑定地址，即选择极域连接的局域网网段。<font color=red>**教室的局域网网段分配一般都是192.168.（个位数或1x）.xxx，网段最多是一个两位数，不可能是三位数。**</font> 而像下图这样的三位数的网段，一般都是虚拟机的网络网段。如果你在教室中操作，出现下图的情况，肯定是连不上教师端的，建议点击下拉框，将网段选择成个位数，即可成功连接。
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202111171049470.png?align=center" alt="极域-选择网段" style="zoom: 67%;" />
>
> 3. **从实际使用经验出发，如果偶尔出现极域无法连接的情况，可以考虑将极域的登陆模式在选择教师登录和自动登陆之间切换，或者考虑重启一下计算机，多数都能解决问题。**
>
> 4. 最后，如果你能正常看到老师的屏幕，并且（操作系统右下角时钟）时间对得上，没有超过1s的延迟，就表示能够正常使用极域了。
>

# 共享服务器

> `>(green!)`
>
> **共享服务器同样为局域网服务器，需要使用网线连接局域网，才能够使用。**日常的学习中，老师会上传代码，视频资料、作业等内容到共享服务器，同学们可以根据需要访问共享服务器下载，所以这一步是必须要完成的。
>
> 按照以下步骤进行：
>
> 1. 共享服务器的访问，首先需要安装软件连接，打开**"百度云 - 教室环境 - 共享服务器软件"**，根据操作系统选择：
>
>    1. WinSCP（Windows）
>    2. Transmit（MacOS）
>
> 2. 软件的安装直接下一步完成即可，软件完毕后开始按照如下步骤操作（以WinSCP为例，Mac大差不差）
>
>    1. 运行WinSCP，会出现让你选择登录的界面，点击**新建站点**，如下图：
>
>       <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202111171127815.png?align=center" alt="WinSCP-站点登陆" style="zoom:50%;" />
>
>    2. 需要输入以下参数
>       - **主机名：192.168.1.100**	
>       - **用户名：student**
>       - <span style=color:red;background:yellow>**密码(分两种情况)：**</span>
>         - 如果是2楼的班级，密码是：<font color=red>**wangdao**</font>
>         - 如果是4楼的班级，密码是：<font color=red>**W2a0n2g1dAO#Be@tToR$**</font>
>       - **密码的填写请直接复制粘贴，不要手打，对号入座，不要**
>       
>    3. **输入完毕后，选择保存，将站点保存下来，避免后面登陆还要输入**
>
>    4. WinSCP还可以将站点发送到桌面快捷方式，如果需要，可以自行摸索一下。
>
> 3. 登录进去后，它的界面就类似于操作系统的文件管理器，具有层级目录，参考下图：
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202111171149150.png?align=center" alt="服务器目录" style="zoom: 50%;" />
>
> 4. 对于Java班级来说，课程相关的内容请进入目录：**/wangdao/share/JAVA/（对应期数，比如28期就是28th）**
>
> ----
>
> 注：如果你是Mac，并且还没有安装虚拟机，可以进入目录：**/wangdao/share/JAVA/soft/macOS** 查找相应软件和文档说明。实测下来，Mac可以直连局域网共享服务目录，可以不需要安装Transmit软件，如果你不了解具体情况，可以询问老师。

winscp还没有下载的时候，可以使用这个命令先连接内网。

ftp://192.168.1.100/

# Typora的安装

> `>(green!)`
>
> Typora是时下最热门的文档标记语言Markdown的编辑器，可以较好的显示和编辑md文档。

> `>(green!)`
>
> [-] 关于Markdown语言
>
> > Markdown 是一种轻量级标记语言，它允许人们使用易读易写的纯文本格式编写文档。
> > Markdown 语言在 2004 由约翰·格鲁伯（英语：John Gruber）创建。
> > Markdown 编写的文档可以导出 HTML 、Word、图像、PDF、Epub 等多种格式的文档。
> > Markdown 编写的文档后缀为 .md, .markdown。
> >
> > 总之，md好，md妙，md呱呱叫。作为程序员，md文档已经逐渐有取代传统的Word的趋势，Markdown的语法十分简单，大概十分钟就能够学会，可以自行搜索学习一下。
> >
> > 比如参考：https://www.runoob.com/markdown/md-tutorial.html等等。
>
> <span style=color:red;background:yellow>**王道的绝大多数老师都会提供md格式的学习文档，具体根据老师的安排而定，但都推荐大家安装Typora软件。**</span>
>
> 记笔记用Typora也非常好用！！

> `>(green!)`
>
> 软件安装流程：
>
> 1. 打开**"百度云 - 教室环境 - 笔记软件"**，根据操作系统选择安装包，然后安装即可。
> 2. 软件的安装不再赘述，基本下一步下一步就行了。
>
> Typora是有很多插件提供安装的，这个大家可以自行摸索。这里仅推荐一个`自动添加段落编号`的插件：
>
> `typora-theme-auto-numbering`
>
> 放在**"百度云 - 教室环境 - 笔记软件"**目录下，大家可以自动去获取使用，使用说明请查看其中的`README.md`。

> `>(red!)`
>
> 特别提醒（2021/11/27更新）
>
> Typora经历了漫长（六年）的测试期后，终于迎来了1.0版本，同时这也意味着Typora将要开始收费了，价格是15美元，可以激活三台机器。
>
> 个人认为，软件收费是应该的，毕竟作者也是要恰饭的。但是Typora收费版本目前看来实在值不回票价，个人建议土豪随意，情怀党随意，平民玩家可以暂时不要升级1.0版本，而是继续使用最后一个免费版本：0.11.18。
>
> **我在百度云盘中提供的Typora版本即为最新的免费版本，如果你不想付费使用，请关闭Typora更新检查，并且不要升级软件！！**
>
> 最后一次更新（2022/08/02）
>
> <font color=red>**发现了一个问题：如果始终关闭更新，不更新，过一段时间Typora会打不开，要求强制更新，这时卸载软件并重新安装即可。**</font>
>
> 鉴于Typora强制更新的麻烦、一个忠实用户的热情以及它的收费确实不是很贵的种种情况，我已经花钱升级正式版了。
>
> 坦白说，没感觉有什么不同（笑
>
> <span style=color:red;background:yellow>**再一次更新（2022/12/29）**</span>
>
> 现在网上能找到的大部分Typora版本安装包都已经失效不能安装了，现在百度云盘里还有在网上找到的<font color=red>**破解安装包**</font>以及<font color=red>**正常安装后再破解**</font>的两个版本，建议大家优先考虑破解安装包。
>
> 最后还是建议大家凑三个人买一份Typora激活码，平均下来一个人30块钱永久激活，节假日有优惠还会更便宜。个人觉得Typora也值这个价格，况且破解版总归有失效的可能性，失效后再找破解比较麻烦。

# Git的使用

> `>(green!)`
>
> Git是项目开发中完成代码协同合作，进行版本控制的强大工具，是当下最主流的项目管理系统。
>
> **在我们学习的过程中，少不了需要查看和学习老师的代码，老师将代码上传到Git仓库后，大家就可以方便快捷的从仓库中拉取代码，这就是我们使用Git的目的。**
>
> 关于Git的详细使用，我们会在后续的项目阶段专门学习（将有一天课程专门学习Git），而目前仅需要简单的下载查看老师代码就可以了。按照下述流程走完，其它东西暂时不需要大家考虑了。

## Git下载

> `>(green!)`
>
> 打开百度云盘，找到目录**Git**，然后根据操作系统选择安装包。当然你也可以去[Git官网](https://git-scm.com)自行下载。

## Git安装

> `>(green!)`
>
> 安装的过程整体上还是next-->next，注意以下细节：
>
> 1. 建议不要装C盘，路径名不要带中文，不要有空格**（一定要记住自己的安装目录，接下来有用）**
>
> 2. 不需要弄明白每一步设置的含义，直接默认下一步就可以了，后期这些设置都是可以修改的。如果想要弄明白每个步骤的含义，可以参阅[详解Git安装过程-博客园](https://www.cnblogs.com/xueweisuoyong/archive/2019/11/22/11914045.html)，这篇博文中有详细的说明。
>
> 3. Git安装完毕后，可以在桌面上右键菜单，如下图所示即为成功：
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202112191743089.png?align=center" alt="Git安装成功标志" style="zoom: 50%;" />
>
> 4. 如果是Mac的同学，可以打开终端，并输入`git --version` 指令，如果能够正确显示Git的版本号，就说明安装成功了。

## Git指令

> `>(green!)`
>
> 严格来说，Git的使用需要学习Git指令，但这本身并不是一件容易的事情，而且鉴于我们目前不需要指令也能正常使用Git，所以在这里就不增加同学们的学习负担了。后期我们在专门的章节中，会详细学习Git的指令。当然如果你很闲，实在想学习，可以参考网络博客，自行学习。（随便百度一下很多）

## Gitee的使用（选做）

> `>(green!)`
>
> Git本身只是一种技术，一个软件或者一个工具，真正存放和协同开发代码还需要一个**仓库**。
>
> [-] 关于Git仓库
>
> > 最著名的基于Git实现的在线代码托管仓库是**GitHub**，在相当长的一段时间里GitHub都是国内程序员最常用的代码仓库。但是近些年来，受限于网络的影响，越来越多的程序员开始转移到国内的同类型仓库**Gitee（码云）**，在王道几个月的学习中，我们就以Gitee作为我们的代码仓库。
> >
> > **额外补充：**
> >
> > 选择什么仓库，都不会影响Git的使用，毕竟核心是产品，是代码。像GitHub、Gitee之类是属于典型的公网仓库，实际开发中多数公司都会部署自己的局域网（内网）仓库，这种内网仓库一般称之为**"私服"**。常见的私服仓库有：Gitlab、Greeit等。它们本质上都是一个东西，核心功能是一样的。
>
> <span style=color:red;background:yellow>**如果仅仅在IDEA查看老师代码，这一步是可以跳过的。**</span>当然后续大家使用Git，必然是需要仓库的，像码云或者GitHub账号，大家都可以注册一下。
>
> 接下来按照以下步骤操作即可。

### 注册Gitee（选做）

> `>(green!)`
>
> 1. 进入[Gitee的官网](https://www.gitee.com/)，然后点击首页右上角的注册，如下图所示。**当然如果你已经有账号，可以直接登录~**
>
> <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202112191743240.png?align=center" alt="Gitee注册" style="zoom: 33%;" />
>
> 2. 码云注册时建议使用邮箱，使用手机号注册也行，但是后续要在个人设置中补充邮箱。同样的，使用邮箱注册也可以后续补充手机号，所以两种方式注册都一样。
>
> **注：注册时，要记住你的用户名、邮箱和密码，这些后面需要使用。注册好后，可以登录进去，在个人设置里补充完个人资料。**

### 本地配置Gitee（选做）

> `>(green!)`
>
> 接下来就需要在本地配置Gitee仓库信息：
>
> 1. 在桌面上右键，选择 **Git Bash Here** 打开Git操作的命令行（Mac的同学直接打开自己的**终端**即可），如下图所示：
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202112191743571.png?align=center" alt="Git终端页面" style="zoom: 50%;" />
>
> 2. 分别输入以下指令：
>
>    1. git config --global user.name "用户名"
>    2. git config --global user.email "邮箱"
>
>    注：
>
>    1. 用户名和邮箱即**注册Gitee**时填入的用户名和邮箱。
>    2. 指令建议不要自己手打。直接复制，然后在Git窗口中右键 “**Paste**” 粘贴，修改用户名和邮箱即可。
>    3. **双引号要使用英文的双引号**，使用中文的双引号会导致失败
>
>    如下图：
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202112191743443.png?align=center" alt="本地配置Gitee" style="zoom: 50%;" />
>
> 3. 设置完成后，如上图所示所示没有报错信息，即为设置成功。也可以再输入指令`git config --list` 查看配置信息，检查是否配置成功。如下图：
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202112191743281.png?align=center" alt="Git配置信息列表" style="zoom: 50%;" />
>
> **注意事项：**
>
> 1. 如果检查发现配置没有成功，可以检查一下指令拼写，英文字符等，然后再配置一次，直至完成。
> 2. 关于Gitee的配置，更详尽的可以查看[Git配置官网文档](https://gitee.com/help)，感兴趣的可以看一下。
>
> ---
>
> **以上就完成了Gitee本地配置仓库，下一步进行IDEA的配置。**

## IDEA配置Git

> `>(green!)`
>
> IDEA里面一样也需要配置Git，这里以2018.3版本的IDEA做示范，其它版本设置大同小异。
>
> 1. 打开IDEA，使用快捷键 **alt + ctrl + s** 或者 左上角 **File → Settings** 打开IDEA的设置。
>
> 2. 按照下图，在选项页**Version Control -> Git** 中找到 **Path to Git executable** 选项框，并选择Git安装目录下的`bin`文件夹下的可执行**git.exe**文件，随后Test。如果你选择的是正确的可执行文件，会弹出选项框 successfully 和Git版本号，这样就配置完毕了。
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202112191743389.png?align=center" alt="IDEA配置Git" style="zoom: 33%;" />
>
> 注：如果是Mac同学，这一步的操作也是类似的，也是需要选择Git执行程序。
>
> ---
>
> **以上所有的配置完毕，就可以开始使用IDEA拉取老师代码查看了~**

## 拉取老师代码

> `>(green!)`
>
> 目前所有阶段的老师的代码已经合并到一个仓库了，具体的仓库地址会由第一任上课的老师发出，请及时关注。
>
> <span style=color:red;background:yellow>**当然，Gitee仓库地址也会直接放在相关文档首页（每一期会有所不同），大家自取。**</span>
> 
> 仓库地址有什么用呢？请按照下述步骤进行操作：
>
> 1. 打开IDEA（以2018.3版本为例）
>
> 2. 左上角选择**File → New → Project from Version Control → Git**
> 
> 3. 按照下图，将仓库地址直接复制粘贴进URL选项框，Directory是存放文件的地址，建议选择专门的位置存放它。
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202202272212657.png?align=center" alt="Git拉取代码" style="zoom:80%;" />
>
>    **注：不要按照图片敲URL地址，请复制上面的地址。自己把`XX`修改为自己的班级期数。**
>
> 4. 这样，你就成功拉取了老师的代码仓库，可以随时查看和更新老师的代码了。

### 日常使用

> `>(red!)`
>
> 注：
>
> <span style=color:red;background:yellow>**拉取老师代码，仅需要IDEA配置Git就可以了，无需使用Gitee！！**</span>

#### 日常拉取老师代码

> `>(green!)`
>
> 按照上述步骤走完后，拉取下来代码仓库如下图所示：
>
> <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202209251648810.png?align=center&padding=true" alt="IDEA代码仓库界面" style="zoom:33%;" />
>
> 日常使用过程中，大家仅需要注意和使用两个地方，即图中标号1和2的位置。其它地方建议不了解不要乱动~
>
> 1. **一个蓝色的向下的箭头**。这表示从远端Git仓库拉取**（Pull）**同步最新的代码。每当老师在远程仓库更新了代码，都可以通过该按钮同步代码进行查看。
> 2. **仓库的主体Project和Module区域**。其中**java36th**是一个project，下面都是一个个module，比如**0-test**，它就是一个module。

#### 运行Git代码

> `>(green!)`
>
> 如果你是第一次用Git拉取老师代码，那么是无法直接运行的（IDEA版本2023.2），打开一个Java文件，大概会看到下图：
>
> <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202209251649478.png?align=center&padding=true" alt="运行Git代码图1" style="zoom: 33%;" />
>
> 请按照以下步骤进行操作：
>
> 1. 根据文件右上角的提示<font color=red>**（如果有的话）**</font>，点击setup SDK,然后选择JDK8的版本（或者指向JDK8的安装目录）
>
>    **注：这一步可能有些同学不需要做。**
>
> 2. 然后按住快捷键<font color=red>**ctrl + alt + shift + s **</font>或者左上角 File --> Project Structure
>    如此操作，就可以进入project结构设置，下面的操作都是在该页面下进行的：
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202209251648630.png?align=center&padding=true" alt="运行Git代码图2" style="zoom: 40%;" />
>
> 3. 首先设置选项卡project页面（也就是上图中的页面），执行以下几个步骤：
>
>    1. 设置Project SDK为Java17（选择JDK目录即可）
>
>    2. 将Project Language Level设置为17
>
>    3. <font color=red>**Project compiler output**</font>指的是“project编译器输出（文件）目录”，Java文件必须编程成class文件才能够执行Java程序，这个目录就是用来存放class文件的输出目录。
>
>       如果该目录像上图一样是空的，那就必须手动指定它的目录。
>
>       <span style=color:red;background:yellow>**一般来说，建议将这个目录设置为：当前工程目录/out**</span>
>
>       比如当前工程目录为 E:/idea_space/45/Java45th
>
>       那么out目录可以设置为 E:/idea_space/45th/Java45th/out
>
>    **如此，完成Project选项页的设置，这一步是project的基本设置，必须要完成。**
>
> 4. 接下来设置module选项卡页面，如下图：
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202209251649008.png?align=center&padding=true" alt="运行Git代码图3" style="zoom:40%;" />
>
>    版本号为 2023.2.5 的IDEA在拉取Git工程时，不会自动识别module，而是会将module直接作为一个文件夹处理，这样其中的代码是无法运行的，如果想要正常运行代码，需要手动添加module。
>
>    例如上图中的“0-test”、“1-basic”等，它们目前都是当成文件夹处理的，还不是一个module，需要手动添加成module。
>
>    **注：20年以后的IDEA会自动识别Git工程中的module，可以不需要设置这一步。**
>
>    具体来说步骤是：
>
>    1. 点击页面中间位置的“+”加号，选择选项中<font color=red>**Import Module**</font>
>
>       （Module已存在，只是不能识别而已，所以直接导入即可，不要点击New Module）
>
>    2. 找到想要导入module，在硬盘中的位置。
>
>       比如0-test这个module位于硬盘位置：“E:\idea_space\45th\Java45th\0-test”
>
>       直接选择module文件夹，选择OK
>
>    3. 在随后弹出的窗口中直接next到底，最后选择OK关闭设置。
>
>       注：如果出现<font color=red>**override（覆盖）**</font>提示，说明选错了module文件夹，再仔细看一下目录。
>
>    4. 如此，完成Modules选项页的设置，这一步可以自行选择想要运行代码的module进行import
>
> 5. 以上步骤完成后，这时，Git拉取的代码就可以启动运行了，可以自行测试一下。
>
> 如果你按照文档操作Git工程，碰到了任何问题，请直接私聊老师解决。<span style=color:red;background:yellow>**当然，老师也会在课堂上给大家演示如何使用Git拉取老师代码运行，课堂上认真听一下吧。**</span>

#### 可能会碰到的问题

> `>(green!)`
>
> 坦白来说，Git的使用即便到了工作中，也会经常碰到一些疑难杂症。
>
> 我们今天使用Git，只是最简单的、最基本的使用，所以碰到一些问题再所难免，这里简单说几个最常见的问题。

> `>(red!)`
>
> <span style=color:red;background:yellow>**问题一：拉取老师代码（Pull）失败**</span>
>
> Pull失败的原因有很多，但对于大家来说，最常见的可能是：
>
> <font color=red>**你在本地对老师的代码进行了修改， 在Pull拉取代码时，出现了远端仓库代码和本地代码冲突的情况。**</font>
>
> 当远端仓库代码和本地代码不一致时，Git在同步更新代码时就会有两种选择，从而出现矛盾：
>
> 1. **选择一：覆盖掉这段不同的代码，使用远端仓库代码**
> 2. **选择二：直接使用本地代码，不管远端仓库代码**
>
> 出现这种需要选择的情况，程序自身是不能做出选择的，需要使用者做出抉择。
>
> 对于这样的一个问题，我给出的建议是：
>
> 1. 最好还是避免出现这样的冲突问题，<font color=red>**建议将老师代码仓库中代码，当作是只读的，不要修改老师代码仓库中的代码。**</font>这样就不会有冲突的问题。如果想写自己的代码，可以新建一个Project去写。
> 2. 如果确实已经出现了冲突，也可以选择解决冲突，只需要告诉Git使用本地代码还是远程仓库代码。**具体来说，就是在merge（合并）代码时，指出接受你的修改（accept yours）或者同步老师覆盖掉修改（accept theirs）。**

> `>(red!)`
>
> <span style=color:red;background:yellow>**问题二：Git工程结构混乱，几乎不能正常使用。**</span>
>
> 很多同学在初次接触IDEA，接触Git工程时，会因为不熟悉操作或者偶然的一些无意识操作，将整个IDEA、Project搞乱，这时我的建议是：
>
> <font color=red>**一律建议从头再来！重新拉取代码，或者新建Project，必要时可以卸载重装IDEA！**</font>
>
> <font color=red>**一律建议从头再来！重新拉取代码，或者新建Project，必要时可以卸载重装IDEA！**</font>
>
> <font color=red>**一律建议从头再来！重新拉取代码，或者新建Project，必要时可以卸载重装IDEA！**</font>
>
> 重启、重装、重头再来，是开发中解决问题的首要方式，也是有效方式之一。

# Windows登录名修改

> `>(green!)`
>
> 为了更好检查同学们的考勤，监督同学们的学习：
>
> <span style=color:red;background:yellow>**请同学们修改自己的win10/11登录用户名为自己的（真实）名字的拼音。如果是Mac的同学，请在Windows虚拟机中进行该操作。**</span>
>
> <font color=red>**可以尝试以下两种方式，如果都不行，可以直接找老师解决。**</font>

## 方式一

> `>(red!)`
>
> 优先尝试方式一，具体的过程如下：
>
> 1. 打开运行（按快捷键win + R），输入指令`netplwiz`后回车。打开后界面如下：
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202206301055641.png?align=center" alt="修改登录名-方式一" style="zoom:50%;" />
>
>    注：一般打开这个选项卡，都只有一个登录名。如果有多个，选择自己使用的用户名，一般**组是Administrator的**就是。
>
> 2. 双击用户名后，将新选项框里的<span style=color:red;background:yellow>**全名和用户名**</span>都修改成自己的真实名字的拼音即可！如下：
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202206301114554.png?align=center" alt="修改登录名-方式一2" style="zoom:50%;" />
>
>    注：登录名不是计算机名，使用拼音是没问题的，不用担心影响电脑使用。
>
> 3. 重启电脑，看到登录名变成了自己的名字，就是成功了。

## 方式二

> `>(red!)`
>
> 一般来说，方式一能够应付几乎所有的win10版本，如果不行，请尝试以下方式二：
>
> 1. 打开运行（按快捷键win + R），输入指令`lusrmgr.msc`后回车。打开后界面如下：
>
>    <img src="https://hixiaodong123.oss-cn-hangzhou.aliyuncs.com/typora/202201211535675.png?align=center" alt="本地用户组" style="zoom:50%;" />
>
>    注：
>
>    怎么知道当前登陆用户是哪个呢？只需要注销当前计算机，然后查看登录名就可以了。
>
>    一般情况下，家庭版用户默认就是使用`Administrator`登陆的。
>
> 2. <span style=color:red;background:yellow>**同样双击，将登陆的全名以及名称，修改成自己的名字即可。**</span>
>
> 3. 重启电脑，看到登录名变成了自己的名字，就是成功了。

> `>(red!)`
>
> **以上，就完成了所有的配置，感谢大家的配合，祝大家学习愉快！**

# 作业的提交

> `>(green!)`
>
> 我们每天都会有作业，关于作业的提交主要依赖学生管理系统，偶尔也会用一用Git，具体事项参考文档：
>
> [作业的提交](Java线上环境安装说明.html?ws=none&cf=off#提交作业管理系统方式）)
>
> 有问题可直接问老师。

# <sup>The End </sup><br /><br / ><sub>如有发现错误，欢迎联系老师更新！</sub>
