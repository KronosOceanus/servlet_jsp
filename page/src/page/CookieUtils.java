package page;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * （重点在part.jsp）
 * 根据名称获取Cookie或者Value
 */
public class CookieUtils {

    public static String getCookieValue(HttpServletRequest req,
                                        String cookieName,
                                        String defaultValue){
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (Cookie c : cookies){
                if (cookieName.equals(c.getName())){
                    return c.getValue();
                }
            }
        }
        return defaultValue;
    }

    public static Cookie getCookie(HttpServletRequest req,
                                   String cookieName){
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (Cookie c : cookies){
                if (cookieName.equals(c.getName())){
                    return c;
                }
            }
        }
        return null;
    }
}
