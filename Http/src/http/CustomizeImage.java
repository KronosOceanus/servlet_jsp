package http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Referer实际上就是URL
 */
@WebServlet(name = "http.CustomizeImage",
    urlPatterns = {"/http.CustomizeImage"})
public class CustomizeImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //实际上就是URL
        String referer = req.getHeader("Referer");
        if (referer == null){
            referer = "<I>none</I>";
        }
        String title = "Referring page: " + referer;
        String imagePath = null;
        //页面URL包含Img_1字符串
        if (referer.contains("Img_1")){
            //资源文件相对路径写法（同级无法访问）
            imagePath = "images/timg.jpg";
        }else if (referer.contains("Img_2")){
            imagePath = "images/网易云看板娘.jpg";
        }

        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<CENTER><H2>" + title + "</H2>\n" +
                "<IMG SRC=\"" + imagePath + "\">\n" +
                "</CENTER></BODY></HTML>");
    }
}
