package com.app.mvc.acl.interceptor;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by wenheng on 2018/1/21.
 */
public class WebInitialization implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        InitializedConfiguration();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public  void  InitializedConfiguration(){
        System.setProperty(net.sf.ehcache.CacheManager.ENABLE_SHUTDOWN_HOOK_PROPERTY,"true");
    }

}
