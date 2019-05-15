package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 利用工具类
 * 判断是否是初次访问者
 */
public class RepeatVisitor2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean newbie = true;
        String value = CookieUtils.getCookieValue(req,
                "repeatVisitor2","no");
        if (value.equals("yes")){
            newbie = false;
        }
        String title;
        if (newbie){
            //初次访问，设置长时间Cookie
            LongLivedCookie returnVisitorCookie =
                    new LongLivedCookie("repeatVisitor2","yes");
            resp.addCookie(returnVisitorCookie);
            title = "Welcome Aboard";
        }else {
            title = "Welcome Back";
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "</BODY></HTML>");
    }
}
