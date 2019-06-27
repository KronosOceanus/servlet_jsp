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
import java.util.Collection;

public class DeleteServlet extends HttpServlet {

    private UserService uS;

    @Override
    public void init() throws ServletException {
        uS = new UserServiceImpl(new UserDaoImpl(), new IDCardDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int id = 0;
        User user = null;

        try {
            id = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException e){
            resp.sendRedirect("Error.jsp");
        }

        user = uS.findById(id);
        if (user != null){
            uS.deleteById(id);

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
