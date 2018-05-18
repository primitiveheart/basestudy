package com;


import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by admin on 2018/5/18.
 */
public class TextContainImageMail {
    public static void main(String[] args)throws Exception{
        //创建邮件
        Properties props = new Properties();
        Session session = Session.getInstance(props);
        Message message = new MimeMessage(session);

        //设置邮件头
        message.setFrom(new InternetAddress("zhouguanbaowuhan@163.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("zgb@163.com"));
        message.setSubject("这是一封含有图片的邮件");

        //设置文本部分
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setContent("asdfdf<img src='cid:m'>", "text/html");

        //设置图片部分
        MimeBodyPart imagePart = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("E:\\intellij\\basestudy\\javamail\\src\\main\\java\\11.png"));
        imagePart.setDataHandler(dh);
        imagePart.setContentID("m");

        //设置两者之间的关系
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(textPart);
        mimeMultipart.addBodyPart(imagePart);
        mimeMultipart.setSubType("related");

        message.setContent(mimeMultipart);
        message.saveChanges();

        message.writeTo(new FileOutputStream("f:/2.eml"));

    }
}
