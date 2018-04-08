package com.app.mvc.beans;

import java.util.Set;

/**
 * Created by Administrator on 2018/1/3.
 */

public class SpiderBloom {

    Set<String> bloomFilter;

    public SpiderBloom(Set<String> bloomFilter) {
        this.bloomFilter = bloomFilter;
    }

    public void addVisitedUrl(String url) {
        bloomFilter.add(url);
    }

    public boolean mightContain(String url) {
        return bloomFilter.contains(url);
    }


}
