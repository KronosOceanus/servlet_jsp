package form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 展示保险公司员工个信息
 */
@WebServlet(name = "form.SubmitInsuranceInfo",
    urlPatterns = {"/form.SubmitInsuranceInfo"})
public class SubmitInsuranceInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建对象并封装信息
        InsuranceInfo info = new InsuranceInfo();
        BeanUtilities.populateBean(info,req);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Insurance Info for " + info.getName();
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<CENTER>\n" +
                "<H1>" + title + "</H1>\n" +
                "<UL>\n" +
                "   <LI>Employee ID: " + info.getEmployeeID() + "</LI>\n" +
                "   <LI>Number of chidren: " + info.getNumChildren() +"</LI>\n" +
                "   <LI>Married?: " + info.isMarried() + "</LI>\n" +
                "</UL></CENTER></BODY></HTML>");
    }
}
