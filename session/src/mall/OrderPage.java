package mall;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;

/**
 * 购物清单页面
 * 将商品添加到购物车
 * 结算界面Checkout.html
 */
public class OrderPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart cart;
        synchronized (session){
            //会话跟踪购物车
            cart = (ShoppingCart)session.getAttribute("shoppingCart");
            if (cart == null){
                cart = new ShoppingCart();
                session.setAttribute("shoppingCart",cart);
            }
            //隐藏域提交的itemID
            String itemID = req.getParameter("itemID");
            if (itemID != null){
                String numItemsString = req.getParameter("numItems");
                if (numItemsString == null){
                    cart.addItem(itemID);
                }else {
                    int numItems;
                    try {
                        numItems = Integer.parseInt(numItemsString.trim());
                    }catch (NumberFormatException e){
                        numItems = 1;
                    }
                    cart.setNumOrdered(itemID,numItems);
                }
            }
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Status of Your Order";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n");
        synchronized (session){
            List<ItemOrder> itemsOrdered = cart.getItemsOrdered();
            if (itemsOrdered.size() == 0){
                out.println("<H2><I>No items in your cart...</I></H2>");
            }else {
                out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                        "<TR BGCOLOR=\"#FFAD00\">\n" +
                        "   <TH>Item ID<TH>Description\n" +
                        "   <TH>Unit Cost<TH>Number<TH>Total Cost");
                //输出购物清单
                for (ItemOrder order : itemsOrdered){
                    out.println("<TR>\n" +
                            "   <TD>" + order.getItemID() + "\n" +
                            "   <TD>" + order.getShortDescription() + "\n" +
                            "   <TD>" + order.getUnitCost() + "\n" +
                            "   <TD>" +
                            "<FORM>\n" +
                            "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n" +
                            "   VALUE=\"" + order.getItemID() + "\">\n" +
                            "<INPUT TYPE=\"TEXT\" NAME=\"numItems\"\n" +
                            "   SIZE=3 VALUE=\"" + order.getNumItems() + "\">\n" +
                            "<SAMLL>\n" +
                            "<INPUT TYPE=\"SUBMIT\"\n" +
                            "   VALUE=\"Update Order\">\n" +
                            "</SAMLL>\n" +
                            "</FORM>\n" +
                            "   <TD>" + order.getTotalCost());
                }
                String checkoutURL = "/Checkout.html";
                out.println("</TABLE>\n" +
                        "<FORM ACTION=\"" + checkoutURL + "\">\n" +
                        "<BIG><CENTER>\n" +
                        "<INPUT TYPE=\"SUBMIT\"\n" +
                        "   VALUE=\"Proceed to Checkout\">\n" +
                        "</CENTER></BIG></FORM>");
            }
            out.println("</BODY></HTML>");
        }
    }
}
