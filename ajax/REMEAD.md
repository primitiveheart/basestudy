# ajax 
    asynchronous javascript and xml
## 同步VS异步
## Js对象XMLHttpRequest对象
    创建对象
        XMLHttpRequest()
        ActiveObjectX(Msxml2.XMLHTTP)
        ActiveObjectX("Microsoft.XMLHTTP)
    属性
    short readyState:标识XMLHttpRequest所处的状态
    状态码 
    0   Xhr创建了
    1   已经调用open方法，但没有调用send
    2   已经提交到服务器，send执行了，没有收到响应信息
    3   已经获取到所有的响应的消息头，但响应正文没有接收到
    4   全部接收到
    String responseText
    Document responseXML
    short status: 用于接收服务器返回的响应码
    String statusText
    方法
    String getAllResponseHeaders()
    String getResponseHeader(String)
    void open(method, url, async, username, password)
    void send(Body)：向服务器发送请求正文
    void setRequestHeader()
    事件
    onreadystatechange;指向一个function
    XMLHttpRequest的readystate的每次变化都会调用该方法
## 服务器端返回的数据类型XMl
    把Javabean---> xml
    开源框架XStream
    xstream.jar xpp3_min.jar
## JSON
    json-lib所需要的包
    json-lib
    ezmorph
    commons-lang
    commons-collections
    commons-logging
    commons-beanutils
     