package controller;

import dao.RoleDaoImpl;
import pojo.PageBean;
import pojo.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 分页查询 Servlet
 */
@WebServlet(name = "controller.PageSelectServlet",
    urlPatterns = {"/controller.PageSelectServlet"})
public class PageSelectServlet extends HttpServlet {

    //测试 url：http://localhost:8080/_war_exploded/controller.PageSelectServlet?pageNumber=2
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取分页参数
        String pageNumberStr = req.getParameter("pageNumber");
        int pageNumber = 1;
        try{
            pageNumber = Integer.parseInt(pageNumberStr);
        }catch (Exception ignored){}
        int pageSize = 2;

        //分页查询
        PageBean<Role> pageBean = null;
        try {
            RoleDaoImpl roleDao = new RoleDaoImpl();
            pageBean = roleDao.findAll(pageNumber, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //共享变量，请求转发
        req.setAttribute("pageBean", pageBean);
        req.getRequestDispatcher("/WEB-INF/role_list.jsp").forward(req, resp);
    }
}
