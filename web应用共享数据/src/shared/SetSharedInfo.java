package shared;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SetSharedInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("sessionTest","Session Entry One");
        ServletContext context = getServletContext();
        context.setAttribute("servletContextTest","Servlet Context Entry One");

        //用系统默认路径创建Cookie（该目录或者该目录的子目录）
        Cookie c1 = new Cookie("cookieTest1","CookieOne");
        c1.setMaxAge(3600);
        resp.addCookie(c1);
        Cookie c2 = new Cookie("cookieTest2","CookieTwo");
        c2.setMaxAge(3600);
        //向所有访问该主机web应用的客户端发送Cookie
        c2.setPath("/");
        resp.addCookie(c2);

        //得到展示页面的url
        String url = req.getContextPath() + "/shared.ShowSharedInfo";
        //将url转换（编码）成重定向url
        url = resp.encodeRedirectURL(url);
        //通过重定向，把Context传递到下一个Web应用
        resp.sendRedirect(url);
    }
}
