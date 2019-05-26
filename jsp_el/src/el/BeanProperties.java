package el;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 访问bean属性
 * EmployeeBean,NameBean,CompanyBean
 */
public class BeanProperties extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NameBean name = new NameBean("Marty","Hall");
        CompanyBean company = new CompanyBean("coreservlets.com",
                "J2EE Training and Consulting");
        EmployeeBean employee = new EmployeeBean(name,company);

        req.setAttribute("employee",employee);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/bean-properties.jsp");
        dispatcher.forward(req,resp);
    }
}
