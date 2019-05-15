package cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 确认是否是初次访问者
 */
public class RepeatVisitor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断是否是初次访问者的flag
        boolean newbie = true;
        //得到浏览器所有Cookie
        Cookie[] cookies = req.getCookies();
        //执行判断
        if (cookies != null){
            for (Cookie c : cookies){
                if (c.getName().equals("repeatVisitor") &&
                c.getValue().equals("yes")){
                    newbie = false;
                    break;
                }
            }
        }

        String title;
        if (newbie){
            //使用指定名称和值创建一个Cookie
            Cookie returnVisitorCookie = new Cookie("repeatVisitor","yes");
            //设置Cookie存在一年
            returnVisitorCookie.setMaxAge(60 * 60 * 24 * 365);
            //发送Cookie到浏览器（放入报头）
            resp.addCookie(returnVisitorCookie);
            title = "Welcome Aboard";
        }else {
            title = "Welcome Back";
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "</BODY></HTML>");
    }
}
