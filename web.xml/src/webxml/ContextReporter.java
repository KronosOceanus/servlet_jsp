package webxml;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

/**
 * 监听器
 * 在Web应用程序启动和销毁时，打印一条信息
 */
public class ContextReporter implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context created on " + new Date() + ".");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context destroyed on " + new Date() + ".");
    }
}
