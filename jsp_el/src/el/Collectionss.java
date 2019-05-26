package el;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 访问集合
 */
public class Collectionss extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] firstName = {"Bill", "Scott", "Larry"};
        List<String> lastName = new ArrayList<>();
        lastName.add("Ellison");
        lastName.add("Gates");
        lastName.add("McNealy");
        Map<String,String> companyNames = new HashMap<>();
        companyNames.put("Ellison","Sun");
        companyNames.put("Gates","Oracle");
        companyNames.put("McNealy","Microsoft");
        req.setAttribute("first",firstName);
        req.setAttribute("last",lastName);
        req.setAttribute("company",companyNames);

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/collectionss.jsp");
        dispatcher.forward(req,resp);
    }
}
