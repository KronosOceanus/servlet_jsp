[TOC]
## web 应用共享数据
#### 设置共享数据
* 通过 Session / Cookie / ServletContext 设置共享数据
* 通过重定向发送并跳转到被共享页面（URL 需要编码成重定向 URL），展示数据
#### 被共享页面
 * 通过 req 获取 Session / Cookie 读取被共享的信息
 * 直接 getServletContext 方法获取 ServletContext