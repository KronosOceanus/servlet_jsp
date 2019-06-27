package dao;
import entity.*;

import java.util.Collection;

public interface IDCardDao {

    //数据库中是否存在该身份证
    boolean isExist(IDCard idCard) throws Exception;
    //插入身份证（顺便设置主键）
    IDCard insert(IDCard idCard) throws Exception;
    //得到所有身份证信息
    Collection<IDCard> findAll() throws Exception;
    //根据id得到身份证信息
    IDCard findById(int id) throws Exception;
    //根据身份证号得到身份证信息;
    IDCard findByNumber(String number) throws Exception;
    //根据id删除（得到被影响记录的条数）
    int deleteById(int id) throws Exception;
}
