[TOC]
## web.xml
#### 过滤器
* 与 Serlvet 配置相似
* 访问 url 匹配的页面之前，访问过滤器，执行 doFilter 方法
* 预处理 req / resp 信息
#### 监听器
* 配置监听器类
* 重写两个前后方法，在 web 应用程序启动 / 销毁时执行