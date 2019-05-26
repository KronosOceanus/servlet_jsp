package form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 获取并显示所有参数
 */
@WebServlet(name = "form.ShowParams",
    urlPatterns = {"/form.ShowParams"})
public class ShowParams extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        /**
         * 向浏览器发送中文时
         * 用setCharacterEncoding方法指定getWriter方法返回的PrintWriter对象所使用的字符集编码
         */
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String title = "Reading All Request Parameters";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TR BGCOLOR=\"#FFAD00\">" +
                "<TH>Parameter Name<TH>Parameter Value(s)");

        //枚举迭代器（得到所有的参数名）
        Enumeration paramNames = req.getParameterNames();
        while(paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            //表格中的key（/tr，/td直接被下一个tr，td覆盖）
            out.println("<TR><TD>" + paramName + "\n<TD>");
            String[] paramValues = req.getParameterValues(paramName);
            if(paramValues.length == 1){
                String paramValue = paramValues[0];
                out.println(paramValue);
            }else if(paramValues.length == 0){
                out.println("<I>No Value</I>");
            }else {
                out.println("<UL>");
                for (String paramValue : paramValues) {
                    out.println("<LI>" + paramValue + "</LI>");
                }
                out.println("</UL>");
            }
        }
        out.println("</TABLE>\n</BODY></HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 请求的数据时作为请求体的一部分传递给服务器的
         * 所以只要修改请求内的编码
         */
        req.setCharacterEncoding("UTF-8");
        doGet(req,resp);
    }
}
