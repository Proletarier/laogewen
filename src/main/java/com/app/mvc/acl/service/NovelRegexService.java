package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.condition.NovelRegexCondition;
import com.app.mvc.acl.dao.NovelRegexDao;
import com.app.mvc.acl.po.NovelRegex;
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
public class NovelRegexService {

    @Autowired
    NovelRegexDao regexDao;

    public  void  saveNovelRegex(NovelRegex regex){
        try{
            regexDao.saveNovelRegex(regex);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.ADD.FALL");
        }
    }

    public  void updateNovelRegex(NovelRegex regex){
        try{
            regexDao.updateNovelRegex(regex);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.UPDATE.FALL");
        }
    }

    public NovelRegex findById(Integer id){
        NovelRegex  novelRegex;
        try{
            novelRegex=regexDao.findById(id);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.FIND.FALL");
        }
        return  novelRegex;
    }

    public Page<NovelRegex> searchNovelRegex(NovelRegexCondition condition){
        Page<NovelRegex> novelRegexPage=null;
        try{
            int count=regexDao.countByNovelRegex(condition);
            if(count>0){
                List<NovelRegex> list=regexDao.searchNovelRegex(condition);
                novelRegexPage=Page.<NovelRegex>builder().total(count).pageNum(condition.getPageNum()).data(list).build();
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.SEARCH.FALL");
        }
        return  novelRegexPage;
    }
}
