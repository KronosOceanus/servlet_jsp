[TOC]
## response
代表服务器对客户端请求的响应
#### 执行过程
运行时将response中的数据与tomcat引擎信息封装成http响应
#### OutputStream
可以通过字节流向客户端输出文件

## request
代表客户端的请求，
不仅可以获取请求头，请求行，请求体，还可以获取客户端的信息（如 IP 地址）
#### 请求转发
不仅可以转发到jsp，还可以转发到servlet