package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 先获取Cookie缓存作为输入默认值
 * 再等待用户输入
 */
public class RegistrationForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String actionURL = "cookie.RegistrationServlet";
        //先从Cookie中获取缓存的输入信息，作为表单输入框的默认Value
        String firstName =
                CookieUtils.getCookieValue(req,"firstName","");
        String lastName =
                CookieUtils.getCookieValue(req,"lastName","");
        String emailAddress =
                CookieUtils.getCookieValue(req,"emailAddress","");

        String title = "Please Register";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<CENTER>\n" +
                "<FORM ACTION=\"" + actionURL + "\">\n" +
                "First Name: \n" +
                "   <INPUT TYPE=\"TEXT\" NAME=\"firstName\"" +
                "       VALUE=\"" + firstName + "\"><BR />\n" +
                "Last Name: \n" +
                "   <INPUT TYPE=\"TEXT\" NAME=\"lastName\"" +
                "       VALUE=\"" + lastName + "\"><BR />\n" +
                "Email Address: \n" +
                "   <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\"" +
                "       VALUE=\"" + emailAddress + "\"><BR />\n" +
                "<INPUT TYPE=\"SUBMIT\" VALUE=\"Register\">\n" +
                "</FORM></CENTER></BODY></HTML>");
    }
}
