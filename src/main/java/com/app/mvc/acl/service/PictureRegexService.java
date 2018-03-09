package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.PictureRegexCondition;
import com.app.mvc.acl.dao.PictureRegexDao;
import com.app.mvc.acl.po.PictureRegex;
import com.app.mvc.beans.Page;
import com.app.mvc.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
@Slf4j
@Service
public class PictureRegexService {

    @Autowired
    PictureRegexDao regexDao;

    public  void savePictureRegex(PictureRegex regex){
        try{
            regexDao.savePictureRegex(regex);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.ADD.FALL");
        }
    }

    public  void  updatePictureRegex(PictureRegex regex){
        try{
            regexDao.updatePictureRegex(regex);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.UPDATE.FALL");
        }
    }

    public  PictureRegex findById(Integer id){
        PictureRegex regex;
        try{
             regex=regexDao.findById(id);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.FIND.FALL");
        }
        return  regex;
    }

    public Page<PictureRegex> searchPictureRegex(PictureRegexCondition condition){
        Page<PictureRegex> regexPage=null;
        try{
            int count=regexDao.countByPictureRegex(condition);
            if(count>0){
                List<PictureRegex> list=regexDao.searchPictureRegex(condition);
                regexPage=Page.<PictureRegex>builder().total(count).pageNum(condition.getPageNum()).data(list).build();
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.SEARCH.FALL");
        }
        return  regexPage;
    }


}
