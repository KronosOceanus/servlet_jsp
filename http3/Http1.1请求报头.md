# HTTP 1.1 请求报头

* Allow：
    指定服务器支持的请求方法（GET,POST等）
* Cache-Control：
    告诉浏览器或者其他客户，什么环境可以安全地缓存文档
    * public 可以缓存
    * private 适合单个用户，私有缓存
    * no-cache 文档不能被缓存，规定使用缓存的响应文档时应该略去的报头
    * no-store 不缓存文档，防止疏忽产生的敏感数据副本
    * must-revalldate 使用文档时，客户必须由原服务器（非代理）验证访问
    * proxy-revalldate 只适用于共享文档，其他与上一个相同
    * max-age=xxx xxx秒后，将文档认做失败
    * s-max-age=xxx 共享缓存在xxx秒之后，将文档认做失败
* Connection：
    持续性连接：
        Connection: close/keep-alive
* Content-Disposition：
    要求浏览器询问客户，将相应储存在磁盘上给定名称的文件中，
        Content-Disposition: attachment; filename=<filename>
* Content-Encoding：
    页面传输过程中使用的编码方式，浏览器应该决定如何处理文档之前先逆向编码
* Content-Language：
    文档使用的语言
* Content-Type：
    响应文档的MIME类型（见MIME类型文件）
* Expires：
    规定内容的过期时间，从而不需要继续缓存
* Last-Modified：
    标明文件的最后修改时间
* Location：
    状态代码在300-399之间的所有相应都应该包括这个报头，通知浏览器文档地址，
        浏览器自动重新连接到这个地址
* Pragma：
    将值设为no-cache，表示Http1.0客户不要缓存文档
* Refresh：
    标明浏览器应该多长时间之后请求最新的页面，以秒为单位
* Retry-After：
    可以和503响应结合使用，告诉客户程序多久之后可以重复它的请求
* Set-Cookie：
    指定一个与页面相关联的Cookie
* WWW-Authenticate：
    总是和401状态代码一同使用
