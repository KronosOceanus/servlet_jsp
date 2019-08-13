package controller;

import dao.IDCardDaoImpl;
import dao.UserDaoImpl;
import entity.User;
import service.IDCardService;
import service.IDCardServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import utils.MD5Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class LoginServlet extends HttpServlet {

    private UserService uS;
    //初始化接口
    @Override
    public void init() throws ServletException {
        uS = new UserServiceImpl(new UserDaoImpl(), new IDCardDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setAccount(req.getParameter("account"));
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        String address = null;
        if (isExist(user)){
            user = findByAccount(user.getAccount());
            if(isMatched(user, password)) {
                address = "/Main.jsp"; //展示页面
                Collection<User> result = uS.findAll();
                //会话共享
                session.setAttribute("users", result);
            }else {
                address = "/WEB-INF/LoginResult/LoginFailed.jsp";
                session.setAttribute("users", null);
            }
        }else {
            address = "/WEB-INF/LoginResult/LoginFailed.jsp";
            session.setAttribute("users",null);
        }

        RequestDispatcher dispatcher =
                req.getRequestDispatcher(address);
        dispatcher.forward(req, resp);
    }













    //用户名是否存在（存在则查询出来赋值给user）
    private boolean isExist(User user) {
        return uS.isExist(user);
    }
    //根据账号得到User
    private User findByAccount(String account){
        return uS.findByAccount(account);
    }
    //密码是否正确
    private boolean isMatched(User user, String password){
        return MD5Utils.MD5Encode(password,"utf-8")
                .equals(user.getPassword());
    }
}
