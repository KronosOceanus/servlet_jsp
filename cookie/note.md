## Cookie简介
Cookie实际上是客户端上的一些文本文件（key - value），只能保存少量信息，每个value
的长度最大为 **4 KB**

## Cookie属性

**注意！：属性是服务器发送到浏览器报头的一部分，但不属于浏览器返回给服务器的报头**

以下都是setter或getter方法，（）中是setter方法的参数

* Comment：
    指定或者查找Cookie相关的注释，纯粹用于信息目的，储存在服务器，不发送给客户
* Domain(String domainPattern)：
    设置或读取Cookie使用的域，一般浏览器值将Cookie返回给主机名与发送该Cookie的
        主机名完全相同的主机（返回相同的页面），设置域可以让Cookie返回不同的页面，
            pattern必须以.开始（如.coreservlets.com），非国家域必须包含两个.（如
                .com，.edu，.gov），国家域三个（如.co.uk，.edu.es）
* setMaxAge(int lifetime)：
    规定Cookie多长时间后到期，负值（默认）表示仅仅用于当前会话，不储存到磁盘
* Name（只有getter，因为名称是构造器设置的）：
    读取Cookie的名称
* Path(String path)：
    设置或者取得Cookie所适用的路径（自动包括子路径），如果没有指定，浏览器只将该
        Cookie返回给发送该Cookie页面所在的目录中或者之下的URL（子目录）,使用"/"
            表示该服务器的所有目录（实现web应用之间数据共享）
* Secure(boolean secureFlag)：
    表示Cookie是否只能通过加密连接（即SSL）发送，默认false，表示适用于所有连接
* Value(String cookieValue)：
    指定与该Cookie相关联的值/找出这个值
* Version(int version)：
    设置和去的Cookie遵从的Cookie协议版本，默认版本0