package form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 若参数不完全
 * 重新显示表单（之后使用重定向）
 */
@WebServlet(name = "form.BidServlet",
    urlPatterns = {"/form.BidServlet"})
public class BidServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BidInfo bid = new BidInfo();
        BeanUtilities.populateBean(bid,req);
        if(bid.isComplete()){
            showBid(req,resp,bid);
        }else {
            showEntryForm(req,resp,bid);
        }
    }

    //展示完全表单
    private void showBid(HttpServletRequest req,
                         HttpServletResponse resp,
                         BidInfo bid) throws IOException {
        submitBid(bid);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Bid Submitted";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BODY BGCOLOR=\"#FDF5E6\"><CENTER>\n" +
                "<H1>" + title + "</H1>\n" +
                "Your bid is now active. If your bid is successful,\n" +
                "you will be notified within 24 hours of the close\n" +
                "of bidding.\n" +
                "<P>\n" +
                "<TABLE BORDER=1>\n" +
                "   <TR><TH BGCOLOR=\"BLACK\"><FONT COLOR=\"WHITE\">" +
                bid.getItemName() + "</FONT>\n" +
                "   <TR><TH>Item ID: " + bid.getItemID() + "\n" +
                "   <TR><TH>Name: " + bid.getBidderName() + "\n" +
                "   <TR><TH>Email address: " + bid.getEmailAddress() + "\n" +
                "   <TR><TH>Bid price: $ " + bid.getBidPrice() + "\n" +
                "   <TR><TH>Auto-increment price: " + bid.isAutoIncrement() + "\n" +
                "</TABLE></CENTER></BODY><HTML>");

    }

    //展示不完全的表单，再次收集数据并提交
    private void showEntryForm(HttpServletRequest req,
                               HttpServletResponse resp,
                               BidInfo bid) throws IOException {
        //判断状态，以供下次提交
        boolean ispartlyComplete = bid.isPartlyComplete();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Welcome to Auctions-R-Us. Please Enter Bid.";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BODY BGCOLOR=\"#FDF5E6\"><CENTER>\n" +
                "<H1>" + title + "</H1>\n" +
                warning(ispartlyComplete) +
                "<FORM>\n" +
                inputElement("Item ID","itemID",
                        bid.getItemID(),ispartlyComplete) +
                inputElement("Item Name","itemName",
                        bid.getBidderName(),ispartlyComplete) +
                inputElement("Your Name","bidderName",
                        bid.getBidderName(),ispartlyComplete) +
                inputElement("Your Email Address","emailAddress",
                        bid.getEmailAddress(),ispartlyComplete) +
                inputElement("Amount Bid","bidPrice",
                        bid.getBidPrice(),ispartlyComplete) +
                checkbox("Auto-increment bid to match other bidders ?",
                        "autoIncrement",bid.isAutoIncrement()) +
                "<INPUT TYPE=\"SUBMIT\" VALUE=\"Submit Bid\">\n" +
                "</CENTER></BODY></HTML>");
    }

    private void submitBid(BidInfo bid){
    }

    //警告信息
    private String warning(boolean isFormParlyComplete){
        if (! isFormParlyComplete){
            return "<H2>Required Data Missing! " +
                    "Enter and Resubmit.</H2>\n";
        }else {
            return "";
        }
    }

    /**
     * 参数不完全处理（再次修改）
     * 参数（表单参数名称，输入框name，参数内容，是否需要提示输入）
     */
    private String inputElement(String prompt,String name,
                                String value, boolean shouldPrompt){
        String message = "";
        if(shouldPrompt && ((value == null) || value.equals(""))){
            message = "<B>Required field!</B> ";
        }
        return message + prompt + ": " +
                "<INPUT TYPE=\"TEXT\" NAME=\"" + name + "\"" +
                "VALUE=\"" + value + "\"><BR />\n";
    }

    //参数不完全处理重载
    private String inputElement(String prompt,String name,
                                double value,boolean shouldPrompt){
        String num;
        if(value == 0.0){
            num = "";
        }else {
            num = String.valueOf(value);
        }
        return inputElement(prompt,name,num,shouldPrompt);
    }

    //多选框参数处理
    private String checkbox(String prompt, String name,boolean isChecked){
        String result = prompt + ": " +
                "<INPUT TYPE=\"CHECKBOX\" NAME=\"" + name + "\"";
        if (isChecked){
            //添加属性（被选中）
            result = result + " CHECKED";
        }
        result = result + "><BR />\n";
        return result;
    }
}
