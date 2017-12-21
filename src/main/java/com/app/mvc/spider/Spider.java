package com.app.mvc.spider;

import com.app.mvc.spider.entity.SpiderPicture;
import com.app.mvc.interceptor.LinkFilter;
import com.app.mvc.beans.SpiderQueue;
import com.app.mvc.util.FileUtil;
import org.apache.commons.httpclient.HttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLConnection;
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

    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realurl = new URL(url);
            URLConnection connection = realurl.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            connection.setReadTimeout(1000000);
            connection.setConnectTimeout(1000000);
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()
            ));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    <T> void saveSpider(String url, Class<T> c) {
        try {
            Object obj = c.getDeclaredConstructor(String.class).newInstance(url);
            if (obj != null) {
                String content = (String) obj.getClass().getMethod("ToString").invoke(obj);
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
        crawler.crewling(new String[]{"https://333av.vip/html/tupian/yazhou/index.html"}, SpiderPicture.class, filter);
    }


}
