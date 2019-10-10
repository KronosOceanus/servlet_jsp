package dao;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.PageBean;
import pojo.Role;
import utils.JDBCExector;

import java.util.List;

public class RoleDaoImpl {

    private JDBCExector jdbcExector;
    public RoleDaoImpl() throws Exception {
        jdbcExector = JDBCExector.getInstance();
    }

    //分页查询，将结果设置到 PageBean 中
    public PageBean<Role> findAll(int pageNumber, int pageSize) throws Exception {
        int totalRecord = getTotalRecord();
        PageBean<Role> pageBean = new PageBean<>(pageNumber, pageSize, totalRecord);

        //从数据库获取信息
        String sql = "select * from t_role limit ?,?";
        Object[] params = {pageBean.getStartIndex(), pageBean.getPageSize()};
        List<Role> data = jdbcExector.query(sql, new BeanListHandler<>(Role.class), params);
        //设置数据
        pageBean.setData(data);
        return pageBean;
    }


    //得到总记录数
    private int getTotalRecord(){
        try{
            String sql = "select count(*) from t_role";
            Long numLong = jdbcExector.query(sql, new ScalarHandler<Long>());
            return numLong.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }






    //测试
    public static void main(String[] args) throws Exception {
        RoleDaoImpl rdi = new RoleDaoImpl();
        System.out.println(rdi.getTotalRecord());
    }
}
