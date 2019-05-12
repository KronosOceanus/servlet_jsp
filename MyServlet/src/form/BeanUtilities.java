package form;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 将表单数据封装成Bean
 */
public class BeanUtilities {

    //填充实例
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
}
