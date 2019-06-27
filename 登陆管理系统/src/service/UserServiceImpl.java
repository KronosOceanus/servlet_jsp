package service;

import dao.IDCardDao;
import dao.UserDao;
import entity.IDCard;
import entity.User;
import utils.MD5Utils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collection;

public class UserServiceImpl implements UserService {

    private UserDao uDao;
    private IDCardDao iDao;
    private IDCardService iS;
    public UserServiceImpl(UserDao uDao, IDCardDao iDao){
        this.uDao = uDao;
        this.iDao = iDao;
        iS = new IDCardServiceImpl(iDao);
    }

    @Override
    public boolean isExist(User user){
        try {
            return uDao.isExist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //该User参数需要设置外键引用
    @Override
    public User insert(User user){
        //先判断是否存在，存在则直接查询返回（设置外键引用）
        if (isExist(user)){
            try {
                return setAfterAssociate(uDao.findByAccount(user.getAccount()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        IDCard idCard = iS.insert(user.getIdCard());
        //设置外键再插入
        user.setId_card_fk(idCard.getId());
        try {
            return uDao.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteById(int id){
        User user = null;
        try {
            user = uDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (uDao.isExist(user)){
                int rows = uDao.deleteById(id);
                if (iDao.isExist(iDao.findById(user.getId_card_fk()))){
                    iDao.deleteById(user.getId_card_fk());
                }
                return rows;
            }else return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Collection<User> findAll(){
        try {
            return setAfterAssociate(uDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(int id) {
        try {
            return setAfterAssociate(uDao.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByAccount(String account){
        try {
            return setAfterAssociate(uDao.findByAccount(account));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByUserName(String username){
        try {
            return setAfterAssociate(uDao.findByUserName(username));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(User user){
        try {
            if(uDao.isExist(user)){
                return uDao.update(user);
            }else return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



    //查询后设置外键引用
    private Collection<User> setAfterAssociate(Collection<User> users)
        throws Exception{
        for (User user : users){
            user.setIdCard(iDao.findById(user.getId_card_fk()));
        }
        return users;
    }
    private User setAfterAssociate(User user)
        throws Exception{
        user.setIdCard(iDao.findById(user.getId_card_fk()));
        return user;
    }
}
