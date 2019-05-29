package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 实验版
 * 封装与特定数据库连接的相关信息
 * 得到连接（单例模式维护）
 */
public class ConnInfoBean {

    private static Connection conn;

    private String connectionName;
    private String description;
    private String driver;
    private String url;
    private String username;
    private String password;

    //单例维护连接
    public static Connection getConnection(String driver,String url,
                                           String username,String password){
        if (conn != null){
            return conn;
        }
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            return conn;
        }catch (ClassNotFoundException ce){
            System.out.println("Error loading driver: " + ce);
            return null;
        }catch (SQLException se){
            System.out.println("Error connecting: " + se);
            return null;
        }
    }

    public ConnInfoBean(){}
    public ConnInfoBean(String connectionName,String description,
                        String driver,String url,
                        String username,String password){
        this.connectionName = connectionName;
        this.description = description;
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
