package com.app.mvc.cache;

import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by wenheng on 2018/1/2.
 */

@Slf4j
@Component
public class EhCacheCacheImpl implements Cache {

    @Resource(name = "ehCache")
    net.sf.ehcache.Cache cache;

    @Override
    public void put(String key, Object object) {
        Element element = new Element(key, object);
        cache.put(element);
    }

    @Override
    public void put(String key, Object object, int seconds) {
        Element element = new Element(key, object);
        if (seconds > 0) {
            element.setTimeToIdle(seconds);
        }
    }

    @Override
    public void set(String key, int seconds) {
        Element element = cache.get(key);
        if (seconds > 0) {
            element.setTimeToIdle(seconds);
        } else {
            element.setEternal(true);
        }
        cache.put(element);

    }

    @Override
    public Object get(String key) {
        Element element = cache.get(key);
        if (element != null) {
            return element.getObjectValue();
        }
        return null;
    }

    @Override
    public void remove(String key) {
        try {
            cache.remove(key);
        } catch (IllegalStateException e) {
            log.info("移除缓存失败:key=" + key);
        }
    }

    @Override
    public  void flush(){
        cache.flush();
    }
}
