package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 区分会话Cookie与持续性Cookie
 */
public class CookieTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i=0;i<3;i++){
            //会话Cookie
            Cookie cookie = new Cookie("Session-Cookie-" + i,
                    "Cookie-Value-S" + i);
            resp.addCookie(cookie);
            //持续性Cookie
            cookie = new Cookie("Persistent-Cookie-" + i,
                    "Cookie-Value-P" + i);
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);
        }
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Active Cookies";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "   <TH>Cookie Name\n" +
                "   <TH>Cookie Value");
        //得到Cookie列表
        Cookie[] cookies = req.getCookies();
        if (cookies == null){
            out.println("<TR><TH COLSPAN=2>No Cookies");
        }else {
            for (Cookie c : cookies){
                out.println("<TR>\n" +
                        "   <TD>" + c.getName() + "\n" +
                        "   <TD>" + c.getValue());
            }
        }
        out.println("</TABLE></BODY></HTML>");
    }
}
