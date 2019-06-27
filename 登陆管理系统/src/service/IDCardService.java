package service;

import entity.IDCard;

import java.util.Collection;

public interface IDCardService {

    //判断是否存在数据交给control处理

    //根据身份证号判断是否存在（默认存在）
    boolean isExist(IDCard idCard);
    //插入身份证（如果存在直接返回）
    IDCard insert(IDCard idCard);
    //根据id删除（得到被影响记录的条数）
    int deleteById(int id);
    //得到所有身份证信息
    Collection<IDCard> findAll();
    //根据id得到身份证信息
    IDCard findById(int id);
    //根据身份证号得到身份证信息;
    IDCard findByNumber(String number);
}
