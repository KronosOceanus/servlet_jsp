package controller;

import dao.IDCardDaoImpl;
import dao.UserDaoImpl;
import entity.IDCard;
import entity.User;
import service.UserService;
import service.UserServiceImpl;
import utils.AssociateUtils;
import utils.BeanUtilities;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

public class UpdateServlet extends HttpServlet {

    private UserService uS;

    @Override
    public void init() throws ServletException {
        uS = new UserServiceImpl(new UserDaoImpl(), new IDCardDaoImpl());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据jsp页面传输过来的隐藏表单得到User（这样才有id）
        User user = uS.findByAccount(req.getParameter("account"));
        //得到更改后的User
        BeanUtilities.populateBean(user, req);
        HttpSession session = req.getSession();

        int rows = uS.update(user);
        //修改成功，返回主页面
        if (rows != 0){
            Collection<User> result = uS.findAll();
            session.setAttribute("users", result);
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/Main.jsp");
            dispatcher.forward(req, resp);
        }else {
            resp.sendRedirect("Error.jsp");
        }
    }
}
