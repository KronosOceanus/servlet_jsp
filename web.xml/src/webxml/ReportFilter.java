package webxml;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * 过滤器（需要在web.xml中声明）
 * 拦截和修改servlet/jsp页面的输入请求和输出响应
 * 每个页面执行之前先执行（所有）过滤中FilterChain对象的doFilter方法
 * 直到没有其他过滤器
 *
 * 可以访问ServletRequest对象，完成检查客户端主机名，查找进入的cookie等操作
 *
 * 检查输出时，ServletResponse对象封装到一个替代对象中，如：
 * 将输出内容集中到缓存中，在调用doFilter方法后，过滤器检查缓存，
 * 必要时进行修改，然后将其输出到客户端
 */
public class ReportFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        System.out.println(req.getRemoteHost() +
                " tried to access " +
                req.getRequestURL() +
                " on " + new Date() + ".");
        filterChain.doFilter(req,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
