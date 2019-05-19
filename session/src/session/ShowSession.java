import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String heading;
        Integer accessCount =
                (Integer)session.getAttribute("accessCount");
        if (accessCount == null){
            accessCount = 0;
            heading = "Welcome, Newcomer";
        }else {
            heading = "Welcome Back";
            accessCount = accessCount + 1;
        }

        session.setAttribute("accessCount",accessCount);
        PrintWriter out = resp.getWriter();
        String title = "Session Trancking Example";
        out.println();
    }
}
