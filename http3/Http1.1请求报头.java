Allow
    指定服务器支持的请求方法（GET,POST等）
Cache-Control
    告诉浏览器或者其他客户，什么环境可以安全地缓存文档
    * public 可以缓存
    * private 适合单个用户，私有缓存
    * no-cache 文档不能被缓存，规定使用缓存的响应文档时应该略去的报头
    * no-store 不缓存文档，防止疏忽产生的敏感数据副本
    * must-revalldate 使用文档时，客户必须由原服务器（非代理）验证访问
    * proxy-revalldate 只适用于共享文档，其他与上一个相同
    * 