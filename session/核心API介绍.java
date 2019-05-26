HttpSession类的方法
    Object getAttribute(String key)
        得到属性，没有则null
    Enumeration getAttributeNames()
        返回会话中所有属性的名称
    void setAttribute(String key,Object value)
        设置属性
    void removeAttribute(String key)
        移除属性
    void invalidate()
        将会话作废，并释放所有与之相关联的对象（会话与客户程序相关联的）
    void logout()
        将客户从Web服务器中注销，并将与该客户相关联的所有会话作废
    String getId()
        返回每个会话所对应的唯一标识符
    boolean isNew()
        如果会话尚未和客户程序发生任何联系，则返回true
    long getCreationTime()
        返回会话首次构建的时间
    long getLastAccessedTime()
        返回会话最后被客户程序访问的时间
    int getMaxInactiveInterval()
        setter
        读取或设置在没有访问的情况下，会话在被自动废弃之前应该保持多长时间
            会话超时，则会被销毁