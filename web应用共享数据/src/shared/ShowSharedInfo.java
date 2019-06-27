package shared;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ShowSharedInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Shared Info";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) +
                "<BODY BGCOLOR = \"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<UL>\n" +
                "<LI>Session:");

        HttpSession session = req.getSession();
        Enumeration attributes = session.getAttributeNames();
        out.println(getAttributeList(attributes));


        out.println( "<LI>Current Servlet Context: ");
        //得到所有Web应用共享到此页面的数据
        ServletContext application = getServletContext();
        attributes = application.getAttributeNames();
        out.println(getAttributeList(attributes));


        out.println(" <LI>Servlet Context of /shareTest1: ");
        //得到某个Web应用共享到此页面数据
        application = application.getContext("/shareTest1");
        if (application == null){
            out.println("Context sharing disabled");
        }else {
            attributes = application.getAttributeNames();
            out.println(getAttributeList(attributes));
        }

        //输出使用Cookie共享到此页面的数据
        out.println(" <LI>Cookies: </LI>");
        Cookie[] cookies = req.getCookies();
        if ( cookies == null || cookies.length == 0){
            out.println(" <LI>No cookies found");
        }else {
            for (Cookie cookie : cookies){
                out.println(" <LI>" + cookie.getName());
            }
        }
        out.println(" </UL>\n" +
                "</UL>\n" +
                "</BODY></HTML>");
    }

    private String getAttributeList(Enumeration attributes){
        StringBuffer list = new StringBuffer("<UL>\n");
        if (! attributes.hasMoreElements()){
            list.append("<LI>No attributes found.");
        }else {
            while(attributes.hasMoreElements()){
                list.append(" <LI>");
                list.append(attributes.nextElement());
                list.append("\n");
            }
        }
        list.append(" </UL>");
        return list.toString();
    }
}
