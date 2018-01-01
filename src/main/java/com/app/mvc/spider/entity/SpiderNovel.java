package com.app.mvc.spider.entity;

import com.app.mvc.acl.config.utilConfig;
import com.app.mvc.acl.entity.Novel;
import com.app.mvc.acl.entity.NovelPage;
import com.app.mvc.util.HttpUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wenheng on 2017/8/20.
 */

public class SpiderNovel {

    @Getter
    @Setter
    private Novel novel;

    private SpiderNovel(String url) {
        if (getReadUrl(url)) {
            novel = new Novel();
            String content = HttpUtil.sendGet(url);
            novel.setTitle(getFindGroup("content", "<a href=\"/html/article/\\w+?/\">(.+?)</a>"));
            novel.setTypeCode(getFindGroup("content", "<a href=\"/html/article/\\w+?/\">(.+?)</a>"));

            for (utilConfig.NovelType type : utilConfig.NovelType.values()){
                if(type.getValue().equals(novel.getTypeCode()))
                    novel.setTypeCode(type.name());
            }
        }
    }

    boolean getReadUrl(String url) {
        Pattern pattern = Pattern.compile("/tupian/.+?/2017");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    String getFindGroup(String content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    void proessPage(String url, String content) {
        Integer num = Integer.valueOf(getFindGroup(content, "<a.?title=\"Page\">.+?<b>(.+?)</b>.?</a>"));
        for (int i = 1; i <= num; i++) {
            if (i > 1) {
                url = url.substring(0, url.lastIndexOf(".") - 1) + "_" + i + ".html";
                content = HttpUtil.sendGet(url);
            }
            NovelPage novelPage = new NovelPage();
            novelPage.setPage(i);
            novelPage.setContent(getFindGroup(content, "(.+?)\\s+?<div id=\"pages\">"));
            novel.getNovelPages().add(novelPage);
        }

    }

    @Override
    public String toString() {
        String sql = "";
        return sql;
    }
}
