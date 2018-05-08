
# 该子项目的主要是servlet中response和request
## 登录页面(重定向) 
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
