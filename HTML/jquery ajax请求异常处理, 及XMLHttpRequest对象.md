## jquery ajax请求异常处理, 及XMLHttpRequest对象
对jQuery 来说，超时可以直接设置timeout参数，并在error事件中捕获第二个参数，如果是“timeout”则表明捕获了超时事件，非常清楚
$.ajax({
       type: "POST"
,
       contentType: "application/json"
,
       url: "../ws/MyService.asmx/test"
,
       data: '{"email":"'
+email+'"}'
,
       timeout: 30000, //超时时间：30秒

       dataType: 'json'
,
       error: function
(XMLHttpRequest, textStatus, errorThrown){
       //TODO: 处理status， http status code，超时 408

       // 注意：如果发生了错误，错误信息（第二个参数）除了得到null之外，还可能

             //是"timeout", "error", "notmodified" 和 "parsererror"。

       },
       success: function
(result) {
         // TODO: check result

       }
});  
或者使用$.post方法
$.post(
    url="url",
    data={"filepath":filepath},
    function (result, status) {
        alert(result);
    }
).fail(function (XMLHttpRequest) {
    alert(XMLHttpRequest.responseText);
})

在此还需要了解下XMLHttpRequest这个对象的属性和方法：

| 属性 | 说明 |
| ---- | ---- |
| readyState | 表示XMLHttpRequest对象的状态：0：未初始化。对象已创建，未调用open；<br>1：open方法成功调用，但Sendf方法未调用；<br>2：send方法已经调用，尚未开始接受数据； <br>3：正在接受数据。Http响应头信息已经接受，但尚未接收完成;<br>4：完成，即响应数据接受完成。|
| Onreadystatechange | 请求状态改变的事件触发器（readyState变化时会调用这个属性上注册的javascript函数）。 |
| responseText | 服务器响应的文本内容 |
| responseXML | 服务器响应的XML内容对应的DOM对象 |
| Status | 服务器返回的http状态码。200表示“成功”，404表示“未找到”，500表示“服务器内部错误”等。 |
| statusText | 服务器返回状态的文本信息。 |


| 方法 | 说明 |
| ---- | ---- |
| Open(string method,string url,boolean asynch,<br>String username,string password) | 指定和服务器端交互的HTTP方法，URL地址，即其他请求信息；<br>Method:表示http请求方法，一般使用"GET","POST".<br>url：表示请求的服务器的地址；<br>asynch：表示是否采用异步方法，true为异步，false为同步；<br>后边两个可以不指定，username和password分别表示用户名和密码，提供http认证机制需要的用户名和密码。
| Send(content) | 向服务器发出请求，如果采用异步方式，该方法会立即返回。<br>content可以指定为null表示不发送数据，其内容可以是DOM对象，输入流或字符串。
| SetRequestHeader(String header,String Value) | 设置HTTP请求中的指定头部header的值为value.<br>此方法需在open方法以后调用，一般在post方式中使用。
| getAllResponseHeaders() |返回包含Http的所有响应头信息，其中相应头包括Content-length,date,uri等内容。<br>返回值是一个字符串，包含所有头信息，其中每个键名和键值用冒号分开，每一组键之间用CR和LF（回车加换行符）来分隔！
| getResponseHeader(String header) | 返回HTTP响应头中指定的键名header对应的值 |
| Abort() | 停止当前http请求。对应的XMLHttpRequest对象会复位到未初始化的状态。|
