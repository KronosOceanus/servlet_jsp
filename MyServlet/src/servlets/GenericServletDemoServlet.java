package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlets.ServletConfigDemoServlet",
        urlPatterns = {"/servlets.ServletConfigDemoServlet"},
        //初始化参数
        initParams = {
                @WebInitParam(name="admin",value="Harry Taciak"),
                @WebInitParam(name="email",value="admin@example.com")
        })
public class GenericServletDemoServlet extends GenericServlet {

    private static final long serialVersionUID = 62500890L;

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        //得到初始化参数
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");
        //设置响应内容类型
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.println(ServletUtils.headWith("用户名和邮箱") +
                "Admin:" + admin +
                "<br />Email:" + email +
                "</body></html>");
    }
}
