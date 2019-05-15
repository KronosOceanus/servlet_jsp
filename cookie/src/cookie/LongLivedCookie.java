package cookie;

import javax.servlet.http.Cookie;

/**
 * 创建长时间Cookie（工具类）
 */
public class LongLivedCookie extends Cookie {

    public static final int SECONDS_PER_YEAR = 60 * 60 * 24 * 365;

    public LongLivedCookie(String name,String value){
        super(name,value);
        setMaxAge(SECONDS_PER_YEAR);
    }
}
