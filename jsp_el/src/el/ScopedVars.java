package el;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * 访问作用域变量
 */
public class ScopedVars extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("attribute1","First Value");
        HttpSession session = req.getSession();
        session.setAttribute("attribute2","Second Value");
        ServletContext application = getServletContext();
        application.setAttribute("attribute3",new Date());
        //设置重名作用域变量
        req.setAttribute("repeated","Request");
        session.setAttribute("repeated","Session");
        application.setAttribute("repeated","ServletContext");

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/scoped-vars.jsp");
        dispatcher.forward(req,resp);
    }
}
