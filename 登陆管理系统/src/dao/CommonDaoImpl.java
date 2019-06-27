package dao;

import utils.JDBCExector;

//数据访问父类
public class CommonDaoImpl {

    public JDBCExector getJDBCExector() throws Exception {
        return JDBCExector.getInstance();
    }

}
