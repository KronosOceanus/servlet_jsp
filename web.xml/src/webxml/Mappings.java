package webxml;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 对应多映射 Servlet
 */
public class Mappings extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String url = req.getRequestURI();
        String title = "Servlet-Mappings";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) +
                url +
                "</BODY></HTML>");
    }
}
