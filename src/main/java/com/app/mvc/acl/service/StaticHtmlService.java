package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.config.UtilConfig;
import com.app.mvc.acl.dao.FilmDao;
import com.app.mvc.acl.dao.PictureDao;
import com.app.mvc.acl.po.Film;
import com.app.mvc.acl.po.Picture;
import com.app.mvc.beans.StaticTemplateView;
import com.app.mvc.exception.ServiceException;
import com.app.mvc.util.DateUtil;
import com.app.mvc.util.FreemakerUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/5.
 */
@Slf4j
@Service
public class StaticHtmlService {

    @Autowired
    private FilmDao filmDao;

    @Autowired
    private PictureDao pictureDao;

    /**
     * 静态首页
     * @param path
     */
    public void staticIndexHtml(String path) {
        Map<String, Object> map = Maps.newHashMap();
        FilmCondition filmCondition = new FilmCondition();
        filmCondition.setStartDate(DateUtil.format(new Date(), "yyyy-MM-dd"));
        filmCondition.setEndDate(DateUtil.format(new Date(), "yyyy-MM-dd"));
        map.putAll(this.searchFilmHome());
        map.putAll(this.searcPriturehHome());
        map.put(UtilConfig.FilmType.GXSL.name(), filmDao.countByFilm(filmCondition));
        map.put("count",filmDao.countByFilm(new FilmCondition()));
        StaticTemplateView view = new StaticTemplateView();
        view.setFtlPath(path + File.separator + "app" + File.separator + "ftl");
        view.setFltName("index.ftl");
        view.setDestPath(path + File.separator + "app" + File.separator + "main");
        view.setDestName("index.html");
        view.setData(map);
        FreemakerUtil.freemakerProcess(view);
    }

    /**
     * 静态化电影详情页
     * @param path
     * @param id
     */
    public void staticVodHtml(String path,Integer id) {
        Map<String, Object> map = Maps.newHashMap();
        Film film=filmDao.findById(id);
        film.setCodeValue(UtilConfig.FilmType.valueOf(film.getFilmType()).getValue());
        film.setImg(film.getContentImg().split(";"));
        map.put("film",film);
        StaticTemplateView view = new StaticTemplateView();
        view.setFtlPath(path + File.separator + "app" + File.separator + "ftl");
        view.setFltName("film.ftl");
        view.setDestPath(path + File.separator + "app" + File.separator + "vod");
        view.setDestName(id+".html");
        view.setData(map);
        FreemakerUtil.freemakerProcess(view);
    }




    public Map<String, List<Film>> searchFilmHome() {
        FilmCondition condition = null;
        List<Film> films = null;
        Map<String, List<Film>> map = Maps.newHashMap();
        try {
            //今日更新
            condition = new FilmCondition();
            condition.setPageSize(14);
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(UtilConfig.FilmType.JRGX.toString(), films);
            //本周热播
            condition.setPageSize(12);
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(UtilConfig.FilmType.BZRB.toString(), films);
            //猜您喜欢
            condition.setPageSize(8);
            condition.setClickFlag("Y");
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(UtilConfig.FilmType.CNXH.toString(), films);
            //亚洲色情
            condition.setFilmType(UtilConfig.FilmType.YZQS.toString());
            condition.setPageSize(6);
            condition.setClickFlag("N");
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(UtilConfig.FilmType.YZQS.toString(), films);
            //制服丝袜
            condition.setFilmType(UtilConfig.FilmType.ZFSW.toString());
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(UtilConfig.FilmType.ZFSW.toString(), films);
            //欧美性爱
            condition.setFilmType(UtilConfig.FilmType.OMXA.toString());
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(UtilConfig.FilmType.OMXA.toString(), films);
            //网友自拍
            condition.setFilmType(UtilConfig.FilmType.WYZP.toString());
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(UtilConfig.FilmType.WYZP.toString(), films);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("FILM.SEARCH.FAIL");
        }
        return map;
    }


    public Map<String, List<Picture>> searcPriturehHome() {
        PictureCondition condition = null;
        List<Picture> pictures = null;
        Map<String, List<Picture>> map = Maps.newHashMap();
        try {
            condition = new PictureCondition();
            condition.setPageSize(7);
            condition.setType(UtilConfig.PictureType.YZST.name());
            pictures = pictureDao.queryPicture(condition);
            if (pictures != null)
                map.put(UtilConfig.PictureType.YZST.name(), pictures);
            condition.setType(UtilConfig.PictureType.SWMT.name());
            pictures = pictureDao.queryPicture(condition);
            if (pictures != null)
                map.put(UtilConfig.PictureType.SWMT.name(), pictures);
            condition.setType(UtilConfig.PictureType.OMXA.name());
            pictures = pictureDao.queryPicture(condition);
            if (pictures != null)
                map.put("OMST", pictures);
            condition.setType(UtilConfig.PictureType.TPZP.name());
            pictures = pictureDao.queryPicture(condition);
            if (pictures != null)
                map.put("ZPST", pictures);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return map;
    }

    /**
     * 静态化图片页面
     * @param path
     * @param id
     */
    public void staticPictureHtml(String path, Integer id) {
        Picture picture = pictureDao.findById(id);
        Map<String, Object> map = Maps.newHashMap();
        if (picture == null) {
            throw ServiceException.create("PICTURE.THE.ENTITY.IS.NOT.FOUND");
        }
        PictureCondition condition = new PictureCondition();
        condition.setId(id);
        condition.setType(picture.getTypeCode());
        List<Picture> list = pictureDao.queryPictureUpAndDown(condition);
        if (list != null && list.size() > 0) {
            for (Picture pic : list) {
                if (pic.getPictureId() > picture.getPictureId()) {
                    picture.setDownPage(pic);
                } else if (pic.getPictureId() < picture.getPictureId()) {
                    picture.setUpPage(pic);
                }
            }
        }
        picture.setCodeValue(UtilConfig.PictureType.valueOf(picture.getTypeCode()).getValue());
        picture.setImgs(picture.getImg().split(";"));
        map.put("picture", picture);
        StaticTemplateView view = new StaticTemplateView();
        view.setFtlPath(path + File.separator + "app" + File.separator + "ftl");
        view.setFltName("picture.ftl");
        view.setDestPath(path + File.separator + "app" + File.separator + "picture" + File.separator + picture.getTypeCode());
        view.setDestName(id + ".html");
        view.setData(map);
        FreemakerUtil.freemakerProcess(view);

    }



    /**
     * 图片分页静态化
     * @param path
     * @param condition
     */
    public void staticPicturePageHtml(String path, PictureCondition condition) {
        if (condition.getType() == null)
            throw ServiceException.create("PICTURE.THE.ENTITY.IS.NOT.FOUND");
        int count = pictureDao.countByPicture(condition);
        Map<String, Object> map = Maps.newHashMap();
        boolean isTrue = false;
        if (condition.getPageNum() == 1) {
            isTrue = true;
        } else {
            condition.setPageNum(condition.getPageNum() - 1);
        }
        List<Picture> list = pictureDao.queryPicture(condition);
        List<Picture> pictures = Lists.newArrayList();
        if (isTrue) {
            pictures.addAll(Arrays.asList(new Picture[condition.getPageSize()]));
            pictures.addAll(list);
        } else {
            pictures.addAll(list);
            condition.setPageNum(condition.getPageNum() + 1);
            pictures.addAll(pictureDao.queryPicture(condition));
        }

        map.put("page", pictures);
        map.put("type", condition.getType());
        map.put("count", count);
        map.put("pageNum", condition.getPageNum());
        map.put("upPageNum",  condition.getPageNum()-1);
        map.put("downPageNum", condition.getPageNum()+1);
        map.put("totalNum", Math.ceil((double) count / condition.getPageSize()));
        StaticTemplateView view = new StaticTemplateView();
        view.setFtlPath(path + File.separator + "app" + File.separator + "ftl");
        view.setFltName("picture_list.ftl");
        view.setDestPath(UtilConfig.picturePageFile+File.separator +"app" + File.separator + "picture" + File.separator + condition.getType());
        view.setDestName("index_" + condition.getPageNum() + ".html");
        view.setData(map);
        FreemakerUtil.freemakerProcess(view);
    }


}
