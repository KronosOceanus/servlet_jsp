import java.io.PrintWriter;
import java.io.StringWriter;
import javax.mail.MessagingException;

/**
 * 测试
 */
public class Main {

    public static void main(String[] args) throws MessagingException {
        try {
            SendMessages.Send("javaWeb", "javaWeb测试内容！");
        } catch (Exception e) {
            //以下代码是为了获取错误信息以及错误位置
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw, true);
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            //调用方法 传入参数 发送邮件
            SendMessages.Send("error", sw.toString());
        }
    }
}