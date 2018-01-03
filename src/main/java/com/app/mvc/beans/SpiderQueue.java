package com.app.mvc.beans;

import com.app.mvc.config.RegexConfig;
import com.google.common.base.CharMatcher;
import com.google.common.collect.Sets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.codec.digest.DigestUtils;

import java.net.URL;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by wenheng on 2017/7/16.
 */
public class SpiderQueue extends SpiderBloom {

    //待访问url集合
    private Queue unVisitedUrl = new Queue();

    public Queue unVisitedUrl() {
        return unVisitedUrl;
    }

    public String unVisitedUrlDeQueue() {
        return unVisitedUrl.deQueue();
    }

    public void addUnVisitedUrl(String url) {
        if (url != null && !url.trim().equals("") &&
                !mightContain(url) && !unVisitedUrl.contians(url)) {
            unVisitedUrl.enQueue(url);
        }
    }

    public boolean unVisitedUrisEmpty() {
        return unVisitedUrl.empty();
    }

    public void addVisitedUrl(String url) {
        super.addVisitedUrl(processingUrl(url));
    }

    public boolean mightContain(String url) {
        return super.mightContain(processingUrl(url));
    }

    String processingUrl(String url) {
        Pattern pattern = Pattern.compile(RegexConfig.URL_REGEX);
        String newUrl = CharMatcher.ANY.anyOf(url).removeFrom(pattern.matcher(url).group());
        return DigestUtils.md5Hex(newUrl);
    }
}
