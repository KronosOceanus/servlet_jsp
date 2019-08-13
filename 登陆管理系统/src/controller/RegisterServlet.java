package controller;

import dao.IDCardDaoImpl;
import dao.UserDaoImpl;
import entity.IDCard;
import entity.User;
import service.IDCardService;
import service.IDCardServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import utils.AssociateUtils;
import utils.BeanUtilities;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UserService uS;
    private IDCardService iS;

    @Override
    public void init() throws ServletException {
        uS = new UserServiceImpl(new UserDaoImpl(), new IDCardDaoImpl());
        iS = new IDCardServiceImpl(new IDCardDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        IDCard idCard = new IDCard();
        //得到两个Bean
        BeanUtilities.dividePopulateBean(user, idCard, req);
        //设置关联
        AssociateUtils.setBeforeAssociate(user, idCard);

        String address = null;
        if (isExist(user)){
            address = "/WEB-INF/RegisterResult/RegisterFailed.jsp";
        }else {
            address = "/WEB-INF/RegisterResult/RegisterSuccessful.jsp";
            uS.insert(user);
        }

        RequestDispatcher dispatcher =
                req.getRequestDispatcher(address);
        dispatcher.forward(req, resp);
    }














    //用户和身份证是否已存在
    private boolean isExist(User user){
        return uS.isExist(user) || iS.isExist(user.getIdCard());
    }
}
