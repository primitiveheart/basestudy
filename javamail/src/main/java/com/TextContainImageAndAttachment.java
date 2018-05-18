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
public class TextContainImageAndAttachment{
    public static void main(String[] args) throws Exception{
        //创建邮件
        Properties props = new Properties();
        Session session = Session.getInstance(props);
        Message message = new MimeMessage(session);

        //设置邮件头
        message.setFrom(new InternetAddress("zgb@163.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("zzz@163.com"));
        message.setSubject("这是一封内嵌图片含有附件");

        //设置文本
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setContent("aadfsdf<img src='cid:m'>", "text/html");

        //设置图片
        MimeBodyPart imagePart = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("E:\\intellij\\basestudy\\javamail\\src\\main\\java\\11.png"));
        imagePart.setDataHandler(dh);
        imagePart.setContentID("m");

        //设置两者之间的关系
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(textPart);
        mimeMultipart.addBodyPart(imagePart);
        mimeMultipart.setSubType("related");

        MimeBodyPart textimagePart = new MimeBodyPart();
        textimagePart.setContent(mimeMultipart);

        //设置附件
        MimeBodyPart attachmentPart = new MimeBodyPart();
        DataHandler dh1 = new DataHandler(new FileDataSource(""));
        String filename =dh1.getName();
        attachmentPart.setDataHandler(dh1);
        //附件的文件名需要手动设置
        attachmentPart.setFileName(filename);


        MimeMultipart mimeMultipart1 = new MimeMultipart();
        mimeMultipart1.addBodyPart(textimagePart);
        mimeMultipart1.addBodyPart(attachmentPart);
        mimeMultipart1.setSubType("mixed");

        message.setContent(mimeMultipart1);
        message.saveChanges();

        message.writeTo(new FileOutputStream("F:/3.eml"));



    }
}
