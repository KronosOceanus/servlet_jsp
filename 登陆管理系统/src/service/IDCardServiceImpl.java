package service;

import dao.IDCardDao;
import entity.IDCard;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collection;

public class IDCardServiceImpl implements IDCardService {

    private IDCardDao iDao;
    public IDCardServiceImpl(IDCardDao iDao){
        this.iDao = iDao;
    }

    @Override
    public boolean isExist(IDCard idCard){
        try {
            return iDao.isExist(idCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public IDCard insert(IDCard idCard){
        try {
            if (iDao.isExist(idCard)){
                return iDao.findByNumber(idCard.getId_card_number());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return iDao.insert(idCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteById(int id){
        try {
            if (iDao.isExist(iDao.findById(id))){
                return iDao.deleteById(id);
            }else return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Collection<IDCard> findAll(){
        try {
            return iDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IDCard findById(int id){
        try {
            return iDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IDCard findByNumber(String number){
        try {
            return iDao.findByNumber(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
