package com.app.mvc.acl.service.impl;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.config.FilmType;
import com.app.mvc.acl.dao.FilmDao;
import com.app.mvc.acl.entity.Film;
import com.app.mvc.acl.service.FilmService;
import com.app.mvc.acl.service.PictureService;
import com.app.mvc.beans.Page;
import com.app.mvc.beans.StaticTemplateView;
import com.app.mvc.exception.ServiceException;
import com.app.mvc.util.DateUtil;
import com.app.mvc.util.FreemakerUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wenheng on 2017/7/2.
 */
@Slf4j
@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmDao filmDao;

    @Autowired
    PictureService pictureService;


    public void saveFilm(Film film) {
        try {
            filmDao.saveFilm(film);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("FILM.ADD.FALL");
        }
    }

    public void updateFilm(Film film) {
        try {
            filmDao.updateFilm(film);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("FILM.UPDATE.FAIL");
        }

    }

    public Film findById(Integer filmId) {
        Film film = null;
        try {
            film = filmDao.findById(filmId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("FILM.UPDATE.FAIL");
        }
        return film;
    }

    public Page<Film> selectFilmTypeOrName(FilmCondition filmCondition) {
        Page<Film> page = null;
        try {
            FilmCondition sl = new FilmCondition();
            sl.setFilmType(filmCondition.getFilmType());
            int count = filmDao.countByFilm(sl);
            if (count > 0) {
                List<Film> films = filmDao.selectFilmTypeOrName(filmCondition);
                page = Page.<Film>builder().total(count).pageNum(filmCondition.getPageNum()).data(films).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw ServiceException.create("FILM.SEARCH.FAIL");
        }
        return page;
    }

    @Override
    public Map<String, List<Film>> searchHome() {
        FilmCondition condition = null;
        List<Film> films = null;
        Map<String, List<Film>> map = Maps.newHashMap();
        try {
            //今日更新
            condition = new FilmCondition();
            condition.setPageSize(14);
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(FilmType.JRGX.toString(), films);
            //本周热播
            condition.setPageSize(12);
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(FilmType.BZRB.toString(), films);
            //猜您喜欢
            condition.setPageSize(8);
            condition.setClickFlag("Y");
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(FilmType.CNXH.toString(), films);
            //亚洲色情
            condition.setFilmType(FilmType.YZQS.toString());
            condition.setPageSize(6);
            condition.setClickFlag("N");
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(FilmType.YZQS.toString(), films);
            //制服丝袜
            condition.setFilmType(FilmType.ZFSW.toString());
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(FilmType.ZFSW.toString(), films);
            //欧美性爱
            condition.setFilmType(FilmType.OMXA.toString());
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(FilmType.OMXA.toString(), films);
            //网友自拍
            condition.setFilmType(FilmType.WYZP.toString());
            films = filmDao.selectFilmTypeOrName(condition);
            if (films != null)
                map.put(FilmType.WYZP.toString(), films);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("FILM.SEARCH.FAIL");
        }
        return map;
    }


    public int countbyFilm(FilmCondition filmCondition) {
        int count = 0;
        try {
            count = filmDao.countByFilm(filmCondition);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return count;
    }


    @Override
    public void staticIndexHtml(String path) {
        Map<String, Object> map = Maps.newHashMap();
        FilmCondition filmCondition = new FilmCondition();
        filmCondition.setStartDate(DateUtil.format(new Date(), "yyyy-MM-dd"));
        filmCondition.setEndDate(DateUtil.format(new Date(), "yyyy-MM-dd"));
        map.putAll(this.searchHome());
        map.putAll(pictureService.searchHome());
        map.put(FilmType.GXSL.name(), this.countbyFilm(filmCondition));
        map.put("count",this.countbyFilm(new FilmCondition()));
        StaticTemplateView view = new StaticTemplateView();
        view.setFtlPath(path + File.separator + "app" + File.separator + "ftl");
        view.setFltName("index.ftl");
        view.setDestPath(path + File.separator + "app" + File.separator + "main");
        view.setDestName("index.html");
        view.setData(map);
        FreemakerUtil.freemakerProcess(view);
    }

    @Override
    public void staticVodHtml(String path,Integer id) {
        Map<String, Object> map = Maps.newHashMap();
        Film film=filmDao.findById(id);
        film.setCodeValue(FilmType.valueOf(film.getFilmType()).getValue());
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


}
