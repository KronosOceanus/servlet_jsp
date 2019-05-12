package form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 没有处理特殊字符
 * 浏览器可能把输入误认为HTML标签
 */
@WebServlet(name = "form.BadCodeServlet",
    urlPatterns = {"/form.BadCodeServlet"})
public class BadCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BadCodeServlet gcs = new GoodCodeServlet();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String title = "Code Sample";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) +
                "<BODY BGCOLOR=\"FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<PRE>\n" +
                gcs.getCode(req) +
                "</PRE>\n" +
                "Now, wasn't that an interesting samole\n" +
                "of code?\n" +
                "</BODY></HTML>");
    }

    protected String getCode(HttpServletRequest req){
        return req.getParameter("code");
    }
}
