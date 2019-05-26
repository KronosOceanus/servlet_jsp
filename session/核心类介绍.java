HttpSession 会话对象
    通过req.getSession方法得到
        系统从Cookie或者附加URL数据中提取出用户的ID，之后以该ID为键。
        访问之前创建的HttpSession对象组成的表。
        如果找不到会话ID，则会创建一个新的空会话
        如果不想创建新的空会话（如打印会话中已经存在的信息），
            使用getSession(false)方法即可

核心方法！：只能在发送任何其文档内容到客户程序之前调用req.getSession

HttpSeesion只存在于服务器端，不在网络上传送
    通过某种后台运作机制（如Cookie或者URL重写）
    自动与客户关联在一起，拥有内建数据结构（散列表）
    查找储存的值时使用Object session.getAttribute("key")方法
    不存在返回null，所以使用前先进行判断

指定关联信息用setAttribute方法
    让希望与会话关联起来的对象实现HttpSessionBindingListener接口
    如果分布式架构中的属性，则需要实现Serializable接口

废除会话用removeAttribute方法
    或者删除整个会话
    将用户从系统中注销并删除所有属于他的会话
