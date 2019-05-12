package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlets.LotteryNumbers",
    urlPatterns = {"/servlets.LotteryNumbers"} )
public class LotteryNumbers extends HttpServlet {
    private long modTime;
    private int[] numbers = new int[10];

    @Override
    public void init() throws ServletException {
        //初始化成员变量
        modTime = System.currentTimeMillis()/1000*1000;
        for(int i=0;i<10;i++){
            numbers[i] = randomNum();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "your lottery numbers";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) +
                "<BODY BGCOLOR=\"FDF5E6\">" +
                "<H1 ALEGN=CENTER>" + title + "</H1>" +
                "<B>Based upon extensive research of……</B>" +
                "<OL>");
        for (int i=0;i<10;i++){
            out.println("<LI>" + numbers[i] + "</LI>");
        }
        out.println("</OL>" + "</BODY></HTML>");
    }

    public long getLastModified(HttpServletRequest request){
        return modTime;
    }
    private int randomNum(){
        return ((int)(Math.random() * 100));
    }
}
