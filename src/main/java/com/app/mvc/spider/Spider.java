package com.app.mvc.spider;

import com.app.mvc.spider.bean.SpiderPicture;
import com.app.mvc.spider.filter.LinkFilter;
import com.app.mvc.spider.model.SpiderQueue;
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

    public synchronized <T> void crewling(String[] seeds, Class<T> c) {
        LinkFilter filter = new LinkFilter() {
            @Override
            public boolean accept(String url, String...filters) {

                for (String filter : filters) {
                    if (url.startsWith(filter))
                         return true;
                }
                return  false;
            }

        };
        SpiderQueue spiderQueue = new SpiderQueue();
        initCreawlerWithSeds(seeds, spiderQueue);
        while (!spiderQueue.unVisitedUrisEmpty()
                && spiderQueue.getVisitedUrlNum() <= 1000) {
            String visitUrl = (String) spiderQueue.unVisitedUrlDeQueue();
            if (visitUrl == null) {
                continue;
            }
            saveSpider(visitUrl, c);
            spiderQueue.addVisitedUrl(visitUrl);
            Set<String> links = HtmlParserTool.extracLinks(visitUrl, filter);
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
        Object obj = toEntity(url, c);
        if (obj != null) {
            String content = getsql(obj);
            if (content!=null) {
                System.out.println(content);
                FileUtil.writeFile("C:\\Users\\wenheng\\Desktop\\test.sql", content);
            }
        }
    }

    <T> Object toEntity(String url, Class<T> obj) {
        try {
            Constructor c1 = obj.getDeclaredConstructor(String.class);
            return c1.newInstance(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    String getsql(Object obj) {
        try {
            return (String) obj.getClass().getMethod("toString").invoke(obj);
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
//                "https://8888av.co/list/8.html",}, SpiderFilm.class);
        crawler.crewling(new String[]{"https://9999av.co/html/tupian/yazhou/index.html",
                "https://9999av.co/html/tupian/siwa/index.html",
                "https://9999av.co/html/tupian/oumei/index.html",
                "https://9999av.co/html/tupian/mingxing/index.html",
                "https://9999av.co/html/tupian/qingchun/index.html",
                "https://9999av.co/html/tupian/dongman/index.html",}, SpiderPicture.class);
    }


}
