package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.dao.NovelDao;
import com.app.mvc.acl.po.Novel;
import com.app.mvc.beans.Page;
import com.app.mvc.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wenheng on 2017/7/2.
 */

@Slf4j
@Service
public class NovelService {

    @Autowired
    private NovelDao novelDao;

    public void saveNovel(Novel novel) {
        try {
            novelDao.saveNovel(novel);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.ADD.FALL");
        }
    }

    public void updateNovel(Novel novel) {
        try {
            novelDao.updateNovel(novel);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.UPDATE.FAIL");
        }
    }

    public Novel findById(int novelId) {
        Novel novel;
        try {
            novel= novelDao.findById(novelId);
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.FIND.IS.FALL");
        }
        return novel;
    }

    public Page<Novel> selectNovelTitleOrType(NovelCondition condition) {
        Page<Novel> page=null;
        try {
            List<Novel> list=novelDao.selectNovelTitleOrType(condition);
            page=Page.<Novel>builder().data(list).build();
        }catch (Exception e){
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.SEARCH.FAIL");
        }
        return page;
    }
}
