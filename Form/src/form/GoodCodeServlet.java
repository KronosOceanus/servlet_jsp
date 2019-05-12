package form;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤并还原参数中的特殊字符
 */
public class GoodCodeServlet extends BadCodeServlet {

    @Override
    protected String getCode(HttpServletRequest req) {
        return ServletUtils.filter(super.getCode(req));
    }
}
