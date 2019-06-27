package utils;

import dao.IDCardDaoImpl;
import dao.UserDaoImpl;
import entity.IDCard;
import entity.User;
import service.IDCardService;
import service.IDCardServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import java.util.Collection;

/**
 * 测试
 */
public class Main {

    public static void main(String[] args) throws Exception {

        UserDaoImpl uDao = new UserDaoImpl();
        IDCardDaoImpl iDao = new IDCardDaoImpl();
        UserService uS = new UserServiceImpl(uDao,iDao);
        IDCardService iS = new IDCardServiceImpl(iDao);

        /**
        JDBCExector.getInstance().
                update("insert into id_card values(?,?,?,?,?)",
                null,"142731199905075418","蔡帅",null,null);
         */
/**
        IDCard idCard = new IDCard();
        idCard.setId_card_number("142731199905075418");
        idCard.setName("蔡帅");
        User user = new User();
        user.setAccount("704690152");
        user.setPassword("mypassword");
        user.setUsername("纯白");
        user.setPhone("15513266666");
        user.setEmail("704690152@qq.com");
        AssociateUtils.setBeforeAssociate(user, idCard);
        User u = uS.insert(user);
        System.out.println(u.getId() + "\t" + u.getId_card_fk());
*/
        /**
        Collection<User> users = uDao.findAll();
        for (User user : users){
            System.out.println(user.getId());
        }
        System.out.println(uDao.findByAccount("704690152").getPassword());
        System.out.println(uDao.findById(4).getAccount());
        System.out.println(uDao.findByUserName("纯白").getEmail());
         */
        /**
        uDao.delete(4);
         */
        /**
        System.out.println(iDao.findByNumber("142731199905075418").getId());
        System.out.println(iDao.findById(15));
         */
/**
        uS.deleteById(7);
        for (User user : uS.findAll()){
            System.out.println(user.getAccount());
        }
 */
        System.out.println(PropsUtil.j_driver);
    }
}
