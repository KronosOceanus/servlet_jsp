package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtil {

    private static Properties props = new Properties();
    private static String fileName = "jdbc.properties";
    private static InputStream is;
    public static String j_driver;
    public static String j_url;
    public static String j_user;
    public static String j_pass;

    static {
        //通过类加载器读取配置文件
        is = PropsUtil.class.getClassLoader().getResourceAsStream(fileName);
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        j_driver = props.getProperty("jdbc.driver");
        j_url = props.getProperty("jdbc.url");
        j_user = props.getProperty("jdbc.user");
        j_pass = props.getProperty("jdbc.pass");
    }





    //测试
    public static void main(String[] args) {
        System.out.println(j_url);
    }
}
