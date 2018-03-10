package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.FilmRegexCondition;
import com.app.mvc.acl.dao.FilmRegexDao;
import com.app.mvc.acl.po.FilmRegex;
import com.app.mvc.beans.Page;
import com.app.mvc.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
@Slf4j
@Service
public class FilmRegexService {

    @Autowired
    FilmRegexDao regexDao;

    @Transactional
    public  void  saveFilmRegex(FilmRegex regex){
        regex.setCreationDate(new Date());
        try{
            regexDao.saveFilmRegex(regex);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.ADD.FALL");
        }
    }

    @Transactional
    public  void updateFilmRegex(FilmRegex regex){
        try{
            regexDao.updateFilmRegex(regex);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.UPDATE.FAIL");
        }
    }

    public  FilmRegex findById(Integer id){
        FilmRegex regex;
        try{
            regex=regexDao.findById(id);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.FIND.IS.FALL");
        }
        return  regex;
    }

    public Page<FilmRegex> searchFilmRregex(FilmRegexCondition condition){
        Page<FilmRegex> regexPage=null;
        try{
            int count=regexDao.countByFilmRegex(condition);
            if(count>0){
                List<FilmRegex> list=regexDao.searchFilmRegex(condition);
                regexPage=Page.<FilmRegex>builder().total(count).pageNum(condition.getPageNum()).data(list).build();
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.SEARCH.FALL");
        }
        return regexPage;
    }

}
