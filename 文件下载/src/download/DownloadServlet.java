package download;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 中文：
 * 服务器：编码前
 * 浏览器：编码后
 */
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获得文件名（潮田渚.png）
        String fileName = req.getParameter("filename");


        //浏览器编码后的文件名（????.jpg）
        String fileNameEncode = "";
        //判断浏览器（不同浏览器的编码不同），得到返回后端的文件名
        String agent = req.getHeader("User-Agent");
        if (agent.contains("MSIE")){
            fileNameEncode = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
            fileNameEncode = fileNameEncode.replace("+", " ");
        }else {
            fileNameEncode = URLEncoder.encode(fileName,StandardCharsets.UTF_8);
        }


        //设置要下载文件的类型（客户端通过 MIME 区分类型）
        resp.setContentType(this.getServletContext().
                getMimeType(fileName)); //通过文件名称获得 MIME 类型
        //告诉客户端不直接解析（该 filename 是报头固定的）
        resp.setHeader("Content-Disposition", "attachment;filename=" + fileNameEncode);
        //得到文件绝对路径（包含指定目录的绝对路径）
        String path = this.getServletContext().getRealPath("download/" + fileName);


        //输入流读取文件
        InputStream in = new FileInputStream(path);
        //输出流把文件放到服务器上
        ServletOutputStream out = resp.getOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while((len = in.read(buffer)) > 0){
            //写入文件到服务器
            out.write(buffer, 0, len);
        }
    }
}
