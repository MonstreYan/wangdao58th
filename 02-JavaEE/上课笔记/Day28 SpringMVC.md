

# Day28 SpringMVC

## 概念

Spring是用于处理什么组件的框架？？？是不是Service？？？不是Service。Spring主要做的事情是去搭建一个框架的平台。无论各种框架类库，都可以运行在Spring体系内。

在前面的课程中，我们将三层架构中的功能模块的serivce组件以及mapper组件放入到spring容器中了，肯定希望将controller也放入到spring容器中。数据共享会非常方便。

针对展示层，也就是处理controller部分，spring提供的一个框架叫做SpringMVC。

SpringMVC有什么功能，为什么要去学习SpringMVC？项目一java web项目开发过程中的痛点

1.请求参数的接收过程中，比较繁琐，如果是json字符串，那么需要我们开发人员自行去解析处理

2.响应也不是特别的方便，尤其是结合着之前学习的Spring中的AOP之后，发现可以进行很大的优化(response.getWriter().println(new ObjectMapper.writeValueAsString(obj)));-----完全可以使用切面来实现

3.请求参数校验过程中也比较的繁琐。需要判断是否为空，需要判断是否是整数等。

4.项目一的controller中的doGet或者doPost中，都有分发的代码，着实有一些繁琐。

5.借助于SpringMVC框架，其实可以和其他的位于Spring容器中的组件共享spring容器的功能。





## SpringMVC入门案例(熟悉)

入门案例使用xml文件配置的方式，熟悉即可，后续主要使用配置类。

1.导入依赖



2.改造成java ee项目，pom.xml文件设置<packaging>war</packaging>,在src\main目录下新建webapp目录；

open module settings----选择+号，根据提示创建对应的web.xml文件

设置完之后，在webapp/WEB-INF目录下会有一个web.xml文件

![image-20240515103752870](assets/image-20240515103752870.png)



3.在web.xml文件中进行如下的配置：

配置了一个serlvet的url-pattern为/，所以其是一个缺省Servlet，如果当前web项目中只有这一个serlvet的话，那么所有的请求都会交给当前serlvet来进行处理。

其中init-param定义了一组键值对的初始化参数，后续DispatcherServlet启动之后会读取该初始化参数，这组参数实际上是配置了配置文件的存放位置位于classpath目录下的application.xml

```xml
<servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:application.xml</param-value>
        </init-param>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```



4.需要在resources目录下新建一个application.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!--开启对于web项目的支持，主要就是初始化组件，用于去处理web请求-->
    <mvc:annotation-driven/>

    <!--设定扫描的包目录-->
    <context:component-scan base-package="com.cskaoyan"/>

</beans>
```



5编写Controller即可

需要特别注意的是：controller不需要去继承HttpSerlvet；

```java
@Controller
public class HelloController {

    //希望当前请求方法时，可以返回一个json字符串
    //实现请求和方法的映射
    @RequestMapping("/hello")
    //返回一个json字符串
    @ResponseBody
    public Object hello(){

        Result ok = new Result(200, "OK", null);

        //之前在项目一种返回一个json字符串非常麻烦；需要把对象转换成json字符串；需要利用response放置在响应体中
        return ok;
    }
}
```

最后配置一个tomcat来部署当前的应用即可。

http://localhost:8080/{应用名}/hello



## SpringMVC执行原理(掌握)

在浏览器地址栏输入http://localhost:8080/app/hello时，处理过程如何？？？？

当请求到达应用之后，有效的路径部分为/hello，这个请求有没有servlet可以处理？？？只能够交给缺省Servlet来进行处理。而我们的项目中有配置一个新的缺省Serlvet，叫做DispatcherServlet。

**所以请求会交给当前DispatcherServlet.service(req,resp)来进行处理。经过一系列的调用之后，最终会调用DispatcherSerlvet.doDispatch(request,response)方法。这个也是DispatcherServlet处理业务逻辑的核心。**

进入到doDispatch方法中之后，会根据当前的请求资源路径，查找有没有对应的handle方法可以匹配当前的请求，确定应该由哪个handle方法来处理这个请求；最终利用反射去调用对应的handle方法。

> 在很多的框架里面，如果看到了doXXX方法，那么这些方法才是真正干活的方法。

![image-20240515113802236](assets/image-20240515113802236.png)

![image-20240515111849965](assets/image-20240515111849965.png)

> DispatcherServlet.service(req,resp)程序执行入口：
>
> ```java
> public void service(ServletRequest req, ServletResponse res)
>         throws ServletException, IOException
>     {
>         HttpServletRequest  request;
>         HttpServletResponse response;
>         
>         if (!(req instanceof HttpServletRequest &&
>                 res instanceof HttpServletResponse)) {
>             throw new ServletException("non-HTTP request or response");
>         }
> 
>         request = (HttpServletRequest) req;
>         response = (HttpServletResponse) res;
> 		//关注这一行代码，分析的时候应该分析的是DispatcherServlet.serivce(request,response)注意此时的参数是HttpServletRequest和HttpServletResponse
>     //后续分析的时候，需要注意：在HttpServlet之后的子类中有没有对service(request,response)进行过重写
>         service(request, response);
>     }
> ```
>
> FrameServlet.service:
>
> ```java
> protected void service(HttpServletRequest request, HttpServletResponse response)
> 			throws ServletException, IOException {
> 		//解析出请求方法
> 		HttpMethod httpMethod = HttpMethod.resolve(request.getMethod());
> 		if (httpMethod == HttpMethod.PATCH || httpMethod == null) {
> 			processRequest(request, response);
> 		}
> 		else {
>             //我们使用的get和post会走到这
> 			super.service(request, response);
> 		}
> 	}
> ```
>
> HttpServlet.service(request,response):这里面的逻辑就是根据请求方法的不同，进入到不同的doXXX方法中。
>
> 但是此时我们分析的是DispatcherSerlvet，所以需要查看当前serlvet中有没有重写doGet或者doPost
>
> ```java
> protected void service(HttpServletRequest req, HttpServletResponse resp)
>         throws ServletException, IOException
>     {
>         String method = req.getMethod();
> 
>         if (method.equals(METHOD_GET)) {
>             long lastModified = getLastModified(req);
>             if (lastModified == -1) {
>                 // servlet doesn't support if-modified-since, no reason
>                 // to go through further expensive logic
>                 doGet(req, resp);
>             } else {
>                 long ifModifiedSince = req.getDateHeader(HEADER_IFMODSINCE);
>                 if (ifModifiedSince < lastModified) {
>                     // If the servlet mod time is later, call doGet()
>                     // Round down to the nearest second for a proper compare
>                     // A ifModifiedSince of -1 will always be less
>                     maybeSetLastModified(resp, lastModified);
>                     doGet(req, resp);
>                 } else {
>                     resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
>                 }
>             }
> 
>         } else if (method.equals(METHOD_HEAD)) {
>             long lastModified = getLastModified(req);
>             maybeSetLastModified(resp, lastModified);
>             doHead(req, resp);
> 
>         } else if (method.equals(METHOD_POST)) {
>             doPost(req, resp);
>             
>         } else if (method.equals(METHOD_PUT)) {
>             doPut(req, resp);
>             
>         } else if (method.equals(METHOD_DELETE)) {
>             doDelete(req, resp);
>             
>         } else if (method.equals(METHOD_OPTIONS)) {
>             doOptions(req,resp);
>             
>         } else if (method.equals(METHOD_TRACE)) {
>             doTrace(req,resp);
>             
>         } else {
>             //
>             // Note that this means NO servlet supports whatever
>             // method was requested, anywhere on this server.
>             //
> 
>             String errMsg = lStrings.getString("http.method_not_implemented");
>             Object[] errArgs = new Object[1];
>             errArgs[0] = method;
>             errMsg = MessageFormat.format(errMsg, errArgs);
>             
>             resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, errMsg);
>         }
>     }
> ```
>
> FrameServlet.doGet(request,response):
>
> ```java
> @Override
> 	protected final void doGet(HttpServletRequest request, HttpServletResponse response)
> 			throws ServletException, IOException {
> 
> 		processRequest(request, response);
> 	}
> ```
>
> FrameServlet.processRequest(request,response):这里面的代码大多数大家不用去关注
>
> ```java
> protected final void processRequest(HttpServletRequest request, HttpServletResponse response)
> 			throws ServletException, IOException {
> 
> 		long startTime = System.currentTimeMillis();
> 		Throwable failureCause = null;
> 
> 		LocaleContext previousLocaleContext = LocaleContextHolder.getLocaleContext();
> 		LocaleContext localeContext = buildLocaleContext(request);
> 
> 		RequestAttributes previousAttributes = RequestContextHolder.getRequestAttributes();
> 		ServletRequestAttributes requestAttributes = buildRequestAttributes(request, response, previousAttributes);
> 
> 		WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);
> 		asyncManager.registerCallableInterceptor(FrameworkServlet.class.getName(), new RequestBindingInterceptor());
> 
> 		initContextHolders(request, localeContext, requestAttributes);
> 
> 		try {
>             //这个方法时我们感兴趣的方法
> 			doService(request, response);
> 		}
> 		catch (ServletException | IOException ex) {
> 			failureCause = ex;
> 			throw ex;
> 		}
> 		catch (Throwable ex) {
> 			failureCause = ex;
> 			throw new NestedServletException("Request processing failed", ex);
> 		}
> 
> 		finally {
> 			resetContextHolders(request, previousLocaleContext, previousAttributes);
> 			if (requestAttributes != null) {
> 				requestAttributes.requestCompleted();
> 			}
> 			logResult(request, response, failureCause, asyncManager);
> 			publishRequestHandledEvent(request, response, startTime, failureCause);
> 		}
> 	}
> ```
>
> FrameServlet.doService(request,response);
>
> ```java
> protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
> 		logRequest(request);
> 
> 		// Keep a snapshot of the request attributes in case of an include,
> 		// to be able to restore the original attributes after the include.
> 		Map<String, Object> attributesSnapshot = null;
> 		if (WebUtils.isIncludeRequest(request)) {
> 			attributesSnapshot = new HashMap<>();
> 			Enumeration<?> attrNames = request.getAttributeNames();
> 			while (attrNames.hasMoreElements()) {
> 				String attrName = (String) attrNames.nextElement();
> 				if (this.cleanupAfterInclude || attrName.startsWith(DEFAULT_STRATEGIES_PREFIX)) {
> 					attributesSnapshot.put(attrName, request.getAttribute(attrName));
> 				}
> 			}
> 		}
> 
> 		// Make framework objects available to handlers and view objects.
> 		request.setAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE, getWebApplicationContext());
> 		request.setAttribute(LOCALE_RESOLVER_ATTRIBUTE, this.localeResolver);
> 		request.setAttribute(THEME_RESOLVER_ATTRIBUTE, this.themeResolver);
> 		request.setAttribute(THEME_SOURCE_ATTRIBUTE, getThemeSource());
> 
> 		if (this.flashMapManager != null) {
> 			FlashMap inputFlashMap = this.flashMapManager.retrieveAndUpdate(request, response);
> 			if (inputFlashMap != null) {
> 				request.setAttribute(INPUT_FLASH_MAP_ATTRIBUTE, Collections.unmodifiableMap(inputFlashMap));
> 			}
> 			request.setAttribute(OUTPUT_FLASH_MAP_ATTRIBUTE, new FlashMap());
> 			request.setAttribute(FLASH_MAP_MANAGER_ATTRIBUTE, this.flashMapManager);
> 		}
> 
> 		RequestPath previousRequestPath = null;
> 		if (this.parseRequestPath) {
> 			previousRequestPath = (RequestPath) request.getAttribute(ServletRequestPathUtils.PATH_ATTRIBUTE);
> 			ServletRequestPathUtils.parseAndCache(request);
> 		}
> 
> 		try {
>             //重点关注这个方法
> 			doDispatch(request, response);
> 		}
> 		finally {
> 			if (!WebAsyncUtils.getAsyncManager(request).isConcurrentHandlingStarted()) {
> 				// Restore the original attribute snapshot, in case of an include.
> 				if (attributesSnapshot != null) {
> 					restoreAttributesAfterInclude(request, attributesSnapshot);
> 				}
> 			}
> 			if (this.parseRequestPath) {
> 				ServletRequestPathUtils.setParsedRequestPath(previousRequestPath, request);
> 			}
> 		}
> 	}
> ```
>
> 



## SpringMVC配置类使用形式(重点掌握)

使用配置类时，默认是整合了spring和springmvc的。spring内部有一个容器，springmvc内部也有一个容器。针对web开发项目中的组件，我们遵循的原则是如果是web需要用到的组件，那么放入到springmvc容器中，也就是在springmvc配置类中编写；如果是非web的组件，那么放入到spring的配置类中，比如serivce、mapper等，也就是在spring配置类中进行配置。

但是，大家无需担心，放置在两个容器中会不会有屏蔽。不需要担心，访问的时候依然是可以访问到的。

1.新建一个启动类继承自AACDSI，新建Spring配置类及SpringMVC配置类

```java
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //配置Spring的启动类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    //配置SpringMVC启动类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    //配置SpringMVC核心控制器DispatcherSerlvet的url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
```

```java
@Configuration
//需要扫描除了controller之外的其他的组件,需要将controller和SpringMVC配置类排除在外
@ComponentScan(value = "com.cskaoyan.th58",excludeFilters = {@ComponentScan.Filter(value = {Controller.class, EnableWebMvc.class})})
public class SpringConfig {
    //之前整合mybatis涉及到的所有的组件，写在这里面
}

```

```java
//进行组件的实例化，用来去处理web请求
@EnableWebMvc
//springmvc中的controller组件交给springmvc去扫描
@ComponentScan("com.cskaoyan.th58.controller")

//此时还可以先实现一个接口，后续去配置一个web组件时，比较方便
public class SpringMVCConfig implements WebMvcConfigurer {
    //今后需要去设置文件上传组件，那么应该写在这个配置类中
}

```







