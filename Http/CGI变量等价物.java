AUTH_TYPE
    给出Authorization报头指定的模式（basic/digest），用req.getAuthType访问
CONTENT_LENGTH
    由Content-Length请求报头给出，储存发送数据的字节数，
        getHeader得到String类型，一般使用req.getContentLength得到int类型
CONTENT_TYPE
    指定附加数据的MIME类型，用req.getContentType访问
DOCUMENT_ROOT
    指定与URL http:\\host\（反斜杠） 对应的实际目录
    用getServletContext.getRealPath("/")访问，用getServletContext.getRealPath将
        任意URL（主机名和端口号之后的URL后缀）映射到本地计算机实际路径
HTTP_XXX_YYY
    是CGI程序访问任意HTTP请求报头的方式，如Cookie报头成为HTTP_COOKIE……
    getHeader访问
PATH_INFO
    servlet地址之后，查询数据之前，附加到URL上的任何路径
………………
………………