package dao;
import entity.*;

import java.util.Collection;

public interface UserDao {

    //是否存在该用户
    boolean isExist(User user) throws Exception;
    //插入用户
    User insert(User user) throws Exception;
    //根据id删除
    int deleteById(int id) throws Exception;
    //查找所有用户
    Collection<User> findAll() throws Exception;
    //通过id查找用户
    User findById(int id) throws Exception;
    //通过账号查找用户
    User findByAccount(String account) throws Exception;
    //通过昵称查找用户
    User findByUserName(String username) throws Exception;
    //修改用户信息（昵称，邮箱，电话）
    int update(User user) throws Exception;
}
