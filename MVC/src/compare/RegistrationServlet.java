package compare;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 显示注册者的姓名
 * 基于session的数据共享
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        NameBean nameBean = (NameBean) session.getAttribute("nameBean");
        if (nameBean == null){
            //不存在则新建一个bean添加到session中
            nameBean = new NameBean();
            session.setAttribute("nameBean",nameBean);
        }
        String firstName = req.getParameter("firstName");
        if (firstName != null && ! firstName.trim().equals("")){
            nameBean.setFirstName(firstName);
        }
        String lastName = req.getParameter("lastName");
        if (lastName != null && ! lastName.trim().equals("")){
            nameBean.setLastName(lastName);
        }

        String address = "/WEB-INF/mvc-sharing/ShowName.jsp";
        RequestDispatcher dispatcher =
                req.getRequestDispatcher(address);
        dispatcher.forward(req,resp);
    }
}
