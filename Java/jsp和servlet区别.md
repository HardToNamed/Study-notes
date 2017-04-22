一、基本概念 
          1.1 Servlet
          Servlet是一种服务器端的Java应用程序，具有独立于平台和协议的特性，可以生成动态的Web页面。它担当客户请求（Web浏览器或其他HTTP客户程序）与服务器响应（HTTP服务器上的数据库或应用程序）的中间层。 Servlet是位于Web 服务器内部的服务器端的Java应用程序，与传统的从命令行启动的Java应用程序不同，Servlet由Web服务器进行加载，该Web服务器必须包含支持Servlet的Java虚拟机。
          1.2 JSP      
          JSP技术使用Java编程语言编写类XML的tags和scriptlets，来封装产生动态网页的处理逻辑。网页还能通过tags和scriptlets访问存在于服务端的资源的应用逻辑。JSP将网页逻辑与网页设计的显示分离，支持可重用的基于组件的设计，使基于Web的应用程序的开发变得迅速和容易。 JSP(JavaServer Pages)是一种动态页面技术，它的主要目的是将表示逻辑从Servlet中分离出来。
     JSP是一种脚本语言，包装了Java Servlet系统的界面，简化了Java和Servlet的使用难度，同时通过扩展JSP标签(TAG)提供了网页动态执行的能力。JSP提供了一套简单的标签，和HTML融合的比较好，可以使不了解Servlet的人可以做出动态网页来。对于Java语言不熟悉的人,会觉得JSP开发比较方便。JSP修改后可以立即看到结果，不需要手工编译，JSP引擎会来做这些工作；而Servelt缺需要编译，重新启动Servlet引擎等一系列动作。但是在JSP中，HTML与程序代码混杂在一起，而Servlet却不是这样。下面我们对JSP的运行来做一个简单的介绍，告诉大家怎样来执行一个JSP文件：当Web服务器(或Servlet引擎,应用服务器)支持JSP引擎时，JSP引擎会照着JSP的语法，将JSP文件转换成Servlet代码源文件，接着Servlet会被编译成Java可执行字节码(bytecode)，并以一般的Servlet方式载入执行JSP语法简单，可以方便的嵌入HTML之中，很容易加入动态的部分，方便的输出HTML。在Servlet中输出HTML缺需要调用特定的方法，对于引号之类的字符也要做特殊的处理，加在复杂的HTML页面中作为动态部分，比起JSP来说是比较困难的。
二、两者之间的联系和区别
【1】JSP第一次运行的时候会编译成Servlet，驻留在内存中以供调用。
【2】JSP是web开发技术，Servlet是服务器端运用的小程序，我们访问一个JSP页面时，服务器会将这个JSP页面转变成Servlet小程序运行得到结果后，反馈给用户端的浏览器。
【3】Servlet相当于一个控制层再去调用相应的JavaBean处理数据,最后把结果返回给JSP。
【4】Servlet主要用于转向，将请求转向到相应的JSP页面。
【5】JSP更多的是进行页面显示，Servlet更多的是处理业务，即JSP是页面，Servlet是实现JSP的方法。
【6】Servlet可以实现JSP的所有功能，但由于美工使用Servlet做界面非常困难，后来开发了JSP。
【7】JSP技术开发网站的两种模式：JSP + JavaBean；JSP + Servlet + JavaBean（一般在多层应用中, JSP主要用作表现层,而Servlet则用作控制层,因为在JSP中放太多的代码不利于维护，而把这留给Servlet来实现,而大量的重复代码写在JavaBean中）。
【8】二者之间的差别就是，开发界面是JSP直接可以编写。
比如在JSP中写Table标记：<table>[数据]</table>；
Servlet需要加入：out.println(“<table>[数据]</table>”)。
JSP文件在被应用服务器(例如：Tomcat、Resin、Weblogic和Websphere),调用过之后，就被编译成为了Servlet文件。也就是说在网页上显示的其实是Servlet文件。Tomcat下面JSP文件编译之后生成的Servlet文件被放在了work文件夹下，JSP中的HTML代码在Servlet都被out出来，而JSP代码按照标签的不同会放在不同的位置。
【9】JSP中嵌入JAVA代码，而Servlet中嵌入HTML代码。
【10】在一个标准的MVC架构中，Servlet作为Controller接受用户请求并转发给相应的Action处理，JSP作为View主要用来产生动态页面，EJB作为Model实现你的业务代码。
