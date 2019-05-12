package form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 获取并显示三个参数
 */
@WebServlet(name = "form.ThreeParams",
    urlPatterns = {"/form.ThreeParams"})
public class ThreeParams extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Reading Three Request Parameters";
        //getParameter参数对应表单的name属性
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<UL>\n" +
                "   <LI><B>param1</B></LI>:" +
                req.getParameter("param1") + "\n" +
                "   <LI><B>param2</B></LI>:" +
                req.getParameter("param2") + "\n" +
                "   <LI><B>param3</B></LI>:" +
                req.getParameter("param3") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }
}
