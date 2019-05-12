package http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "http.LongServlet",
 urlPatterns = {"/http.LongServlet"})
public class LongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out;

        //是否支持Web页面压缩
        if (GzipUtilities.isGzipSupported(req) &&
            GzipUtilities.isGzipDisabled(req)){
            out = GzipUtilities.getGzipWriter(resp);
            //设置压缩页面
            resp.setHeader("Content-Encoding","gzip");
        }
        out = resp.getWriter();


        String title = "Long Page";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n");
        String line = "Blah,blah,blah,blah,blah." +
                "Yadda,yadda,yadda,yadda,yadda";
        for (int i=0;i<10000;i++){
            out.println(line);
        }
        out.println("</BODY></HTML>");
        //gzipWriter需要关闭（其他流可选）
        out.close();
    }
}
