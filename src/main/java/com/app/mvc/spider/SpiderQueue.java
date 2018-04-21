package com.app.mvc.spider;

import com.app.mvc.config.RegexConfig;
import com.app.mvc.exception.ServiceException;
import com.app.mvc.util.SignUtil;
import com.google.common.collect.Lists;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wenheng on 2017/7/16.
 */

public class SpiderQueue extends SpiderBloom {

    //已访问url集合
    private List<String> entranceUrl = Lists.newLinkedList();

    //待访问url集合
    private Queue unVisitedUrl = new Queue();

    public SpiderQueue(Set<String> bloomFilter) {
        super(bloomFilter);
    }

    public Queue unVisitedUrl() {
        return unVisitedUrl;
    }

    public String unVisitedUrlDeQueue() {
        return unVisitedUrl.deQueue();
    }

    public void addUnVisitedUrl(String url) {
        if (url != null && !url.trim().equals("") && !mightContain(url) && !unVisitedUrl.contians(url) && !containsUrl(url)) {
            unVisitedUrl.enQueue(url);
        }
    }

    public boolean unVisitedUrisEmpty() {
        return unVisitedUrl.empty();
    }

    public void addEntranceUrl(String url) {
        entranceUrl.add(url);
    }

    public boolean containsUrl(String url) {
        return entranceUrl.contains(url);
    }


    public void addVisitedUrl(String url) {
        super.addVisitedUrl(processingUrl(url));
    }

    public boolean mightContain(String url) {
        return super.mightContain(processingUrl(url));
    }

    public String processingUrl(String url) {
        Pattern pattern = Pattern.compile(RegexConfig.URL_REGEX);
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            String removeUrl = matcher.group();
            String newUrl = url.replaceAll(removeUrl, "");
            if (newUrl.contains("#")) {
                newUrl = newUrl.split("#")[0];
            }
            return DigestUtils.md5Hex(SignUtil.getContentBytes(newUrl, "UTF-8"));
        } else {
            throw ServiceException.create("error");
        }

    }
}
