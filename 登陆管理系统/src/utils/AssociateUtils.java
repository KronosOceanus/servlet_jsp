package utils;

import entity.IDCard;
import entity.User;

public class AssociateUtils {

    //查询前设置外键引用
    public static User setBeforeAssociate(User user, IDCard idCard){
        user.setIdCard(idCard);
        return user;
    }

}
