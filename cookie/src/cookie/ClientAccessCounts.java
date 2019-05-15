package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 记录用户的访问次数
 * 删除Cookie，setMaxAge为0即可
 */
public class ClientAccessCounts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countString =
                CookieUtils.getCookieValue(req,
                        "accessCount","1");
        int count = 1;
        try{
            count = Integer.parseInt(countString);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        //创建一个新的Cookie，计数并发送（相当于替换）
        LongLivedCookie c = new LongLivedCookie("accessCount",String.valueOf(count + 1));
        resp.addCookie(c);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Access Count Servlet";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<CENTER>\n" +
                "<H2>This is visit number " + count + " by this browser.</H2>\n" +
                "</CENTER></BODY></HTML>");
    }
}
