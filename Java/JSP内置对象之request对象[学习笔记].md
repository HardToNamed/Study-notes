JSP内置对象之request对象【学习笔记】 

http://www.cnblogs.com/freeabyss/p/3251839.html


request对象是JSP中重要的对象，每个request对象封装着一次用户的请求，并且所有的请求参数都被封装在request对象中，因此request对象是获取请求参数的重要途径。

一、获取请求头与请求参数

web应用是请求/响应架构的应用，浏览器发送请求时通常总会附带一些请求头，还可能包含一些请求参数发送给服务器，服务器端负责解析请求头/请求参数的就是JSP或Servlet，而JSP和Servlet取的请求参数的途径就是request。request是httpServletRequest接口的实例，它提供了如下方法来获得请求参数：
•String getParameter(String paramName) :获取paramName请求参数的值。
•Map getParameterMap() :获取所有请求参数名和参数值所组成的Map对象。
•Enumeration getParameterNames() :获取所有请求参数名所组成的Enumeration对象。
•String[] getParameterValues(String name) : paramName请求参数的值，当该请求参数有多个值时，该方法将返回多个值所组成的数组。


httpSevletRequest提供如下方法来访问请求头：
•String getHeader(String name): 获取指定请求头的值
•java.util.Enumeration<String> getHeaderNames(): 获取所有请求头的名称
•java.util.Enumeration<String> getHeaderNames(String name):获取指定请求头的多个值
•int getIntHeader(String name):获取指定请求头的值，并将其转化为整数。



请求头通常由浏览器自动添加，因此一次请求总是包含若干请求头；请求参数通常需要开发人员控制添加，客户端发送请求参数通常分为两种情况：

1、GET方式请求：直接在浏览器地址栏输入所发送的请求；提交表单时，该表单对应的form元素没有设置method属性，或设置method属性为get，这几种请求都是GET方式的请求。GET方式请求会将请求参数的名和值转换成字符串，并附加在原URL之后，因此可以在浏览器的地址栏上看到请求参数名和值，GET请求传输的数据量较小，不能大于2KB。

2、POST方式请求：这种方式通常使用提交表单的方式来发送，且需要设置form元素的method属性为post。POST传输的数据量较大，请求参数大小通常受服务器的限制。POST方式发送的请求参数以及对应的值放在HTML HEADER中传输，用户不能在地址栏上看到请求参数的值，安全性较高。

代码示例：

　　表单页面：form.jsp

 

View Code 
　　request.jsp

 

View Code 
　　使用GET方式获得请求参数

　　GET请求的获取方式与POST方式一样，不过需要注意的是，页面发送请求时在地址栏增加的请求参数值都是由英文字符组成的，如果请求参数值中包含非西欧字符，需

　　要将请求参数重新编码。

　　获得GET请求里的中文字符：

 

View Code 
　　当然，你也可以在获取请求参数值之后对请求参数值重新编码。

    //获得原始的请求参数
    String rawName = request.getParameter("name");
    //将请求参数值使用ISO-8895-1字符串分解成字节数组
    byte[] rawBytes = rawName.getBytes("ISO-8859-1");
    //将字节数组重新解码成字符串
    String name = new String(rawBytes, "utf-8")

　　2、操作request范围的属性

　　HttpServletRequest还包含如下两种方法，用于设置和获取request范围的属性。
•　　setAttribute(String attName,Object attValue);
•　　Object getAttribute(String attName);

　　3、执行forward或include

　　request还有一个功能就是执行forward和include，也就是代替JSP所提供的forward和include动作指令

　　getRequestDispatcher(String path).include(ServletRequest request,ServletResponse response);

　　getRequestDispatcher(String path).forward(SevletRequest request,ServletResponse response);

　　注意：使用request的getRequestDispatcher(String path)方法时，该path字符串必须以斜线开头。
