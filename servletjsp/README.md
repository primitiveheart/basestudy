
# 该子项目的主要是servlet中response和request
## 登录页面(重定向和转发) 
## 定时刷新(refersh)
## 中文乱码
### 字节流解决方案
     输出浏览器的设置 response.setHeader("content-type", "text/html;charset=utf-8")
     设置某种编码中文字节 "中文".getBytes("utf-8")
### 字符流解决方案
#### 第一种
      输出浏览器的设置 response.setHeader("content-type", "text/html;charset=utf-8")
      设置response缓存中的编码，其默认编码是iso-8859-1 ，response.setCharasetEncoding("utf-8")
#### 第二种
      reponse.setContentType("text/html;charset=utf-8")
## 禁用浏览器的缓存
    Cache-Control no-Cache
    pragma no-Cache
    Expires -1
## 以附件的形式下载
### 输入流、设置头信息(Content-Disposition attachment;filename="") 、输出流
## 验证码
    在内存中生成一种图片 BufferedImage
    获取画笔
    准备好数据，随机选择四个字符
    通过画笔对象，把字符写图片上
    画干扰性
    把内存中的图片输出到浏览器中 ImageIO.write

# request
## 解决request中的获取参数的乱码的问了
### post方式  
        request.setCharacterEncoding("utf-8")
    
#### get方式 
#### 第一种 修改 server.xml中的<connector URIEncoding="utf-8">
#### 第二种 URLEncoder username = URLEcode.encode(username, "iso88591")
                 URLDecoder username == URLDecode.deconde(username, "UFT-8")
                 new String(usernaem.getBytes（"iso88591"）,"utf-8")
## 转发 request.getReqestDispatcher(path).forword(reqest, response)

# jsp(java server pages) 服务端技术
## java代码+html+jsp自己的代码
### java代码
     <%! %> 不常用 定义变量(成员变量） 定义放
     <%= %> 使用 输出 可以输出变量 该内容输出到页面中
      <% %> 翻译到_japService的方法中 定义变量和编写语句
#### EL表达式 输出内容到页面中  ${name} 相当于 <%= %>
## 会话技术(Cookie 客户端技术，数据保存到本地)
### 可以处理的情况是：购物的网站
### 示例: 显示用户上次访问的时间
### 示例: 浏览记录
### setMaxAge() 设置有效是时间，
     默认保存到浏览器的缓存中，设置有效时间则把cookie保存到磁盘上
### setPath(String url) 设置有效路径
     默认是路径是 ：该网站的路径，访问时都会带有所有的资源，待会携带cookie
     设置有效路径: 设置路径之后，只有该路径携带cookie，其他路径都不会携带cookie
### setDomain() 设置有效域名
    如果访问某个网站的所有的携带cookie
    imag.baidu.com
    xxx.baid.com
    setDomain("baidu,com")
## session 服务器端的技术
### 示例: 购物车
    创建 第一次访问后台程序中，有request.getSession（）;
    销毁 1、session默认的失效时间(30分钟) 2、invalidate()


# jsp
## jsp的基本语法
### jsp脚本元素
### jsp页面注释
        <%-- --%>
### jsp指令元素
    <%@ page% name=value> import 可以出现多次，其它属性只能出现一次
    errorPage 只能配置一个页面， <error-page>在web.xml配置全局页面
    isErrorPage 使用exception对象
    isELIgonre
    <%@ include file%> 包含页面布局
    <%@ taglib%> 引入标签库
### jsp内置对象
    requset, response. pageContext(PageContext) 
    session application(ServletContext) out
     page(Object this这向jsp本身对象) config(ServletConfig) exception
     
     out对象 JspWriter out对象中内容先输出到reponse中，在由response向外输出
     response PrintWrite 
     pageContext，页面的上下文
### jsp标签
#### jsp的动作标签
    <jsp:forward page>
    <jsp;param> 传送参数
    <jsp:include>
    <jsp:useBean>
    <jsp:setProperty>
    <jsp:getProperty>
## 数据的封装
### 内省技术Introspector
### BeanUtils工具类 --- commons-beanutils.jar commons-logging.jar
      对日期不进行封装
      Converter接口，ConvertUtils进行注册 
## EL表达式
### 获取域中的数据
      从最小域中取值
### 进行运算
### 获取web开发中常用的对象
    pageScope
    requestScope
    sessionScope
    applicationScope
    param:获取表单提交的参数
    paramValues:
    header和headerValues:请求头
    initParam:获取全局的参数
    cookie:通过cookie对象来获取cookie的值
    pageContext
## JSTL标签库
    jstl.jar和standard.jar
### core标签库
      <c:if test>、<c:out>中的属性value、default、escapeXML对特殊字符是否不进行转义
      <c:set>中的属性var value scope、<c:remove>、<c:choose>与<c:when>和<c:otherwise>
      <c:forEach var=集合中某个元素 items=集合>
       <c:forEach var begin end step>
       <c:forEach varStatus> varStatus中属性。index、count(计数)、first、last
       <c:import url var scope>与<%@ include%>类似
       <c:url>实现url的重写
       <c:redirect>
### el函数标签库
       该标签库主要针对字符串的
       <c:set var="username" value="adbadkjbdk">
      <fn:contains()>、<fn:split>、<fn:indexOf(username,"a)>
#### 自定义函数
      1、编写一个java类，方法必须静态的
      2、在web-inf目录下。创建一个tld的配置文件
### 自定义标签
        1、实现Tag标签接口SimpleTag、SimpleTagSupport
        2、在tld文件中配置
#### 不带有标签主体<body-content>empty</body-content>
#### 带有标签主体 <body-content>scriptless</body-content> 可以使用el和jstl
#### 带有属性的标签

## 总结
    servlet 1、需要进行配置(web.xml)，2、 生成html页面麻烦
    jsp 1、不需要进行培训，2、生成html页面非常迅速 3、代码复用性不高，维护麻烦
    jsp+javabean 1、把数据封装和处理使用Javabean进行实现 mode1时代
    sevlet+jsp+javabean model2时代 mvc思想 