package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.po.Film;
import com.app.mvc.common.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wenheng on 2017/7/2.
 */
@DBRepository
public interface FilmDao {

    void saveFilm(Film film);

    void updateFilm(Film film);

    Film findById(@Param("filmId") Integer filmId);

    List<Film> selectFilmTypeOrName(@Param("filmCondition") FilmCondition filmCondition);

    int countByFilm(@Param("filmCondition") FilmCondition filmCondition);

}


















