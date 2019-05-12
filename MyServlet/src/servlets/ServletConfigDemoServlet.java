package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

//注解部署
@WebServlet(name = "servlets.ServletConfigDemoServlet",
    urlPatterns = {"/servlets.ServletConfigDemoServlet"},
    initParams = {
        @WebInitParam(name="admin",value="Harry Taciak"),
            @WebInitParam(name="email",value="admin@example.com")
    })
public class ServletConfigDemoServlet implements Servlet {
    //封装@WebServlet中的部署信息
    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
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

    @Override
    public String getServletInfo() {
        return "ServletConfig Demo";
    }

    @Override
    public void destroy() {

    }
}
