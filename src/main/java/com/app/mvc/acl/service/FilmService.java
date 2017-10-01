package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.entity.Film;
import com.app.mvc.beans.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by wenheng on 2017/7/2.
 */
public interface FilmService {

    void saveFilm(Film film);

    void updateFilm(Film film);

    Film findById(Integer filmId);

    Page<Film> selectFilmTypeOrName(FilmCondition filmCondition);

    Map<String,List<Film>> searchHome();

    void staticIndexHtml(String path);

    void staticVodHtml(String path,Integer id);















}
