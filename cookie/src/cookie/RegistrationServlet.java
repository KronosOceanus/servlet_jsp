package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 得到参数，存入Cookie
 * RegistrationForm
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //是否参数缺失
        boolean isMissingValue = false;
        String firstName = req.getParameter("firstName");
        if (isMissing(firstName)){
            firstName = "Missing first name";
            isMissingValue = true;
        }
        String lastName = req.getParameter("lastName");
        if (isMissing(lastName)){
            lastName = "Missing last name";
            isMissingValue = true;
        }
        String emailAddress = req.getParameter("emailAddress");
        if (isMissing(emailAddress)){
            emailAddress = "Missing email address";
            isMissingValue = true;
        }

        String formAddress = "cookie.RegistrationForm";
        if (isMissingValue){
            //重定向继续输入参数
            resp.sendRedirect(formAddress);
        }else {
            Cookie c1 = new LongLivedCookie("firstName",firstName.trim());
            resp.addCookie(c1);
            Cookie c2 = new LongLivedCookie("lastName",lastName.trim());
            resp.addCookie(c2);
            Cookie c3 = new LongLivedCookie("emailAddress",emailAddress.trim());
            resp.addCookie(c3);
            PrintWriter out = resp.getWriter();
            String title = "Thanks for Registering";
            out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                    "<CENTER>\n" +
                    "<UL>\n" +
                    "   <LI><B>First Name</B>: " + firstName + "\n" +
                    "   <LI><B>Last Name</B>: " + lastName + "\n" +
                    "   <LI><B>Email address</B>: " + emailAddress +"\n" +
                    "</UL>\n" +
                    "</CENTER></BODY></HTML>");
        }
    }

    private boolean isMissing(String param){
        return param == null || param.trim().equals("");
    }
}
