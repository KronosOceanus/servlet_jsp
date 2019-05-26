[TOC]

# Model View Controller（bean-jsp-servlet）（MVC模式）

## 步骤

### 1.定义bean表示数据

### 2.使用serlvet处理请求（servlet不创建任何输出）

### 3.填写bean

### 4.将bean储存到
* 请求（HttpServletRequest）（对应scope属性的request）
* 会话（HttpSession）（session）
* 或servlet的上下文（ServletContext）（application）中
##### servlet创建和储存数据
```java
ValueObject value = new ValueObject(...);
request.setAttribute("key",value);
```
##### sevlet把请求转发给jsp页面，jsp页面检索语句
```jsp
<jsp:useBean id="key" type="somePackage.ValueObject" 
    scope="request" />
```

### 5.将请求转发到jsp页面
* *如果jsp页面只在servlet生成数据的上下文中才有意义，则放入WEB-INF目录*
* *使用RequestDispatcher的forward方法时，客户看到的是初始servlet的URL，而非jsp页面的URL*
##### 示例（forward转发请求）
```java
public void doGet(HttpServletRequest request,
                HttpServletResponse response)
    throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if(operation == null){
            operation = "unknown";
        }
        String address;
        if(operation.equals("order")){
            address = "/WEB-INF/Order.jsp";
        }else if(operation.equals("cancel")){
            address = "/WEB-INF/Cancel.jsp";
        }else{
            address = "/WEB-INF/UnkonwnOperation.jsp";
        }
        //得到RequestDispatcher并将请求控制权转交给jsp页面
        RequestDispatcher dispatcher =
            req.getParameter(address);
        dipatcher.forward(request,response);
    }
```
1. 如果要转发到html页面 *（不能处理POST请求）* ，则需要将html页面扩展名改为jsp
2. 使用重定向代替转发（与forward对比）

| 对比 | forward（转向） | sendRedirect（重定向） |
| ------ | ------ | ------ |
| 说明 | 将现在的请求转交 | 相当于重发一个请求 |
| 是否会丢失请求信息 | 不会 | 会 |
| 控制转移 | 完全在服务器上进行，| 向客户端发送302和 |
|           |不涉及网络数据流 | Location报头来完成 |
| jsp页面地址 | 用户不会看到，| 能看到，|
|           | 可以将jsp放入WEB-INF中 | 适用于重新显示不完全的表单 |

### 6.从bean中提取数据   
* jsp页面不创建对象，所以应该使用     
```jsp
<jsp:useBean ... type="package.Class" />
```
而不是
```jsp
<jsp:useBean ... class="package.Class" />
```
* jsp页面不修改对象，因此只应该使用jsp:getProperty，不应该用到setter



## 代码汇总（三种数据共享）
### Servlet（ServletContext要synchronized(this)）
```java
ValueObject value = new ValueObject(...);
/**
* 为了让jsp能访问到value的数据，
* 利用setAttribute方法将数据储存在某个标准位置
* 其他两种形式，依次把request换成session,getServletContext
*/
request.setAttribute("key",value);
RequestDispatcher dispatcher = 
    request.getRequestDispatcher("/WEB-IFN/SomePage.jsp");
//将请求转交到目标地址
dispatcher.forward(request,response);
```
### jsp
```
<jsp:useBean id="key" type="somePackage.ValueObject"
          scope="request" />
<jsp:getProperty name="key" property="someProperty" />
```

## 相对URL
link的样式单，img图片，a的超链接中所使用的的地址，最好直接给出服务器上的完整路径

## 从jsp页面转发请求
```jsp
<jsp:forward page="address" />
```
如同jsp:include，可以使用jsp:param为页面提供额外的请求参数

## 包含页面
* 转发(forward)的一种替代方案是包含(include)，使用包含，可以将它自身的输出一个或多个jsp页面组合在一起。
实际上RequestDispatcher的include方法就是
```jsp
<jsp:include page="address" />
```
* 用Servlet创建门户网站，由用户选择希望在页面上显示那种内容时适用

例: 
```java
if(someCondition){
    firstTable = address1;
    secondTable = address2;
    //……
}else if(...){...}
//标题
RequestDispatcher dispatcher =
    req.getRequestDispathcer(headerAddress);
dispatcher.include(req,resp);

dispatcher =
    req.getRequestDispatcher(address1);
dispatcher.include(req,resp);

dispatcher =
    req.getRequestDispatcher(address2);
dispatcher.include(req,resp);

dispatcher =
    req.getRequestDispatcher(footerAddress);
dispatcher.include(req,resp);
```