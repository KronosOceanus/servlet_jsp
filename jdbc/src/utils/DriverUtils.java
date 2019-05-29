package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 实验版
 * 载入与各个数据库提供商相关的
 * 显示编码的驱动程序信息
 */
public class DriverUtils {

    public static final String MYSQL = "MYSQL";
    //储存数据库名称与驱动类Bean
    protected static Map<String,DriverInfoBean> driverMap = new HashMap<>();

    //加载驱动，并加入集合
    public static void loadDrivers(){
        String vendor,description,driverClass,url;
        DriverInfoBean info = null;
        vendor = "MYSQL";
        description = "MYSQL Connector/J 3.0";
        driverClass = "com.mysql.cj.jdbc.Driver";
        //URL格式
        url = "jdbc:mysql://[$host]:3306/[$dbName]\\?useSSL=false&serverTimezone=UTC";
        addDriverInfoBean(info);
    }
    //添加到集合
    public static void addDriverInfoBean(DriverInfoBean info){
        driverMap.put(info.getVendor().toUpperCase(),info);
    }
    //判断数据库名称是否有效（Map中是否有对应的value）
    public static boolean isValidVendor(String vendor){
        DriverInfoBean info = driverMap.get(vendor.toUpperCase());
        return info != null;
    }
    //根据数据库名得到驱动类名
    public static String getDriver(String vendor){
        DriverInfoBean info = driverMap.get(vendor.toUpperCase());
        if (info == null){
            return null;
        }else {
            return info.getDriverClass();
        }
    }
    //替换字符缓冲流中的替代内容
    private static void replace(StringBuffer buffer,
                                String match,String value){
        int index = buffer.toString().indexOf(match);
        if (index > 0){
            buffer.replace(index, index + match.length(), value);
        }
    }
    //根据实际传入的数据库信息，得到数据库URL
    public static String makeURL(String host,String dbName,String vendor){
        DriverInfoBean info = driverMap.get(vendor.toUpperCase());
        if (info == null){
            return null;
        }
        StringBuffer url = new StringBuffer(info.getUrl());
        DriverUtils.replace(url,"[$host]",host);
        DriverUtils.replace(url,"[$dbName]",dbName);
        return url.toString();
    }
}
