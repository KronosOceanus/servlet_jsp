package form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 提交表单，得到参数
 */
@WebServlet(name = "form.SubmitResume",
    urlPatterns = {"/form.SubmitResume"})
public class SubmitResume extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        if(req.getParameter("previewButton") != null){
            //展示预览
            showPreview(req,out);
        }else {
            storeResume(req);
            //显示确认
            showConfirmation(req,out);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req,resp);
    }

    //展示预览
    private void showPreview(HttpServletRequest req, PrintWriter out){
        String headingFont = req.getParameter("headingFont");
        headingFont = replaceIfMissingOrDefault(headingFont,"");
        int headingSize = getSize(req.getParameter("headingSize"),32);

        String bodyFont = req.getParameter("bodyFont");
        bodyFont = replaceIfMissingOrDefault(bodyFont,"");
        int bodySize = getSize(req.getParameter("bodySize"),18);

        String fgColor = req.getParameter("fgColor");
        fgColor = replaceIfMissing(fgColor,"black");
        String bgColor = req.getParameter("bgColor");
        bgColor = replaceIfMissing(bgColor,"white");

        String name = req.getParameter("name");
        name = replaceIfMissing(name,"Lou Zer");
        String title = req.getParameter("title");
        title = replaceIfMissing(title,"Loser");
        String email = req.getParameter("email");
        email = replaceIfMissing(email,"contact@hot-ccmputers-jobs.com");

        String languages = req.getParameter("languages");
        languages = replaceIfMissing(languages,"<I>None</I>");
        String languageList = makeList(languages);
        String skills = req.getParameter("skills");
        out.println(ServletUtils.DOCTYPE +
                "<HTML><HEAD><TITLE>Resume for " + name + "</TITLE>\n" +
                makeStyleSheet(headingFont,headingSize,bodyFont,bodySize,fgColor,bgColor) +
                "</HEAD>\n" +
                "<BODY>\n" +
                "<CENTER>\n" +
                "<SPAN CLASS=\"HEADING1\">" + name + "</SPAN><BR />\n" +
                "<SPAN CLASS=\"HEADING2\">" + title + "<BR />\n" +
                "<A HEAF=\",ailto:" + email + "\">" + email +
                    "</A></SPAN>\n" +
                "<BR /><BR />\n" +
                "<SPAN CLASS=\"HEADING3\">Programming languages</SPAN>\n" +
                makeList(languages) + "<BR /><BR />\n" +
                "<SPAN CLASS=\"HEADING3\">Skills and Experience" +
                "</SPAN><BR /><BR />\n" +
                skills + "\n" +
                "</CENTER></BODY></HTML>");
    }

    //参数丢失替换
    private String replaceIfMissing(String orig,String replacement) {
        if ((orig == null) || (orig.trim().equals(""))) {
            return replacement;
        } else {
            return orig;
        }
    }

    //参数丢失/默认替换
    private String replaceIfMissingOrDefault(String orig,String replacement){
        if((orig == null) || (orig.trim().equals("")) ||
                (orig.equals("default"))){
            return replacement;
        }else{
            return orig + ",";
        }
    }

    //得到字符串ASCII总和
    private int getSize(String sizeString, int defaultSize){
        try{
            return Integer.parseInt(sizeString);
        }catch (NumberFormatException nfe){
            return defaultSize;
        }
    }

    /**
     * 将所有语言参数
     * 转换为HTML语言无序列表
     */
    private String makeList(String listItems){
        //将字符串根据指定分隔符，分解为标记
        StringTokenizer tokenizer = new StringTokenizer(listItems,",");
        String list = "<UL>\n";
        while(tokenizer.hasMoreTokens()){
            list = list + " <LI>" + tokenizer.nextToken() + "\n";
        }
        list = list + "</UL>";
        return list;
    }

    //根据参数制作css样式单
    private String makeStyleSheet(String headingFont,int headingSize, String bodyFont,
        int bodySize, String fgColor, String bgColor){
        int heading2Size = headingSize*7/10;
        int heading3Size = headingSize*6/10;
        String styleSheet = "<STYLE TYPE=\"text/css\">\n" +
                "<!-- \n>" +
                ".HEADING1 { fon-size:" + headingSize + "px;\n" +
                "           font-weight:bold;\n" +
                "           font-family:" + headingFont +
                            "Arial, Helvetice, sans-serif;\n" +
                "}\n" +
                ".HEADING2 { fon-size:" + heading2Size + "px;\n" +
                "           font-weight:bold;\n" +
                "           font-family:" + headingFont +
                "Arial, Helvetice, sans-serif;\n" +
                "}\n" +
                ".HEADING3 { fon-size:" + heading3Size + "px;\n" +
                "           font-weight:bold;\n" +
                "           font-family:" + headingFont +
                "Arial, Helvetice, sans-serif;\n" +
                "}\n" +
                "BODY { color:" + fgColor + ";\n" +
                "       background-color:" + bgColor + ";\n" +
                "       font-size:" + bodySize + "px;\n" +
                "       font-family:" + bodyFont +
                            "Times New Roman, Times, serif;\n" +
                "}\n" +
                "A:hover { color : red }\n" +
                "-->\n" +
                "</STYLE>";
        return styleSheet;
    }


    //显示确认信息网页
    private void showConfirmation(HttpServletRequest req,PrintWriter out){
        String title = "Submmission Confiremd.";
        out.println(ServletUtils.headWith(title) +
                "<BODY>\n" +
                "<H1>" + title + "</H1>\n" +
                "Your resume should appear online within\n" +
                "24 hours, If it doesn't, try submitting\n" +
                "again with a different email adress,\n" +
                "</BODY></HTML>" );
    }


    private void storeResume(HttpServletRequest req){
        String email = req.getParameter("email");
        putInSpamList(email);
    }

    //处理垃圾邮件
    private void putInSpamList(String emailAddress){

    }
}
