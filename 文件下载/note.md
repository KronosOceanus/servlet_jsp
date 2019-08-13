[TOC]
## servlet下载文件
以超链接的形式打开
#### 浏览器不能解析
直接下载
#### 不能解析需要编写代码
1. 超链接直接附加文件参数
```html
    <a href="/download.DownloadServlet?filename=timg.jpg">timg.jpg</a>
```
2. 通过req获取文件参数名称，并且注意编码格式
```java
    //未编码的文件名
    String fileName = req.getParameter("filename");
```
3. 根据浏览器采取不同的编码格式
```java
    //浏览器编码后的文件名（????.jpg）
    String fileNameEncode = "";
    //判断浏览器（不同浏览器的编码不同）
    String agent = req.getHeader("User-Agent");
    if (agent.contains("MSIE")){
        fileNameEncode = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        fileNameEncode = fileNameEncode.replace("+", " ");
    }else {
        fileNameEncode = URLEncoder.encode(fileName,StandardCharsets.UTF_8);
    }
```
4. 设置文件MIME类型
```java
    resp.setContentType(this.getServletContext().
            getMimeType(fileName));
```
5. 设置http响应报头。告知客户端不直接解析
```java
    resp.setHeader("Content-Disposition",
            "attachment;filename=" + fileNameEncode);
```
6. 得到文件绝对路径
```java
    String path = this.getServletContext().
            getRealPath("download/" + fileName);
```
7. 将文件通过io写入客户端

#### 编码问题
中文：
* 服务器：编码前
* 浏览器：编码后