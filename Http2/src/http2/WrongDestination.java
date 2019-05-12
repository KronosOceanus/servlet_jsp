package http2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向Servlet
 */
@WebServlet(name = "http2.WrongDestination",
    urlPatterns = {"/http2.WrongDestination"})
public class WrongDestination extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userAgent = req.getHeader("User-Agent");
        //如果是IE浏览器
        if (userAgent != null && userAgent.contains("MISE")){
            //设置重定向
            resp.sendRedirect("https://www.csdn.net/");
        }else {
            resp.sendRedirect("https://translate.google.cn/");
        }
    }
}
