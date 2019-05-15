package http3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 构建JPEG格式图片
 * MessageImage
 */
@WebServlet(name = "http.ShadowedText",
    urlPatterns = {"/http.ShadowedText"})
public class ShadowedText extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //展示字体种类列表
        String wantsList = req.getParameter("showList");
        if (wantsList != null){
            showFontList(resp);
        }
        //设置信息艺术字参数
        else {
            String message = req.getParameter("message");
            if (message == null){
                message = "Miss 'message' parameter";
            }
            String fontName = req.getParameter("fontName");
            if (fontName == null){
                fontName = "Serif";
            }
            String fontSizeString = req.getParameter("fontSize");
            int fontSize;
            try{
                fontSize = Integer.parseInt(fontSizeString);
            }catch (NumberFormatException e){
                fontSize = 20;
            }
            //发送JPEG图像
            resp.setContentType("image/jpeg");
            MessageImage.writeJPEG(
                    MessageImage.makeMessageImage(message,fontName,fontSize),
                    resp.getOutputStream());
        }
    }

    //展示字体种类列表
    private void showFontList(HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        String title = "Fonts Available on Server";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BG COLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<UL>");
        String[] fontNames = MessageImage.getFontNames();
        for (String name : fontNames){
            out.println("   <LI>" + name);
        }
        out.println("</UL>\n" +
                "</BODY><HTML>");
    }
}
