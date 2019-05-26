使用cookie储存购物会话的ID；
    后续连接中，取出当前会话的ID；
    并使用这个ID从服务器上的查找表中提取出会话的相关信息
    （两个表）将会话ID与用户关联起来的表，储存用户具体数据的表

例（将会话ID放入关联的表，再放入Cookie中发送给浏览器）：
    //生成标识字符串作为会话ID
    String sessionID = makeUniqueString();
    //储存用户具体数据的表
    HashMap sessionInfo = new HashMap();
    //得到储存会话关联信息的表（还未关联）
    HashMap globalTable = findTableStoringSessions();
    //关联
    globalTable.put(sessionID,sessionInfo);
    //将会话ID加入Cookie
    Cookie sessionCookie = new Cookie("JSESSIONID",sessionID);
    //设置Cookie可以返回的路径
    sessionCookie.setPath("/");
    resp.addCookie(sessionCookie);

然后，接下来的请求中，服务器可以使用globalTable散列表，
    将来自于JSESSIONID的Cookie中的会话ID与sessionInfo散列表中的的数据关联起来

还需要解决
    得到该Cookie
    确定空闲会话过期时间并回收
    将散列表与每个请求关联起来
    生成唯一的会话标识符
