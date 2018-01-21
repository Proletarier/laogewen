package com.app.mvc.cache;

/**
 * Created by wenheng on 2018/1/2.
 */
public interface Cache {

    void put(String key, Object object);

    /**
     * @param key
     * @param object
     * @param seconds 空闲过期时间 秒数 需要实现支持 ,0表示不过期
     */
    void put(String key, Object object, int seconds);

    /**
     * @param key
     * @param seconds 空闲过期时间 秒数 需要实现支持
     */
    void set(String key, int seconds);

    Object get(String key);

    void remove(String key);

    void flush();

}
