# Session介绍

## 核心类介绍
* HttpSession 会话对象
    通过req.getSession方法得到，
        系统从Cookie或者附加URL数据中提取出用户的ID，之后以该ID为键。
        访问之前创建的HttpSession对象组成的表。
        如果找不到会话ID，则会创建一个新的空会话，
        如果不想创建新的空会话（如打印会话中已经存在的信息），
            使用getSession(false)方法即可

  **核心方法！：只能在发送任何其文档内容到客户程序之前调用req.getSession**

* HttpSeesion只存在于服务器端，不在网络上传送，
    通过某种后台运作机制（如Cookie或者URL重写），
    自动与客户关联在一起，拥有内建数据结构（散列表），
    查找储存的值时使用Object session.getAttribute("key")方法，
    不存在返回null，所以使用前先进行判断。

* 指定关联信息用setAttribute方法，
    让希望与会话关联起来的对象实现HttpSessionBindingListener接口，
    如果分布式架构中的属性，则需要实现Serializable接口。

* 废除会话用removeAttribute方法，
    或者删除整个会话，
    将用户从系统中注销并删除所有属于他的会话。

# 核心API介绍
HttpSession类的方法
* Object getAttribute(String key)：
    得到属性，没有则null
* Enumeration getAttributeNames()：
    返回会话中所有属性的名称
* void setAttribute(String key,Object value)：
    设置属性
* void removeAttribute(String key)：
    移除属性
* void invalidate()：
    将会话作废，并释放所有与之相关联的对象（会话与客户程序相关联的）
* void logout()：
    将客户从Web服务器中注销，并将与该客户相关联的所有会话作废
* String getId()：
    返回每个会话所对应的唯一标识符
* boolean isNew()：
    如果会话尚未和客户程序发生任何联系，则返回true
* long getCreationTime()：
    返回会话首次构建的时间
* long getLastAccessedTime()：
    返回会话最后被客户程序访问的时间
* int getMaxInactiveInterval() /
    setter：
    读取或设置在没有访问的情况下，会话在被自动废弃之前应该保持多长时间
        ，会话超时，则会被销毁