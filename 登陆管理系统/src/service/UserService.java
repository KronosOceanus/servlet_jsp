package service;

import entity.User;

import java.util.Collection;

public interface UserService {

    //根据账号判断是否存在
    boolean isExist(User user);
    //插入用户（插入前先设置外键引用）
    User insert(User user);
    //根据id删除（级联删除）
    int deleteById(int id);
    //查找所有用户
    Collection<User> findAll();
    //通过id查找用户
    User findById(int id);
    //通过账号查找用户
    User findByAccount(String account);
    //通过昵称查找用户
    User findByUserName(String username);
    //修改用户信息
    int update(User user);
}
