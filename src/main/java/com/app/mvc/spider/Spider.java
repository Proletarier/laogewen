package com.app.mvc.spider;

import com.app.mvc.beans.SpiderQueue;
import com.app.mvc.common.LinkFilter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

/**
 * Created by wenheng on 2017/7/16.
 */
@Component
public class Spider {

    private void initCreawlerWithSeds(String[] seeds, SpiderQueue spiderQueue) {
        for (int i = 0; i < seeds.length; i++) {
            spiderQueue.addUnVisitedUrl(seeds[i]);
        }

    }

    public synchronized <T> void crewling(List<T> lists, Class<T> c, LinkFilter filter, String[] seeds, String[] validate,int size) {
        SpiderQueue spiderQueue = new SpiderQueue();
        initCreawlerWithSeds(seeds, spiderQueue);
        while (!spiderQueue.unVisitedUrisEmpty() && lists.size() <= size) {
            String visitUrl = spiderQueue.unVisitedUrlDeQueue();
            if (visitUrl == null || spiderQueue.mightContain(visitUrl)) {
                continue;
            }
            Object object = saveSpider(visitUrl, c);
            if (object != null) {
                lists.add((T) object);
                spiderQueue.addVisitedUrl(visitUrl);
            } else {
                spiderQueue.addEntranceUrl(visitUrl);
            }
            Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter, validate);
            for (String link : links) {
                spiderQueue.addUnVisitedUrl(link);
            }
        }
    }


    <T> Object saveSpider(String url, Class<T> c) {
        try {
            Object obj = c.getDeclaredConstructor(String.class).newInstance(url);
            if (null != obj) {
                Field[] fields = obj.getClass().getDeclaredFields();
                if (fields.length > 0) {
                    fields[0].setAccessible(true);
                    return fields[0].get(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String... args) {
        Spider crawler = new Spider();

//        crawler.crewling(new String[]{"https://8888av.co/list/1.html",
//                "https://8888av.co/list/2.html",
//                "https://8888av.co/list/3.html",
//                "https://8888av.co/list/4.html",
//                "https://8888av.co/list/5.html",
//                "https://8888av.co/list/6.html",
//                "https://8888av.co/list/7.html",
//                "https://8888av.co/list/8.html",}, SpiderFilmDao.class);
        //crawler.crewling(new String[]{"https://333av.vip/html/article/jiqing/index.html"}, SpiderNovel.class, filter, "https://333av.vip/html/article/jiqing/");
    }


}
