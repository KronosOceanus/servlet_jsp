使用URL重写实现会话跟踪时
    如果页面中含有指向自身所在站点的链接时，必须显示将会话数据添加到URL
    则不能拥有任何静态的HTML页面（或者指向自身的静态HTML页面）
        大部分页面都必须动态生成

以下是可能引用自身站点的URL
    第一种情况：Servlet生成的Web页面中含有嵌入的URL
        此时应该将这些URL传递给HttpServletResponse的encodeURL方法
        以确定当前是否在使用URL重写，否则直接返回传入的URL
    例：
    String originalURL = someRelativeOrAbsoluteURL;
    String encodedURL = resp.encodeURL(originalURL);
    out,println("<A HREF=\"" + encodedURL + "\">...</A>");

    第二种情况：在sendRedirect调用中（即放入Location响应报头）
        由于要根据不同的规则确定是否需要附加会话信息，所以不能使用encodeURL
        HttpServletResponse提供encodeRedirectURL方法处理这种情况
    例：
    String originalURL = someURL;
    String encodedURL = resp.encodeRedirectURL(originalURL);
    resp.sendRedirect(encodedURL);

如果认为自己的Web应用最终有可能使用URL重写代替Cookie
    最好预先对引用自身站点的URL进行编码