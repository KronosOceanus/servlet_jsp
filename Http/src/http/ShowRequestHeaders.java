package http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "http.ShowRequestHeaders",
    urlPatterns = {"/http.ShowRequestHeaders"})
public class ShowRequestHeaders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Servlet Example: Showing Request Headers";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<B>Request URL: </B>" + req.getMethod() + "<BR />\n" +
                "<B>Request URL: </B>" + req.getRequestURL() + "<BR />\n" +
                "<B>Request Protocol: </B>" + req.getProtocol() + "<BR />\n" +
                "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>Header Name</TH>Header Value");

        Enumeration headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = (String)headerNames.nextElement();
            out.println("<TR><TD>" + headerName);
            out.println("    <TD>" + req.getHeader(headerName));
        }
        out.println("</TABLE>\n</BODY></HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req, resp);
    }
}
