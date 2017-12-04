jsp标准标签库
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 引入

<c:out value="${ param.action}"> </c:out>  输出

<c:if test="${ param.action == 'add' }"> </c:if>

<c:choose> <c:when test="${ xxx }" > </c:when> <c:otherwise> </c:otherwise> </c:choose> 实现if else

<c:forEach var="num" begin="2" end="100", step="2" > </c:forEach> 定义类似于for(int num=2;num<=100;num+=2)

<c:forEach var="person" items="${ personList }" > </c:forEach> 定义遍历list

<c:set > 设置变量

<c:remove >删除变量

<c:catch> 捕捉异常

<c:import >导入网络资源

<c:redirect > 重定向

<c:param >重定向时可能使用参数, 此时使用此标签

<c:url value="xxx" > url重写



fn方法库, 提供字符串的操作能力
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

fn:contains(String1, String2) 判断2是否1的子串
fn:containsIgnoreCase(String1, String2) 

fn:endsWith()
fn:startsWith()
fn:escapeXml() 对xml字符等进行编码, 作用同<c:out value="" escapeXml="true" />
fn:indexOf()
fn:split() 分割字符
fn:join() 联合字符
fn:length() 

xml标签库
<%@ taglib uri="http://java.sun.com/jsp/jstl/XML" prefix="x" %> 

<x:parse var="content"> xxxxx </x:parse> #解析后的xml对象放到变量content中

常用用法
<c:import var="file" url="/WEB-INF/web.xml" />
<x:parse var="doc" doc="${ file }"></x:parse>

<x:out select="$doc/name/@description" /> #输出指定元素
<x:forEach var="node" select="$doc/rss/channel/item" varStatus="status" > </x:forEach> 遍历指定的多个元素
<x:if select="$doc/rss/channel" var="esists" > </x:if> 判断对应的元素是否存在
<x:set select=" xxx " var="resource" /> 设置变量
