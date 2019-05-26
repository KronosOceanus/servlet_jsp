package session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 累计用户数据的列表
 * 收集newItem参数，添加到该Servlet的会话中
 * 提交newItem参数的页面OrderForm.html
 */
public class ShowItems extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<String> previousItems =
                (ArrayList<String>)session.getAttribute("previousItems");
        if (previousItems == null){
            previousItems = new ArrayList<>();
            //可变对象属性，只需要设置一遍
            session.setAttribute("previousItems",previousItems);
        }

        String newItem = req.getParameter("newItem");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Items Purchased";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n");
        //对会话中的集合同步处理，自动更新到会话中
        synchronized (previousItems){
            if (newItem != null && !newItem.trim().equals("")){
                previousItems.add(newItem);
            }
            if (previousItems.size() == 0){
                out.println("<I>No items</I>");
            }else {
                out.println("<UL>");
                for (String s : previousItems){
                    out.println("<LI>" + s);
                }
                out.println("</UL>");
            }
        }
        out.println("</BODY></HTML>");
    }
}
