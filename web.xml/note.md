[TOC]
## web.xml简介
控制Web应用程序，有如下作用：
* 重新分配URL
* 指定整个Web应用和特定Servlet的初始化参数
* 控制session会话的失效时间
* 声明过滤器
* 声明安全角色
* 通过声明安全角色来限制Web应用资源的访问权限
等

***注意：xml是大小写敏感的***

## web.xml元素（都是可选元素）
* servlet和servlet-mapping：
    先命名sevlet或者jsp页面，便可以配置一个或多个URL（多个使用通配符 *）
        ，可以将servlet-class换成jsp-file完成jsp的url映射
* context-param：
    声明应用程序范围内的初始化参数
* filter和filter-mapping：
    将一个名称和实现了Filter接口的类关联起来。命名过滤器时，可以用filter
        -mapping元素将名称与一个或多个servlet关联到jsp页面
* error-page
    指明在返回某个HTTP错误代码或者某些类型的异常被抛出的时候显示的页面
* security-constraint：
    指定非授权用户不能访问的URL，需结合login-config元素使用
* login-config：
    指定服务器验证尝试访问受保护页面用户的身份的方式
* secutiry-role：
    该元素必须使用web.xml中所有security-constraint元素中auth-constraint
        元素的role-name子元素显示声明的角色名称，还可以列出将出现在
            servlet元素中的security-role-ref元素的子元素role-name中
                安全角色的名称
* session-config：
    指定session的默认失效时间
* icon：
    指定一个或多个图片文件的位置，这样ide可以用它表示Web应用程序
* display-name：
    提供了一个用来标识Web应用程序的图形化用户接口工具的名称
* description：
    提供Web应用程序的说明文本
* mime-mapping：
    如果Web应用程序包含一些不常用的文件，需要确保分配某些MIME类型
* jsp-config：
    为Web有应用程序中的jsp页面提供配置信息，包括两个子元素：**taglib**
        为标签库（TLD）描述文件分配别名，在更改TLD文件路径时就无须
            修改使用了这些页面的jsp页面；**jsp-property-group**可以
                方便地对多个具有相同属性的jsp统一定义一组对应的url
                    对jsp进行属性配置
* locale-encoding-mapping-list：
    使用一个或多个locale-encodingmapping元素设置默认的区域编码
* listener：
    指定一个事件监听器类，监控Web生命周期事件，如ServletContext或
        HttpSession第一次初始化或者销毁
* distributable：
    标明Web应用程序在一个群集中跨多个服务器分配是否安全
* env-entry：
    声明Web应用程序环境条目
* ejb-ref：
    声明了一个企业bean的远程地址引用
* ejb-local-ref：
    声明了一个企业bean的**本地**地址引用
* service-ref：
    声明一个Web服务引用
* resource-ref：
    使用资源工厂声明一个外部资源的引用
* resource-env-ref：
    声明一个与一个资源关联的管理对象引用
* message-destination-ref：
    声明一个与资源相关的消息和目标引用
* message-distination：
    定义一个合法的消息和目标名
    
## 禁用默认url
创建一个新的错误页面映射覆盖当前路径（只能禁用默认的url）

## 设置初始化参数
* 在servlet标签子标签init-param中可以设置（param-name/param-value）多个
    初始化参数，如果是jsp页面初始化，只需要将servlet-class改为jsp-file
* 可以在servlet的init方法中使用getServletConfig().getInitParameter("")
    来得到初始化参数（jsp页面中是jspInit方法）

## 服务器启动时加载servlet
* 在servlet标签中使用子标签load-on-startup，元素内容是数值，服务器启动时
    优先加载数值较小的servlet/jsp
