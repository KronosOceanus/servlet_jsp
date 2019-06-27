package controller;

import dao.IDCardDaoImpl;
import dao.UserDaoImpl;
import entity.User;
import service.IDCardService;
import service.IDCardServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SelectServlet extends HttpServlet {

    private UserService uS;

    @Override
    public void init() throws ServletException {
        uS = new UserServiceImpl(new UserDaoImpl(), new IDCardDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        //删除方式
        String method = req.getParameter("method");
        HttpSession session = req.getSession();

        if (method.equals("id")){
            String id = req.getParameter("id");
            if (id != null && ! id.trim().equals("")){
                user = uS.findById(Integer.parseInt(id));
            }
        }else if (method.equals("account")){
            String account = req.getParameter("account");
            if (account != null && ! account.trim().equals("")){
                user = uS.findByAccount(account);
            }
        }else if (method.equals("username")){
            String username = req.getParameter("username");
            if (username != null && ! username.trim().equals("")){
                user = uS.findByUserName(username);
            }
        }

        //删除成功，设置会话跟踪，跳转页面
        if (user != null) {
            session.setAttribute("user", user);

            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/LoginResult/Select.jsp");
            dispatcher.forward(req, resp);
        }else {
            resp.sendRedirect("Error.jsp");
        }
    }
}
