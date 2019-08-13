package utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 将表单数据封装成Bean
 * 不确定是否使用
 */
public class BeanUtilities {

    //给实例赋值
    public static void populateBean(Object formBean,
                                    HttpServletRequest req){
        populateBean(formBean,req.getParameterMap());
    }

    public static void populateBean(Object bean,
                                    Map propertyMap){
        try{
            BeanUtils.populate(bean, propertyMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //把一个表单封装成两个bean
    public static void dividePopulateBean(Object firstBean,Object secondBean,
                                          HttpServletRequest req){
        Map<String, ?> dividePropertyMap = req.getParameterMap();
        Map<String, Object> userMap = new HashMap<>();
        Map<String, Object> idMap = new HashMap<>();
        int i = 0;
        for (String key : dividePropertyMap.keySet()){
            if (i < 5){
                userMap.put(key, dividePropertyMap.get(key));
            }else {
                idMap.put(key, dividePropertyMap.get(key));
            }
            i ++;
        }
        populateBean(firstBean, userMap);
        populateBean(secondBean, idMap);
    }
}
