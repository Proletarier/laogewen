package com.app.mvc.beans;

import com.app.mvc.cache.EhCacheCacheImpl;
import com.app.mvc.common.applicationContextHelper;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2018/1/3.
 */

public class SpiderBloom {

    EhCacheCacheImpl ehCacheCache= applicationContextHelper.popBean(EhCacheCacheImpl.class);

    BloomFilter<CharSequence> bloomFilter;

    SpiderBloom() {
        initBloomFilter();
    }



    void initBloomFilter() {
        Object object = ehCacheCache.get("Bloom");
        if (object == null) {
            bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 10000, 0.0001);
        } else {
            bloomFilter = (BloomFilter<CharSequence>) object;
        }
    }

    public void  flush(){
        ehCacheCache.put("Bloom", bloomFilter);
    }


    public void addVisitedUrl(String url) {
        bloomFilter.put(url);
    }

    public boolean mightContain(String url) {
        return bloomFilter.mightContain(url);
    }


}
