## HTTP请求报头
* Accept-Charset：
    浏览器可以使用的字符集
* Accept-Encoding：
    详细列出客户端能够处理的编码类型，服务器可以自由使用其中一种
* Accept-Language：
    列出客户程序首选的语言，标准语言代码的一种
* Authorization：
    访问密码保护的Web页面，客户使用这个报头标识自己的身份
* Connection：
    客户是否能处理持续性HTTP连接（允许客户或其他浏览器在单个socket中读取多个文件，
        节省建立多个连接所需要的开销）每个HTTP连接会启动一个线程调用servlet的doXxx方法
* Content-Length：
    只适用于POST请求，给定数据的大小，以字节为单位（使用req.getContentLength方法得到）
* Cookie：
    向服务器返回Cookie（使用req.getCookies方法得到）
* Host：
    浏览器和其他客户程序需要指定这个报头，标明原始URL中给出的主机名和端口号
* If-Modified-Since：
    仅当页面在指定日期之后发生更改的情况下，客户程序才希望获取该页面，否则发送304，
        应该实现getLastModified方法，让系统自动处理修改日期（GET请求中）
* If-Unmodified-Since：
    指定日期之前（PUT请求中）
* Referer：
    标明引用Web页面的URL（上一个Web页面的URL），方便跟踪请求来源
* User-Agent：
    生成请求的浏览器或者其他客户程序，用来区分不同类别的客户程序
    
    
    
## GCI变量等价物
* AUTH_TYPE：
    给出Authorization报头指定的模式（basic/digest），用req.getAuthType访问
* CONTENT_LENGTH：
    由Content-Length请求报头给出，储存发送数据的字节数，
        getHeader得到String类型，一般使用req.getContentLength得到int类型
* CONTENT_TYPE：
    指定附加数据的MIME类型，用req.getContentType访问
* DOCUMENT_ROOT：
    指定与URL http:\\host\（反斜杠） 对应的实际目录
    用getServletContext.getRealPath("/")访问，用getServletContext.getRealPath将
        任意URL（主机名和端口号之后的URL后缀）映射到本地计算机实际路径
* HTTP_XXX_YYY：
    是CGI程序访问任意HTTP请求报头的方式，如Cookie报头成为HTTP_COOKIE……
    getHeader访问
* PATH_INFO：
    servlet地址之后，查询数据之前，附加到URL上的任何路径