package compare;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据长度生成质数公钥
 * 基于application的数据共享
 */
public class PrimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String length = req.getParameter("primeLength");
        ServletContext context = getServletContext();
        //注意ServletContext要同步
        synchronized (this){
            //与session相似
            if (context.getAttribute("primeBean") == null ||
                length != null){
                PrimeBean primeBean = new PrimeBean(length);
                context.setAttribute("primeBean",primeBean);
            }
        }
        String address = "/WEB-INF/mvc-sharing/ShowPrime.jsp";
        RequestDispatcher dispatcher =
                req.getRequestDispatcher(address);
        dispatcher.forward(req,resp);
    }
}
