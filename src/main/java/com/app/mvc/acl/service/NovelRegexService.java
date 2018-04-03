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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */
@Slf4j
@Service
public class NovelRegexService {

    @Autowired
    NovelRegexDao regexDao;

    @Transactional
    public  void  saveNovelRegex(NovelRegex regex){
        regex.setCreateDate(new Date());
        try{
            regexDao.saveNovelRegex(regex);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.ADD.FAIL");
        }
    }

    @Transactional
    public  void updateNovelRegex(NovelRegex regex){
       NovelRegex oldRegex=regexDao.findById(regex.getNovelRegexId());
       oldRegex.setTypeRegex(regex.getTypeRegex());
       oldRegex.setTitleRegex(regex.getTitleRegex());
       oldRegex.setContentRegex(regex.getContentRegex());
       oldRegex.setDescription(regex.getDescription());
       oldRegex.setIndexRegex(regex.getIndexRegex());
        try{
            regexDao.updateNovelRegex(oldRegex);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.UPDATE.FAIL");
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
            List<NovelRegex> list=regexDao.searchNovelRegex(condition);
            novelRegexPage=Page.<NovelRegex>builder().total(count).pageNum(condition.getPageNum()).data(list).build();
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.SEARCH.FALL");
        }
        return  novelRegexPage;
    }

    public  void  deleteNovelRegex(Integer id){
        try{
            regexDao.deleteNovelRegex(id);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("REGEX.UPDATE.FAIL");
        }
    }
}
