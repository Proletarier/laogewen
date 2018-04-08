package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.condition.SpiderCondition;
import com.app.mvc.acl.config.UtilConfig;
import com.app.mvc.acl.dao.SpiderDao;
import com.app.mvc.acl.dao.SpiderFilmDao;
import com.app.mvc.acl.dao.SpiderNovelDao;
import com.app.mvc.acl.dao.SpiderPicDao;
import com.app.mvc.acl.po.Film;
import com.app.mvc.acl.po.Novel;
import com.app.mvc.acl.po.Picture;
import com.app.mvc.acl.po.SpiderData;
import com.app.mvc.cache.EhCacheCacheImpl;
import com.app.mvc.common.LinkFilter;
import com.app.mvc.exception.ServiceException;
import com.app.mvc.spider.Spider;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by wenheng on 2018/1/6.
 */
@Slf4j
@Service
public class SpiderService {

    @Autowired
    private Spider spider;

    @Autowired
    private NovelService novelService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private SpiderNovelDao spiderNovelDao;

    @Autowired
    private SpiderPicDao spiderPicDao;

    @Autowired
    private SpiderFilmDao spiderFilmDao;

    @Autowired
    private EhCacheCacheImpl cacheCache;

    @Autowired
    private SpiderDao spiderDao;

    /**
     * 开始爬取
     *
     * @param key
     * @param t
     * @param seeds
     * @param validate
     * @param <T>
     */
    public <T> void captureDate(String key, Class<T> t, String[] seeds, String[] validate, int size) {

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

        seeds = new String[]{"https://888av.vip/list/1-50.html", "https://888av.vip/list/2-40.html", "https://888av.vip/list/3-101.html", "https://888av.vip/list/4-37.html"};
        validate = new String[]{"https://888av.vip/vod/", "https://888av.vip/list"};

        SpiderCondition condition = new SpiderCondition();
        if (key.equals(UtilConfig.CACHE_FILM_KEY)) {
            condition.setSpiderType("FILM");
        } else if (key.equals(UtilConfig.CACHE_PICTURE_KEY)) {
            condition.setSpiderType("PIC");
        } else if (key.equals(UtilConfig.CACH_NOVEL_KEY)) {
            condition.setSpiderType("NOVEL");
        }
        Set<String> set = spiderDao.searchSpider(condition);
        List<T> list = spider.crewling(set, t, filter, seeds, validate, size);

        if (key.equals(UtilConfig.CACHE_FILM_KEY)) {
            flushFilmToSQLite((List<Film>) list);
        } else if (key.equals(UtilConfig.CACHE_PICTURE_KEY)) {
            flushPicToSQLite((List<Picture>) list);
        } else if (key.equals(UtilConfig.CACH_NOVEL_KEY)) {
            flushNovelToSQLite((List<Novel>) list);
        }
    }

    /**
     * 刷新电影到sqlite
     *
     * @param films
     */
    public void flushFilmToSQLite(List<Film> films) {
        try {
            spiderFilmDao.insertFilm(films);
        } catch (Exception e) {
            log.error(e.getMessage());
            ServiceException.create("FILM.ADD.FALL");
        }
    }

    /**
     * 刷新图片到sqlite
     *
     * @param pictures
     */
    public void flushPicToSQLite(List<Picture> pictures) {
        try {
            spiderPicDao.insertPicture(pictures);
        } catch (Exception e) {
            log.error(e.getMessage());
            ServiceException.create("PIC.ADD.FALL");
        }
    }

    /**
     * 刷新小说到sqlite
     *
     * @param novels
     */
    public void flushNovelToSQLite(List<Novel> novels) {
        try {
            spiderNovelDao.insertNovel(novels);
        } catch (Exception e) {
            log.error(e.getMessage());
            ServiceException.create("PIC.ADD.FALL");
        }
    }


    /**
     * 刷新小说到数据库
     */
    public void flushNovelToDatabase() {
        Object object = cacheCache.get(UtilConfig.CACH_NOVEL_KEY);
        if (object == null) {
            throw ServiceException.create("NOVEL.IS.NULL");
        }
        List<Novel> novelList = (List<Novel>) object;
        for (Novel novel : novelList) {
            if (novel.getTypeCode() == null) continue;
            for (UtilConfig.NovelType type : UtilConfig.NovelType.values()) {
                if (type.getValue().equals(novel.getTypeCode()))
                    novel.setTypeCode(type.name());
            }
            novelService.saveNovel(novel);
        }
        cacheCache.remove(UtilConfig.CACH_NOVEL_KEY);
    }

    /**
     * 刷新电影到数据库
     */
    public void flushVodToDatabase() {

        FilmCondition condition = new FilmCondition();
        condition.setPageSize(99999);
        List<Film> filmList = spiderFilmDao.searchFilm(condition);

        if (filmList == null) {
            throw ServiceException.create("FILM.IS.NULL");
        }

        for (Film film : filmList) {
            if (film.getFilmType() == null) continue;
            filmService.saveFilm(film);
        }

        try {
            spiderFilmDao.deleteFilmAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw ServiceException.create("FILM.ADD.FALL");
        }
    }

    /**
     * 刷新图片到数据库
     */
    public void flushPictureToDatabase() {
        Object object = cacheCache.get(UtilConfig.CACHE_PICTURE_KEY);
        if (object == null) {
            throw ServiceException.create("NOVEL.IS.NULL");
        }
        List<Picture> pictureLists = (List<Picture>) object;
        for (Picture picture : pictureLists) {
            pictureService.savePicture(picture);
        }
        cacheCache.remove(UtilConfig.CACHE_PICTURE_KEY);
    }

    public void insertSpider(String spiderType, T t) {
        String url = "";
        String md5 = "";
        SpiderData spiderData = SpiderData.builder().spiderUrl(url).spiderMd5(md5).spiderType(spiderType).createDate(new Date());
        try {
            spiderDao.insertSpider(spiderData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw ServiceException.create("FILM.ADD.FALL");
        }

    }


}
