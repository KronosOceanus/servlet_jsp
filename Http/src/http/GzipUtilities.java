package http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * gzip工具类
 */
public class GzipUtilities {

    //浏览器是否支持gzip
    public static boolean isGzipSupported(HttpServletRequest req){
        String encodings = req.getHeader("Accept-Encoding");
        return encodings != null &&
                encodings.contains("gzip");
    }

    //用户是否禁用gzip
    public static boolean isGzipDisabled(HttpServletRequest req){
        String flag = req.getParameter("disableGzip");
        return flag != null &&
                ! flag.equalsIgnoreCase("false");
    }

    //得到gzipWriter
    public static PrintWriter getGzipWriter(HttpServletResponse resp)
        throws IOException{
        return new PrintWriter(new GZIPOutputStream(resp.getOutputStream()));
    }
}
