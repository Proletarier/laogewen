package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.dao.FilmDao;
import com.app.mvc.acl.po.Film;
import com.app.mvc.beans.Page;
import com.app.mvc.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wenheng on 2017/7/2.
 */
@Slf4j
@Service
public class FilmService {

    @Autowired
    FilmDao filmDao;


    @Transactional
    public void saveFilm(Film film) {
        film.setClickAmount(0);
        film.setCreateDate(new Date());
        try {
            filmDao.saveFilm(film);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw ServiceException.create("FILM.ADD.FALL");
        }
    }

    @Transactional
    public void updateFilm(Film film) {
        Integer filmId=film.getFilmId();
        Film oldFilm=filmDao.findById(filmId);
        oldFilm.setFilmName(film.getFilmName());
        oldFilm.setTitleImg(film.getTitleImg());
        oldFilm.setContentImg(film.getContentImg());
        oldFilm.setXfplay(film.getXfplay());
        oldFilm.setEd2k(film.getEd2k());
        oldFilm.setFlashGet(film.getFlashGet());
        oldFilm.setQqdl(film.getQqdl());
        oldFilm.setThunder(film.getThunder());
        oldFilm.setFilmType(film.getFilmType());
        try {
            filmDao.updateFilm(oldFilm);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
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
            int count = filmDao.countByFilm(filmCondition);
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


    public int countByFilm(FilmCondition filmCondition) {
        int count = 0;
        try {
            count = filmDao.countByFilm(filmCondition);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return count;
    }

    @Transactional
    public void deleteFilm(Integer filmId) {
        try{
            filmDao.deleteFilm(filmId);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("FILM.UPDATE.FAIL");
        }
    }

    @Transactional
    public void  updateEnableFlag(Integer filmId,String enableFlag) {
         Film film=filmDao.findById(filmId);
         if(film==null){
             throw ServiceException.create("FILM.UPDATE.FAIL");
         }
         try{
             film.setEnableFlag(enableFlag);
             filmDao.updateFilm(film);
         }catch (Exception e){
             log.error(e.getMessage());
             throw ServiceException.create("FILM.SEARCH.FAIL");
         }
    }



}
