package session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 抽象基类
 * 显示待售商品的Servlet将它用作起点
 * 接收待售商品的ID，在分类表中查找它们
 * 并根据找出的描述和价格，提供给用户一个订单界面
 * CatalogItem, Catalog
 */
public abstract class CatalogPage extends HttpServlet {

    //列表项，列表ID，网页标题
    private CatalogItem[] items;
    private String[] itemIDs;
    private String title;

    //根据ID为列表项赋值
    protected void setItems(String[] itemIDs){
        this.itemIDs = itemIDs;
        items = new CatalogItem[itemIDs.length];
        for (int i=0;i<items.length;i++){
            items[i] = Catalog.getItem(itemIDs[i]);
        }
    }

    //设置网页标题
    protected void setTitle(String title){
        this.title = title;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果列表项为空，404
        if (items == null){
            resp.sendError(resp.SC_NOT_FOUND,"Missing Items");
            return;
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n");
        CatalogItem item;
        for (int i=0;i<items.length;i++){
            out.println("<HR>");
            //单个列表项赋值
            item = items[i];
            //根据ID查找不到的话，输出ID
            if (item != null){
                out.println("<FONT COLOR=\"RED\">" +
                        "Unknown item ID " + itemIDs[i] + "</FONT>");
            }else {
                out.println();
                //提交商品的表单URL
                String formURL = "session.OrderPage";
                //引用自身站点，可能使用URL重写实现会话跟踪，预先URL编码
                formURL = resp.encodeURL(formURL);
                //输出商品的各种信息
                out.println("<FORM ACTION=\"" + formURL + "\">\n" +
                        "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"" +
                        "   VALUE=\"" + item.getItemID() + "\">\n" +
                        "<H2>" + item.getShortDescription() + "\n" +
                        "   {$" + item.getCost() + "}</H2>\n" +
                        "<P>\n<CENTER>\n" +
                        "<INPUT TYPE=\"SUBMIT\"" +
                        "VALUE=\"Add to Shopping Cart\">\n" +
                        "</CENTER>\n<P>\n</FORM>");
            }
        }
        out.println("</HR>\n</BODY></HTML>");
    }
}
