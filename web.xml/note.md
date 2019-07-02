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

## web.xml元素简介（都是可选元素）
* servlet和servlet-mapping：
    先命名sevlet或者jsp页面，便可以配置一个或多个URL（多个使用通配符 *）
        ，可以将servlet-class换成jsp-file完成jsp的url映射
* context-param：
    声明应用程序范围内的初始化参数
* filter和filter-mapping：
    将一个名称和实现了Filter接口的类关联起来。命名过滤器时，可以用filter
        -mapping元素将名称与一个或多个servlet关联到jsp页面
* error-page：
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
    
## 禁用默认url NoInvoker
创建一个新的错误页面映射覆盖当前路径（只能禁用默认的url）

## 设置初始化参数（init-param）
* 在servlet标签子标签init-param中可以设置（param-name/param-value）多个
    初始化参数，如果是jsp页面初始化，只需要将servlet-class改为jsp-file
* 可以在servlet的init方法中使用getServletConfig().getInitParameter("")
    来得到初始化参数（jsp页面中是jspInit方法）

## 服务器启动时加载servlet（load-on-startup）
* 在servlet标签中使用子标签load-on-startup，元素内容是数值，服务器启动
    时优先加载数值较小的servlet/jsp

## 过滤器
创建过程：
* 实现Filter接口
* 重写doFilter方法
* 在web.xml中配置

执行过程：
* 关联servlet/jsp页面执行之前运行
* 执行FilterChain对象的doFilter方法
* 逐个运行，直到没有过滤器为止

作用：
* 访问request对象，完成检查客户端主机名，查找进入的cookie等操作
* 检查输出时，ServletResponse对象封装到一个替代对象中，如：
  将输出内容集中到缓存中，在调用doFilter方法后，过滤器检查缓存，
  必要时进行修改，然后将其输出到客户端
  
## 提供安全支持 login-config
login-config的子元素：auth-method，real-name，form-login-config
#### auth-method
值：
* BASIC：
    密码简单可逆的64位编码方式来发送，对于嗅探Internet连接不安全
* DIGEST：
    使用加密摘要身份验证表单来传输用户名和密码，不支持
* FORM：
    验证一个保留的会话cookie同时在用户没有正确登陆时转到一个指定
        的登录页面（普通的表单），登录后，可以通过保留的cookie来跟踪用户
            信息，很安全，还可以附加SSL或者IPSec/VPN保护
* CLIENT-CERT：
    必须使用HTTPS（HTTP + SSL）和共有的密钥证书来验证用户，提供强大的
        安全性来对付网络拦截
        
#### real-name
在auth-method的子元素为BASIC时才使用，分配安全领域名，此名称提供浏览器用
    于对话框标题，且为Authorization的一部分

#### form-login-config
当auth-method为FORM时，指定两个页面：
* 包含获取用户登录信息的表单（通过form-login-page子元素配置）,该表单必须
    有一个值为j_security_check的Action属性，名为h_username的文本域和名为
        j_password的密码域
* 显示验证错误（form-error-page）

## 限制访问Web资源（security-constraint）
配置并描述某些URL需要得保护
#### web-resource-collection
标识需要保护的资源，至少包含一个该元素
* web-resoure-name：
    标识名
* url-pattern：
    需要保护的url，特殊情况下，不能应用于jsp:forward访问的页面
* http-method（可选）
    保护指定的HTTP命令（GET/POST等，默认是所有）
* description
    提供文本说明
    
#### auth-constraint
配置哪些用户可以访问被保护资源
* role-name（可多个）：
    标识有权访问资源的用户类型，该元素名必须是在security-role元素中全局声
        名的（security-role直接在web-app下，包含一/多个role-name）
* description（可选）：
    描述这个角色
    
## 指定角色名称（security-role（servlet的子元素））
为security-role下安全角色名列表中的安全角色提供一个别名，使之能够在
    servlet中使用别名被调用（例：在第三方servlet中通过别名alias调用
        administrator角色）
```java
    request.isUserInRole("alias");
```
```xml
    <security-role-ref>
        <role-name>alias</role-name>
        <role-link>administrator</role-link>
    </security-role-ref>
```
## 控制会话失效时间（session-config）
* session-timeout：
    设定失效时间（0/负数表示不会失效），而setMaxInactiveInterval方法只有0
        不会失效
        
## 为Web应用程序提供文件
web.xml中可以应用于可视化开发环境的元素
#### icon
为GUI工具标识Web应用的一个或两个图片文件的位置，这些图片只在ide中使用
* small-icon：
    大小为 16 × 16 的 gif/jpeg 图片
* large-icon：
    大小为 32 × 32 的 gif/jpeg 图片
    
#### display-name
标识Web应用的名称

#### description
提供文本解释

## 使用MIME类型关联文件
#### mine-mapping
某个文件发送在客户端时指定某个MIME类型
* extension：
    文件扩展名
* mine-type：
    指定的 mime 类型
    
## 配置jsp页面（jsp-config）
#### taglib
* taglib-uri：
    为TLD文件指定一个相对Web应用程序根目录的路径
* taglib-location：
    TLD文件的实际路径
    
之后便可以在jsp中通过下面的指令使用标签库
```jsp
    <@ taglib uri="/taglib-uri" prefix="somePrefix %>"
```

#### jsp-property-group（可多个）
* url-pattern：
    指定应用到某个jsp页面
* el-ignored（boolean）：
    是否关闭匹配到的jsp页面中的el表达式，若只想关闭某个页面的el表达式，
        可用如下方法（会覆盖该元素）：
```jsp
    <@ page isELIgnored="true" %>
```
* page-encoding：
    指定jsp页面的编码格式，同样可以选择只在某个页面中使用
* scripting-invalid（boolean）：
    设置为true时，只要jsp使用脚本就会产生一个转化时错误 
* is-xml（boolean）：
    是否为jsp文档（包含xml）
* include-prelude：
    包含一个必须与Web应用程序中一个资源对应的context-relative路径，可以为
        一组jsp页面指定头部
* include-coda：
    为一组jsp页指定页脚

## 配置应用程序事件监听器
#### listener
* listener-class：
    指定监听器类
    




    
    












