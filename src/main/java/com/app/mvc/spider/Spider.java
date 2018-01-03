package com.app.mvc.spider;

import com.app.mvc.beans.SpiderQueue;
import com.app.mvc.interceptor.LinkFilter;
import net.sf.ehcache.hibernate.management.impl.BeanUtils;

import java.util.List;
import java.util.Set;

/**
 * Created by wenheng on 2017/7/16.
 */
public class Spider {


    private void initCreawlerWithSeds(String[] seeds, SpiderQueue spiderQueue) {
        for (int i = 0; i < seeds.length; i++) {
            spiderQueue.addUnVisitedUrl(seeds[i]);
        }
    }

    public synchronized <T> void crewling(List<T> lists, Class<T> c, LinkFilter filter, String[] seeds, String... validate) {

        SpiderQueue spiderQueue = new SpiderQueue();
        initCreawlerWithSeds(seeds, spiderQueue);
        while (!spiderQueue.unVisitedUrisEmpty()) {
            String visitUrl = spiderQueue.unVisitedUrlDeQueue();
            if (visitUrl == null) {
                continue;
            }
            Object object = saveSpider(c, spiderQueue, visitUrl);
            spiderQueue.addVisitedUrl(visitUrl);
            Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter, validate);
            for (String link : links) {
                spiderQueue.addUnVisitedUrl(link);
            }
        }
    }


    <T> Object saveSpider(Class<T> c, SpiderQueue spiderQueue, String url) {
        try {
            Object obj = c.getDeclaredConstructor(String.class).newInstance(url);
            if (obj != null) {
                return BeanUtils.getBeanProperty(obj, obj.getClass().getDeclaredFields()[0].getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String... args) {
        Spider crawler = new Spider();

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
//        crawler.crewling(new String[]{"https://8888av.co/list/1.html",
//                "https://8888av.co/list/2.html",
//                "https://8888av.co/list/3.html",
//                "https://8888av.co/list/4.html",
//                "https://8888av.co/list/5.html",
//                "https://8888av.co/list/6.html",
//                "https://8888av.co/list/7.html",
//                "https://8888av.co/list/8.html",}, SpiderFilm.class);
        //  crawler.crewling(new String[]{"https://333av.vip/html/article/jiqing/index.html"}, SpiderNovel.class, filter, "https://333av.vip/html/article/jiqing/");
    }


}
