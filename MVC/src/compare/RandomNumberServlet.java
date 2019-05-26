package compare;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 每个请求产生一个随机数
 * 基于request的数据共享
 */
public class RandomNumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对于每个请求生成一个随机数
        NumberBean bean = new NumberBean(Math.random());
        req.setAttribute("randomNum",bean);
        String address = "/WEB-INF/mvc-sharing/RandomNum.jsp";
        RequestDispatcher dispatcher =
                req.getRequestDispatcher(address);
        //将请求转交到目标地址
        dispatcher.forward(req,resp);
    }
}
