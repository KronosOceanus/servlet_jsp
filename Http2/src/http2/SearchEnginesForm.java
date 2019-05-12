package http2;

import http2.SearchSpec;
import http2.SearchUtilities;
import http2.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 一站式搜索HTML表单
 */
@WebServlet(name = "http2.SearchEnginesForm",
 urlPatterns = {"/http2.SearchEnginesForm"})
public class SearchEnginesForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //提交到另一个Servlet
        String actionURL = "http2.SearchEngines";
        String title = "One-Stop Web Search!";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<CENTER>\n" +
                "<H1>" + title + "</H1>\n" +
                "<FORM ACTION=\"" + actionURL + "\">\n" +
                "   Search keywords: \n" +
                "   <INPUT TYPE=\"TEXT\" NAME=\"searchString\"><P>\n");
        SearchSpec[] searchSpecs = SearchUtilities.getCommonSpecs();
        //选择搜索站点
        for (SearchSpec spec : searchSpecs){
            out.println("<INPUT TYPE=\"RADIO\"" +
                    "NAME=\"searchEngine\"" +
                    "VALUE=\"" + spec.getName() + "\">\n");
            out.println(spec.getName() + "<BR />\n");
        }
        out.println("<BR />   <INPUT TYPE=\"SUBMIT\">\n" +
                "</FOMR>\n" +
                "</CENTER></BODY></HTML>");
    }
}
