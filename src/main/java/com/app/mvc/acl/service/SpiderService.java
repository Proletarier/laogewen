package com.app.mvc.acl.service;

import com.app.mvc.cache.EhCacheCacheImpl;
import com.app.mvc.common.LinkFilter;
import com.app.mvc.spider.Spider;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wenheng on 2018/1/6.
 */
@Service
public class SpiderService {

    @Autowired
    private Spider spider;

    @Autowired
    private EhCacheCacheImpl cacheCache;

    public <T> void captureDate(String key, Class<T> t, String[] seeds, String[] validate) {

        List<T> list;
        LinkFilter filter = new LinkFilter() {
            @Override
            public boolean accept(String url, String... filters) {

                for (String filter : filters) {
                    if (url.startsWith(filter))
                        return true;
                }
                return false;

            }

        };

        Object object = cacheCache.get(key);
        if (object == null) {
            list = Lists.newArrayList();
            cacheCache.put(key, list);
        } else {
            list = (List<T>) object;
        }
        spider.crewling(list, t, filter, seeds, validate);
    }
}
