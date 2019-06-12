package http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 区分浏览器类型
 */
@WebServlet(name = "http.BrowserInsult",
    urlPatterns = {"/http.BrowserInsult"})
public class BrowserInsult extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title, message;
        //得到 User-Agent 报头
        String userAgent = req.getHeader("User-Agent");
        //包含MSIE是IE浏览器
        if (userAgent != null && userAgent.contains("MSIE")){
            title = "Microsoft Minion";
            message = "Welcome, O spineless slave to the " +
                    "mighty empire";
        }else {
            title = "Hopeless Netscape Rebel";
            message = "Enjoy it while you can. " +
                    "You <I>will</I> be assimilated";
        }
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                message + "\n" +
                "</BODY></HTML>");
    }
}
