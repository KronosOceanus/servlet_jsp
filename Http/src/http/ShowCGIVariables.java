package http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 显示CGI变量
 */
@WebServlet(name = "http.ShowCGIVariables",
    urlPatterns = {"/http.ShowCGIVariables"})
public class ShowCGIVariables extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Map<String,String> variables = new HashMap<>();
            variables.put("AUTH_TYPE",req.getAuthType());
            variables.put("CONTENT_LENGTH",String.valueOf(req.getContentLength()));
            variables.put("CONTENT_TYPE",req.getContentType());
            variables.put("DOCUMENT_ROOT",getServletContext().getRealPath("/"));
            variables.put("PATH_INFO",req.getPathInfo());
            variables.put("PATH_TRANSLATED",req.getPathTranslated());
            variables.put("QUERY_STRING",req.getQueryString());
            variables.put("REMOTE_ADDR",req.getRemoteAddr());
            variables.put("REMOTE_HOST",req.getRemoteHost());
            variables.put("REMOTE_USER",req.getRemoteUser());
            variables.put("REQUEST_METHOD",req.getMethod());
            variables.put("SCRIPT_NAME",req.getServletPath());
            variables.put("SERVER_NAME",req.getServerName());
            variables.put("SERVER_PORT",String.valueOf(req.getServerPort()));
            variables.put("SERVER_PROTOCOL",req.getProtocol());
            variables.put("SERVER_SOFTWARE",getServletContext().getServerInfo());
        String title = "Servlet Example Showing CGI Variables";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BODY BGCOLOR\"#FDF5E6\">\n" +
                "<CENTER>\n" +
                "<H1>" + title + "</H1>\n" +
                "<TABLE BORDER=1>\n" +
                "   <TR BGCOLOR=\"#FFAD00\">\n" +
                "       <TH>CGI Variables Name<TH>Value");
        for (String key : variables.keySet()){
            out.println("  <TR><TD>" + key + "<TD>" + variables.get(key));
        }
        out.println("</TABLE></CENTER></BODY><HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req, resp);
    }
}
