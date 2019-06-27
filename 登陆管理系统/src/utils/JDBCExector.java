package utils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * JDBC操作类
 */
public class JDBCExector {

    private QueryRunner qr = new QueryRunner();

    private static String driver = PropsUtil.j_driver;
    private static String url = PropsUtil.j_url;
    private static String user = PropsUtil.j_user;
    private static String pass = PropsUtil.j_pass;
    private Connection conn;
    //单例类维护conn（创建conn成本巨大）
    private static JDBCExector jdbcExector;

    private JDBCExector() throws Exception {
        Class.forName(driver);
        conn = DriverManager.getConnection(url,user,pass);
    }
    //懒汉式单例
    public static JDBCExector getInstance() throws Exception {
        if (jdbcExector == null){
            return new JDBCExector();
        }
        return jdbcExector;
    }

    //插入，得到主键
    public int insert(String sql,Object... params) throws Exception{
        PreparedStatement ps = getInstance().conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        for (int i=0;i<params.length;i++){
            ps.setObject(i+1, params[i]);
        }
        ps.executeUpdate();
        ResultSet keys = ps.getGeneratedKeys();
        keys.next();
        return keys.getInt(1);
    }
    //更新，得到被影响的条数
    public int update(String sql,Object... params) throws Exception {
        return qr.update(getInstance().conn,sql,params);
    }
    //参数（sql语句，适配器（标明返回类型））
    //单行（1 result）
    public Object[] query(String sql, ArrayHandler ah) throws Exception{
        return qr.query(getInstance().conn,sql,ah);
    }
    //结果集列表
    public List<Object[]> query(String sql, ArrayListHandler alh) throws Exception{
        return qr.query(getInstance().conn,sql,alh);
    }
    //封装成JavaBean（1 result）
    public <T> T query(String sql, BeanHandler<T> bh) throws Exception{
        return qr.query(getInstance().conn,sql,bh);
    }
    //JavaBean列表
    public <T> List<T> query(String sql, BeanListHandler<T> blh) throws Exception{
        return qr.query(getInstance().conn,sql,blh);
    }
    //指定列储存到List
    public <T> List<T> query(String sql, ColumnListHandler<T> clh) throws Exception{
        return qr.query(getInstance().conn,sql,clh);
    }
    //单个数据（结果集中只有一个数据）封装成对象
    public <T> T query(String sql, ScalarHandler<T> sh) throws Exception{
        return qr.query(getInstance().conn,sql,sh);
    }
    //单行得到Map集合（K：列名，V：数据）（1 result）
    public Map<String,Object> query(String sql, MapHandler mh) throws Exception{
        return qr.query(getInstance().conn,sql,mh);
    }
    //得到Map集合
    public List<Map<String, Object>> query(String sql, MapListHandler mlh) throws Exception{
        return qr.query(getInstance().conn,sql,mlh);
    }
    //关闭连接
    public void close(){
        DbUtils.closeQuietly(conn);
    }
}
