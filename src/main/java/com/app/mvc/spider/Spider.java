package com.app.mvc.spider;

import com.app.mvc.beans.SpiderQueue;
import com.app.mvc.interceptor.LinkFilter;
import com.app.mvc.spider.entity.SpiderNovel;
import com.app.mvc.util.FileUtil;
import org.apache.commons.httpclient.HttpClient;

import java.util.Set;

/**
 * Created by wenheng on 2017/7/16.
 */
public class Spider {
    public HttpClient httpClient = new HttpClient();


    private void initCreawlerWithSeds(String[] seeds, SpiderQueue spiderQueue) {
        for (int i = 0; i < seeds.length; i++) {
            spiderQueue.addUnVisitedUrl(seeds[i]);
        }
    }

    public synchronized <T> void crewling(String[] seeds, Class<T> c, LinkFilter filter, String... validate) {

        SpiderQueue spiderQueue = new SpiderQueue();
        initCreawlerWithSeds(seeds, spiderQueue);
        while (!spiderQueue.unVisitedUrisEmpty()
                && spiderQueue.getVisitedUrlNum() <= 1000) {
            String visitUrl =  spiderQueue.unVisitedUrlDeQueue();
            if (visitUrl == null) {
                continue;
            }
            saveSpider(visitUrl, c);
            spiderQueue.addVisitedUrl(visitUrl);
            Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter, validate);
            for (String link : links) {
                spiderQueue.addUnVisitedUrl(link);
            }
        }
    }


    <T> void saveSpider(String url, Class<T> c) {
        try {
            Object obj = c.getDeclaredConstructor(String.class).newInstance(url);
            if (obj != null) {
                String content = (String) obj.getClass().getMethod("toString").invoke(obj);
                if (content != null) {
                    FileUtil.writeFile("C:\\Users\\wenheng\\Desktop\\test.sql", content);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        crawler.crewling(new String[]{"https://333av.vip/html/article/jiqing/index.html"}, SpiderNovel.class, filter,"https://333av.vip/html/article/jiqing/");
    }


}
