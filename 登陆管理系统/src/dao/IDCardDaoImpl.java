package dao;
import entity.IDCard;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.Collection;

public class IDCardDaoImpl extends CommonDaoImpl implements IDCardDao{

    @Override
    public boolean isExist(IDCard idCard) throws Exception {
        String sql = "select * from id_card where id_card_number = '" +
                idCard.getId_card_number() + "'";
        return getJDBCExector().query(sql, new BeanHandler<>(IDCard.class)) != null;
    }

    @Override
    public IDCard insert(IDCard idCard) throws Exception {
        String sql = "insert into id_card values(?,?,?,?,?)";
        Object[] params = new Object[]{null,idCard.getId_card_number(),
            idCard.getName(),idCard.getBirthday(),idCard.getAddress()};
        idCard.setId(getJDBCExector().insert(sql,params));
        return idCard;
    }

    @Override
    public int deleteById(int id) throws Exception {
        String sql = "delete from id_card where id = " + id;
        return getJDBCExector().update(sql);
    }

    @Override
    public Collection<IDCard> findAll() throws Exception {
        String sql = "select * from id_card";
        return getJDBCExector().query(sql,new BeanListHandler<>(IDCard.class));
    }

    @Override
    public IDCard findById(int id) throws Exception {
        String sql = "select * from id_card where id = " + id;
        return getJDBCExector().query(sql,new BeanHandler<>(IDCard.class));
    }

    @Override
    public IDCard findByNumber(String number) throws Exception {
        String sql = "select * from id_card where id_card_number = '" + number + "'";
        return getJDBCExector().query(sql,new BeanHandler<>(IDCard.class));
    }

}
