
# 该子项目的主要是servlet中response和request
## 登录页面(重定向和转发) 
## 定时刷新(refersh)
## 中文乱码
### 字节流解决方案
#### 输出浏览器的设置 response.setHeader("content-type", "text/html;charset=utf-8")
#### 设置某种编码中文字节 "中文".getBytes("utf-8")
### 字符流解决方案
#### 第一种
##### 输出浏览器的设置 response.setHeader("content-type", "text/html;charset=utf-8")
##### 设置response缓存中的编码，其默认编码是iso-8859-1 ，response.setCharasetEncoding("utf-8")
#### 第二种
#### reponse.setContentType("text/html;charset=utf-8")
## 禁用浏览器的缓存
### Cache-Control no-Cache
### pragma no-Cache
### Expires -1
## 以附件的形式下载
### 输入流、设置头信息(Content-Disposition attachment;filename="") 、输出流
## 验证码
### 在内存中生成一种图片 BufferedImage
### 获取画笔
### 准备好数据，随机选择四个字符
### 通过画笔对象，把字符写图片上
### 画干扰性
### 把内存中的图片输出到浏览器中 ImageIO.write

# request
## 解决request中的获取参数的乱码的问了
### post方式
    <pre>
    <code>
        request.setCharacterEncoding("utf-8")
    </code>
    </pre>
#### get方式 
#### 第一种 修改 server.xml中的<connector URIEncoding="utf-8">
#### 第二种 URLEncoder username = URLEcode.encode(username, "iso88591")
           <pre><code>
                 URLDecoder username == URLDecode.deconde(username, "UFT-8")
                 new String(usernaem.getBytes（"iso88591"）,"utf-8")
           </code></pre>
## 转发 request.getReqestDispatcher(path).forword(reqest, response)

# jsp(java server pages) 服务端技术
## java代码+html+jsp自己的代码
### java代码
#### <%! %> 不常用 定义变量(成员变量） 定义放
#### <%= %> 使用 输出 可以输出变量 该内容输出到页面中
#### <% %> 翻译到_japService的方法中 定义变量和编写语句
#### EL表达式 输出内容到页面中  ${name} 相当于 <%= %>
 ## 会话技术(Cookie 客户端技术，数据保存到本地)
 ### 可以处理的情况是：购物的网站
 ## session 服务器端的技术