package session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 输出会话跟踪的各种信息
 * 用户访问页面计数
 */
public class ShowSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String heading;
        Integer accessCount =
                (Integer)session.getAttribute("accessCount");
        if (accessCount == null){
            accessCount = 0;
            heading = "Welcome, Newcomer";
        }else {
            heading = "Welcome Back";
            accessCount = accessCount + 1;
        }
        //不可变数据结构，属性每次都需要这个方法替换
        session.setAttribute("accessCount",accessCount);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Session Trancking Example";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<CENTER>\n" +
                "<H2>" + heading + "</H2>\n" +
                "<H3>Information on Your Session: </H3>\n" +
                "<TABLE BODER=1>\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "   <TH>Info Type<TH>Value\n" +
                "<TR>\n" +
                "   <TD>ID\n" +
                "   <TD>" + session.getId() + "\n" +
                "<TR>\n" +
                "   <TD>Creation Time\n" +
                "   <TD>" + new Date(session.getCreationTime()) + "\n" +
                "<TR>\n" +
                "   <TD>Time of Last Access\n" +
                "   <TD>" + new Date(session.getLastAccessedTime()) + "\n" +
                "<TR>\n" +
                "   <TD>Number of Previous Accesses\n" +
                "   <TD>" + accessCount + "\n" +
                "</TABLE>\n" +
                "</CENTER></BODY></HTML>");
    }
}
