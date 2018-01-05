package com.app.mvc.spider.entity;

import com.app.mvc.acl.config.utilConfig;
import com.app.mvc.acl.po.Novel;
import com.app.mvc.acl.po.NovelPage;
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

    public SpiderNovel(String url) {
        if (getReadUrl(url)) {
            novel = new Novel();
            String content = HttpUtil.sendGet(url);
            novel.setTitle(getFindGroup(content, "<a href=\"/html/article/.+?/\">.+</a>(.+?)</h2>"));
            novel.setTypeCode(getFindGroup(content, "<a href=\"/html/article/\\w+?/\">(.+?)</a>"));
            for (utilConfig.NovelType type : utilConfig.NovelType.values()) {
                if (type.getValue().equals(novel.getTypeCode()))
                    novel.setTypeCode(type.name());
            }
            proessNovelPage(url, content);
        }
    }

    boolean getReadUrl(String url) {
        Pattern pattern = Pattern.compile("/article/.+?/2017");
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

    void proessNovelPage(String url, String content) {
        String numSize = getFindGroup(content, "<a.?title=\"Page\">.+?<b>.+</b>.+?<b>(.+?)</b>.?</a>");
        Integer num;
        if (numSize != null) {
            num = Integer.valueOf(numSize);
        } else {
            num = 1;
        }
        for (int i = 1; i <= num; i++) {
            if (i > 1) {
                String newUrl = url.substring(0, url.lastIndexOf(".")) + "_" + i + ".html";
                content = HttpUtil.sendGet(newUrl);
            }
            NovelPage novelPage = new NovelPage();
            novelPage.setPage(i);
            novelPage.setContent(getFindGroup(content, "imgbody\">\\s*<p>.+?</p>(.+)\\s*<div.+id=\"pages\">"));
            System.out.println(novelPage.getContent());
            novel.getNovelPages().add(novelPage);
        }

    }

    @Override
    public String toString() {
        if (novel == null) return null;
        String sql = novel.getTitle() + novel.getNovelPages().size();
        return sql;
    }
}
