package utils;

/**
 * 实验版
 * 封装特定提供商的驱动程序信息
 */
public class DriverInfoBean {

    private String vendor;
    private String description;
    private String driverClass;
    //URL格式模板
    private String url;

    public DriverInfoBean(String vendor,String description,
                          String driverClass,String url){
        this.vendor = vendor;
        this.description = description;
        this.driverClass = driverClass;
        this.url = url;
    }

    //只提供getter方法
    public String getVendor() {
        return vendor;
    }

    public String getDescription() {
        return description;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getUrl() {
        return url;
    }
}
