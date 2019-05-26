package jsp_java;

import org.apache.jasper.runtime.HttpJspBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * SomeHeading.jsp等价的Servlet代码
 */
public class SomeHeading extends HttpJspBase {

    private String randomHeading(){
        return "<H2>" + Math.random() + "</H2>";
    }
    @Override
    public void _jspService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        out.println("<H1>Some Heading</H1>");
        out.println(randomHeading());
    }
}
