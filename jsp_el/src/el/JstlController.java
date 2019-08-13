package el;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "el.JstlController",
    urlPatterns = "/el.JstlController")
public class JstlController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("obj",null);

        //遍历 List
        List<String> list = new ArrayList<>();
        list.add("string1");
        list.add("string2");
        req.setAttribute("list",list);

        //遍历 Map
        Map<String, String> map =  new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        req.setAttribute("map", map);

        String address = "/WEB-INF/jstl-bean.jsp";
        RequestDispatcher dispatcher =
                req.getRequestDispatcher(address);
        dispatcher.forward(req, resp);
    }
}
