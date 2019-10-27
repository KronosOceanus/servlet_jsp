import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送消息类
 * 设置发送属性
 * 通过属性获取 Session，传入 Session 到 Message 构造器得到 Message 对象
 * 设置收件人地址（InternetAddress 数组），邮件标题、内容
 * 通过 Session 获取 Transport
 * 连接账户（需要邮箱授权码），向所有地址发送信息
 */
public class SendMessages {

    public static void Send(String title,String value) throws MessagingException{
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");//设置是否显示debug信息 true 会在控制台显示相关信息
        //得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        //设置发件人邮箱地址
        message.setFrom(new InternetAddress("704690152@qq.com"));
        //设置收件人地址
        message.setRecipients(MimeMessage.RecipientType.TO,
                new InternetAddress[]{new InternetAddress("704690152@qq.com")});
        //设置邮件标题
        message.setSubject(title);
        //设置邮件内容
        message.setText(value);
        //得到邮差对象
        Transport transport = session.getTransport();
        //连接发件人的邮箱账户
        transport.connect("704690152@qq.com", "ozjzvddayzdgbeej");
        transport.sendMessage(message, message.getAllRecipients());
    }
}