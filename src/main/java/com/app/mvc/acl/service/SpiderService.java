package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.condition.PictureCondition;
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
import com.app.mvc.beans.Page;
import com.app.mvc.cache.EhCacheCacheImpl;
import com.app.mvc.common.LinkFilter;
import com.app.mvc.exception.ServiceException;
import com.app.mvc.spider.Spider;
import com.app.mvc.spider.TemporaryData;
import com.app.mvc.util.JacksonUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wenheng on 2018/1/6.
 */
@Slf4j
@Service
public class SpiderService {


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

    private static TemporaryData temporaryData=new TemporaryData();


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
        Set<String> set = Sets.newHashSet();

        SpiderCondition condition = new SpiderCondition();
        if (key.equals(UtilConfig.CACHE_FILM_KEY)) {
            condition.setSpiderType("FILM");
        } else if (key.equals(UtilConfig.CACHE_PICTURE_KEY)) {
            condition.setSpiderType("PIC");
        } else if (key.equals(UtilConfig.CACH_NOVEL_KEY)) {
            condition.setSpiderType("NOVEL");
        }
        Spider spider=new Spider();
        try {
           // set = spiderDao.searchSpider(condition);
            temporaryData.createSpider(key,size);
            spider.crewling(temporaryData.getList(key),set, t, filter, seeds, validate, size);
        } catch (Exception e) {
            e.printStackTrace();
            ServiceException.create("FILM.ADD.FALL");
        }

        if (key.equals(UtilConfig.CACHE_FILM_KEY)) {
            flushFilmToSQLite((List<Film>) temporaryData.getList(key));
        } else if (key.equals(UtilConfig.CACHE_PICTURE_KEY)) {
            flushPicToSQLite((List<Picture>) temporaryData.getList(key));
        } else if (key.equals(UtilConfig.CACH_NOVEL_KEY)) {
            flushNovelToSQLite((List<Novel>) temporaryData.getList(key));
        }
        temporaryData.removeList(key);
    }


    public boolean  isSpiderWorking(String key){
         return  temporaryData.isSpiderWorking(key);
    }


    public String getLastSpiderContent(String key){

        if (!temporaryData.isSpiderWorking(key)){
            throw  ServiceException.create("SPIDER.IS.NOT.WORK");
        }

        Map<String,String> messageMap= Maps.newHashMap();

        Integer count=temporaryData.getCondition(key);
        Integer size=temporaryData.getList(key).size()-1;


        if (key.equals(UtilConfig.CACHE_FILM_KEY)) {
            Film vod= (Film) temporaryData.getList(key).get(size);
            messageMap.put("message",vod.getFilmName());
        } else if (key.equals(UtilConfig.CACHE_PICTURE_KEY)) {
            Picture pic= (Picture) temporaryData.getList(key).get(size);
            messageMap.put("message",pic.getName());
        } else if (key.equals(UtilConfig.CACH_NOVEL_KEY)) {
            Novel novel= (Novel) temporaryData.getList(key).get(size);
            messageMap.put("message",novel.getTitle());
        }
        Double percent=(double)size/count*100;
        messageMap.put("percent",percent.toString());

        return JacksonUtil.toJSon(messageMap);

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
            log.error(e.getMessage(), e);
            throw ServiceException.create("FILM.ADD.FALL");
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
            log.error(e.getMessage(), e);
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
            log.error(e.getMessage(), e);
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
            insertSpider("NOVEL", novel);
        }

        try {
            spiderNovelDao.deleteNovelAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw ServiceException.create("NOVEL.ADD.FALL");
        }
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
            insertSpider("FILM", film);
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
            insertSpider("PIC", picture);
        }
        try {
            spiderPicDao.deletePicAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw ServiceException.create("PIC.ADD.FALL");
        }

    }


    /**
     * 获取爬取的电影数据
     *
     * @param condition
     * @return
     */
    public Page<Film> searchVod(FilmCondition condition) {

        Page<Film> page;
        try {
            List<Film> list = spiderFilmDao.searchFilm(condition);
            int count = spiderFilmDao.findByCount(condition);
            page = Page.<Film>builder().data(list).total(count).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw ServiceException.create("PIC.SEARCH.FALL");
        }
        return page;
    }


    /**
     * 修改
     *
     * @param film
     */
    public void updateFilm(Film film) {
        try {
            spiderFilmDao.updateFilm(film);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw ServiceException.create("FILM.UPDATE.FAIL");
        }

    }

    /**
     * 删除
     *
     * @param filmId
     */
    public void deleteFilm(Integer filmId) {
        try {
            spiderFilmDao.deleteFilm(filmId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("FILM.UPDATE.FAIL");
        }
    }

    public  Film findByVod(Integer id){
        Film film;
        try {
            film=spiderFilmDao.findById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("FILM.FIND.FAIL");
        }
        return  film;
    }


    /**
     * 获取图片
     *
     * @param condition
     * @return
     */
    public Page<Picture> searchPic(PictureCondition condition) {
        Page<Picture> page;
        try {
            List<Picture> list = spiderPicDao.searchPicture(condition);
            int count = spiderPicDao.findByCount(condition);
            page = Page.<Picture>builder().data(list).total(count).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw ServiceException.create("PIC.SEARCH.FALL");
        }
        return page;
    }

    /**
     * 修改
     *
     * @param picture
     */
    public void updatePicture(Picture picture) {

        try {
            spiderPicDao.updatePicture(picture);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.UPDATE.FAIL");
        }
    }


    /**
     * 删除
     * @param id
     */
    public void deletePicture(Integer id) {

        try {
            spiderPicDao.deletePic(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("PICTURE.UPDATE.FAIL");
        }

    }

    public  Picture findByPic(Integer id){
        Picture picture;
        try {
            picture=spiderPicDao.findById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("FILM.FIND.FAIL");
        }
        return  picture;
    }




    /**
     * 获取小说
     *
     * @param condition
     * @return
     */
    public Page<Novel> searchNovel(NovelCondition condition) {
        Page<Novel> page;
        try {
            List<Novel> list = spiderNovelDao.searchNovel(condition);
            int count = spiderNovelDao.findByCount(condition);
            page = Page.<Novel>builder().data(list).total(count).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw ServiceException.create("PIC.SEARCH.FALL");
        }
        return page;
    }

    /**
     * 删除
     * @param novelId
     */
    public void deleteNovel(Integer novelId) {
        try {
            spiderNovelDao.deleteNovel(novelId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.UPDATE.FAIL");
        }
    }




    /**
     * 添加记录
     *
     * @param spiderType
     * @param object
     */
    public void insertSpider(String spiderType, Object object) {
        try {
            String md5 = BeanUtils.getProperty(object, "md5");
            String url = BeanUtils.getProperty(object, "url");
            SpiderData spiderData = SpiderData.builder().spiderUrl(url).spiderMd5(md5).spiderType(spiderType).createDate(new Date()).build();
            spiderDao.insertSpider(spiderData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw ServiceException.create("FILM.ADD.FALL");
        }
    }


}
