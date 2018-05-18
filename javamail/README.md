# javamail 
## 邮件开发的概念和原理
    1、邮件服务器：
    2、电子信箱
    3、邮件的发送和接收要遵循一定的协议
        SMTP: simple message transfer protocal 发送邮件协议 默认端口：25
        POP:post office protocal:邮局协议，接收邮件的协议 默认端口：110
## SMTP协议
## 创建邮件:javamail
    mail.jar：包含Javamail的规范和sun提供一套实现
    jaf.jar :javamail依赖该jar(JDK6+已经包含了)
    Message :代表一封邮件
    Session：发送邮件的环境
    transport：发送邮件
    BodyPart：表示邮件的一部分内容
    multipart：描述bodypart之间的关系
### 只有文本的邮件
### 文本中内嵌图片的邮件
    邮件是由多个部分数据组成的
### 文本中内嵌图片还有附件的复杂邮件
## 发送邮件
## 邮件开发中的编码问题
    1、附件的名称丢失的问题
            解决方案:手动设置文件名
    2、中文乱码
        主题有中文:不需要处理
        正文有中文：text/html;charset=utf-8
        附件名称有中文:MimeUtility.encodedText(filename)
        附件名称有中文:MimeUtility.encodedText(filename)
        
 ##邮箱的激活和验证
    activeCode :激活码，必须唯一
    actived ：是否激活