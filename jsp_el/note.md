[TOC]
# EL表达式

## 阻止标准脚本元素的使用
web.xml中代码如下
```xml
<jsp-property-group>
    <url-partten>*.jsp</url-partten>
    <scription-invalid>true</scription-invalid>
</jsp-property-group>
```

## 访问作用域变量
在request（或者其他两个）中的对象称作“作用域变量”
* 输出作用域变量的值: **${name}**，表示在PageContext,HttpServletRequest,HttpSession和ServletContext中依次查找名为name的属性

所以不论属性储存在哪个作用域中，访问方法都相同

## 访问bean属性
* 用法: **${name.property}**
* 可以多层嵌套
* 数组计法: **${name["property"]}**

## 访问集合
* **${attributeName[entryName]}**
* 如果作用域变量为数组，则entryName为索引，例: *${array[0]}*
* 如果作用域变量为实现List接口的对象，使用方法与数组类似
* 如果为Map，则entryName为key，也可以使用点号计法，例: *${map.key}*

## 隐式对象
* **pageContext**
    引用当前页面的PageContext，依次拥有request,response,out,servletContext属性（可以用对应的getter方法得到）
* **param和paramValues**
    访问基本的请求参数或参数数组，例:*${param.custID}*输出custID参数的值
* **header和headerValues**
    访问http请求报头的主要值和全部值，如果合法，可以使用点号计法
* **cookie**
    快捷的引用输入cookie，但是返回值是Cookie对象，不是cookie的值，如需要访问值，则需要使用value属性，例:*${cookie.userCookie.value}*
* **initParam**
    访问上下文初始化参数(context,initialization parameter)，例:*${initParam.defaultColor}*输出初始化参数defaultColor的值
* **pageScope,requestScope,sessionScope和applicationScope**
    限定系统应该在什么地方查找作用域变量，例:*${requestScope.name}*表示系统只在HttpServletRequest
    
## 运算符
都在${}中
* **+和-**
    字符串+-运算会自动解析成数值，BigInteger等会自动使用相应的add和substract方法
* ***，/和div**
    div也是除法
* **==和eq**
    类似于equals方法
* **!=和ne**
    !equals
* **>和lt，<和gt，<=和le，>=和ge**
* **&&，and，||，or，!和not**
* **empty**
    如果为空，返回true
    
## 条件求值
可以使用 **?:三目运算符**，例:${ text ? expression1 : expression2 }

# JSTL
相当于 MyBatis 的动态 SQL，可以使用 EL 表达式