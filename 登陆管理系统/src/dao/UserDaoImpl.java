package dao;

import entity.IDCard;
import entity.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.Collection;

public class UserDaoImpl extends CommonDaoImpl implements UserDao{

    private IDCardDao iDao = new IDCardDaoImpl();

    @Override
    public boolean isExist(User user) throws Exception {
        String sql = "select * from user where account = '" +
                user. getAccount() + "'";
        return getJDBCExector().query(sql, new BeanHandler<>(User.class)) != null;
    }

    @Override
    public User insert(User user) throws Exception {
        String sql = "insert into user values(?,?,MD5(?),?,?,?,?)";
        Object[] params = new Object[]{null,user.getAccount(),user.getPassword(),
            user.getUsername(),user.getEmail(),user.getPhone(),user.getId_card_fk()};
        user.setId(getJDBCExector().insert(sql,params));
        return user;
    }

    @Override
    public int deleteById(int id) throws Exception {
        String sql = "delete from user where id = " + id;
        return getJDBCExector().update(sql);
    }

    @Override
    public Collection<User> findAll() throws Exception {
        String sql = "select * from user";
        return getJDBCExector().query(sql, new BeanListHandler<>(User.class));
    }

    @Override
    public User findById(int id) throws Exception {
        String sql = "select * from user where id = " + id;
        return getJDBCExector().query(sql, new BeanHandler<>(User.class));
    }

    @Override
    public User findByAccount(String account) throws Exception {
        String sql = "select * from user where account = '" + account + "'";
        return getJDBCExector().query(sql, new BeanHandler<>(User.class));
    }

    @Override
    public User findByUserName(String username) throws Exception {
        String sql = "select * from user where username = '" + username +"'";
        return getJDBCExector().query(sql, new BeanHandler<>(User.class));
    }

    @Override
    public int update(User user) throws Exception {
        String sql = "update user set password = ?, username = ?," +
                "email = ?, phone = ? where id = " + user.getId();
        Object[] params = new Object[]{user.getPassword(), user.getUsername(),
            user.getEmail(), user.getPhone()};
        return getJDBCExector().update(sql, params);
    }
}
