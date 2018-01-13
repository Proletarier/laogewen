package com.app.mvc.beans;

import com.app.mvc.cache.EhCacheCacheImpl;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * Created by Administrator on 2018/1/3.
 */
public class SpiderBloom {

    EhCacheCacheImpl ehCacheCache;

    BloomFilter<CharSequence> bloomFilter;

    SpiderBloom() {
        initBloomFilter();
    }

    void initBloomFilter() {
        Object object = ehCacheCache.get("Bloom");
        if (object == null) {
            bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 10000, 0.0001);
            ehCacheCache.put("Bloom", bloomFilter);
        } else {
            bloomFilter = (BloomFilter<CharSequence>) object;
        }
    }


    public void addVisitedUrl(String url) {
        bloomFilter.put(url);
    }

    public boolean mightContain(String url) {
        return bloomFilter.mightContain(url);
    }


}
