package bank;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 显示余额的页面
 */
public class ShowBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankCustomer customer = BankCustomer.getCustomer(req.getParameter("id"));
        String address;
        if (customer == null){
            address = "/WEB-INF/bank-account/UnknownCustomer.jsp";
        }else if (customer.getBalance() < 0){
            address = "/WEB-INF/bank-account/NegativeBalance.jsp";
            //在forward发送请求前，添加一个请求参数
            req.setAttribute("badCustomer",customer);
        }else if (customer.getBalance() < 10000){
            address = "/WEB-INF/bank-account/NormalBalance.jsp";
            req.setAttribute("regularCustomer",customer);
        }else {
            address = "/WEB-INF/bank-account/HighBalance.jsp";
            req.setAttribute("eliteCustomer",customer);
        }

        RequestDispatcher dispatcher =
                req.getRequestDispatcher(address);
        dispatcher.forward(req,resp);
    }
}
