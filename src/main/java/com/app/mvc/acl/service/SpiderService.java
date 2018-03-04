package com.app.mvc.acl.service;

import com.app.mvc.acl.config.UtilConfig;
import com.app.mvc.acl.po.Novel;
import com.app.mvc.cache.EhCacheCacheImpl;
import com.app.mvc.common.LinkFilter;
import com.app.mvc.exception.ServiceException;
import com.app.mvc.spider.Spider;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wenheng on 2018/1/6.
 */
@Service
public class SpiderService {

    @Autowired
    private Spider spider;

    @Autowired
    private NovelService novelService;

    @Autowired
    private EhCacheCacheImpl cacheCache;

    /**
     * 开始爬取
     * @param key
     * @param t
     * @param seeds
     * @param validate
     * @param <T>
     */
    public <T> void captureDate(String key, Class<T> t, String[] seeds, String[] validate) {

        List<T> list;
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

        Object object = cacheCache.get(key);
        if (object == null) {
            list = Lists.newArrayList();
        } else {
            list = (List<T>) object;
        }
        //seeds=new  String[]{"https://555av.vip/html/article/jiqing/"};
        //validate=new  String[]{"https://555av.vip/html/article/jiqing/","https://555av.vip/html/article/wuxia/","https://555av.vip/html/article/mingxing/","https://555av.vip/html/article/jiating/"};
        spider.crewling(list, t, filter, seeds, validate);
        cacheCache.put(key, list);
    }

    /**
     * 刷新小说到数据库
     */
    public void flushNovelToDatabase(){
        Object object = cacheCache.get(UtilConfig.CACH_NOVEL_KEY);
        if(object==null){
            throw ServiceException.create("NOVEL.IS.NULL");
        }
        List<Novel> novelList = (List<Novel>) object;
        for (Novel novel : novelList){
            for (UtilConfig.NovelType type : UtilConfig.NovelType.values()){
                if(type.getValue().equals(novel.getTypeCode()))
                    novel.setTypeCode(type.name());
            }
            novelService.saveNovel(novel);
        }
        cacheCache.remove(UtilConfig.CACH_NOVEL_KEY);
    }
}
