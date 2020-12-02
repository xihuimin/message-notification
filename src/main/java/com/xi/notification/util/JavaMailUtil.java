package com.xi.notification.util;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * <p>QQ邮箱需要开启smtp协议，开启后会获得一个授权码，代码通过邮箱号+授权码连接邮箱
 *
 * @Author xihuimin
 * @Date 2020/12/2
 */
@Component
public class JavaMailUtil {

    //smtp.mxhichina.com  服务器
    private static final String host = "smtp.qq.com";
    //协议
    private static final String protocol = "smtp";

    private static String name = "291043458@qq.com";
    private static String pwd = "xxxxxxxxxxxxxx";
    private static String from = "291043458@qq.com";
    private static String nickName = "QQ邮件测试";

    /**
     *  还可以增加一个附件入参
     *
     * @param to 发送给谁
     * @param cc 抄送给谁
     * @param title 邮件标题
     * @param content 邮件文本内容
     */
    public void sendEmail(String to, String cc, String title, String content){
        Properties properties = new Properties();
        try {
            properties.setProperty("mail.host", host);
            properties.setProperty("mail.transport.protocol", protocol);
            properties.setProperty("mail.smtp.auth", "true");
            Session session = Session.getInstance(properties);
            session.setDebug(true);
            Transport transport = session.getTransport();
            transport.connect(name, pwd);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from, nickName, "utf-8"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(cc));
            message.setSubject(title);

            Multipart multipart = new MimeMultipart();

            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent("<meta http-equiv=Content-Type content=text/html; charset=UTF-8>" + content, "text/html;charset=UTF-8");
            multipart.addBodyPart(bodyPart);
//            if (fileAddress != null && fileAddress.size() > 0) {
//                for (String file : fileAddress) {
//                    BodyPart part = new MimeBodyPart();
//                    FileDataSource fileDataSource = new FileDataSource(file);
//                    part.setDataHandler(new DataHandler(fileDataSource));
//                    //System.out.println("==========================" + fileDataSource.getName() + "============");
//                    part.setFileName(MimeUtility.encodeText(fileDataSource.getName(), "utf-8", null));
//                    multipart.addBodyPart(part);
//                }
//            }

            message.setContent(multipart, "text/html;charset=utf-8");
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("waiting....5s左右就ok");
        } catch (Exception e) {
        }
    }
}
