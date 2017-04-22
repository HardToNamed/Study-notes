<%  %> 标示java代码
<%--  --%>注释
<%@ page    %>设置page属性
<%!   %>声明全局方法变量，不能使用out对象
<%=   %>调用方法变量，输出到html中
<%   %>存在变量和代码片段，可以使用out对象，用于控制流程

<jsp:include  page=url />动态包含
<jsp:forward page=url />转发
<jsp:param name="参数” value="值" />

out.println()输出

内置对象
request、response、session、application、out、page、config、exception、pageContent

request.setCharacterEncoding("UTF-8");
request.getParameter(String name); 获取url传递的参数
response.setHeader("refresh","5,url=login.jsp");定时跳转
response.setHeader("refresh","10");自动刷新

session.setAttribute(String name, Object obj);
session.getAttribute(String name);
session.removeAttributr(String name);
session.setMaxInactiveInterval(int time);设置有效时间
session.invalidate();手动销毁session

application.setAttribute(String name, Object obj);
application.getAttribute(String name);
application.removeAttributr(String name);
application.getAttributeNames();获取所有已定义参数名
