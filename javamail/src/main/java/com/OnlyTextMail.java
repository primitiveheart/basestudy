package com;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by admin on 2018/5/18.
 */
public class OnlyTextMail {
    public static void main(String[] args)throws Exception{
        //创建邮件
        Properties props = new Properties();
        //设置发送邮件的环境
        //使用协议
        props.setProperty("mail.transport.protocol","smtp");
        //邮件的服务器
        props.setProperty("mail.host", "smtp.163.com");
        //邮件的认证
        props.setProperty("mail.smtp.auth","true");
        Session session = Session.getInstance(props);
//        session.setDebug(true);
        Message message = genMessage(session);

        //发送邮件
        Transport transport = session.getTransport();
        //链接服务器
        transport.connect("zhouguanbaowuhan","密码");
        //发送邮件
        transport.sendMessage(message, message.getAllRecipients());


//        message.writeTo(new FileOutputStream("F:/1.eml"));

    }

    private static Message genMessage(Session session) throws MessagingException {
        Message message = new MimeMessage(session);

        //设置邮件头
        message.setFrom(new InternetAddress("zhouguanbaowuhan@163.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("zhuhe0322@163.com"));
        message.setSubject("这是第一封邮件");

        //设置邮件体
        message.setContent("hsdhskhdfhsf", "text/plain");
        message.saveChanges();

        return message;
    }
}
