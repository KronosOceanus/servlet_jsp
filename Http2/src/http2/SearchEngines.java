package http2;

import http2.SearchUtilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 一站式搜索
 */
@WebServlet(name = "http2.SearchEngines",
    urlPatterns = {"/http2.SearchEngines"})
public class SearchEngines extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchString = req.getParameter("searchString");
        if (searchString == null){
            reportProblem(resp,"Missing search string");
            return;
        }
        searchString = URLEncoder.encode(searchString,"UTF-8");

        String searchEngineName = req.getParameter("searchEngine");
        if (searchEngineName == null){
            reportProblem(resp,"Missing search engine name");
            return;
        }

        String searchURL = SearchUtilities.makeURL(searchEngineName,searchString);
        if (searchURL != null){
            resp.sendRedirect(searchURL);
        }else {
            reportProblem(resp,"Unrecognized search engine");
        }
    }

    //向客户端发送参数未找到信息
    private void reportProblem(HttpServletResponse resp,
                               String message) throws IOException{
        resp.sendError(resp.SC_NOT_FOUND,message);
    }
}
