package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.dao.NovelDao;
import com.app.mvc.acl.dao.NovelPageDao;
import com.app.mvc.acl.po.Novel;
import com.app.mvc.acl.po.NovelPage;
import com.app.mvc.beans.Page;
import com.app.mvc.exception.ServiceException;
import com.app.mvc.util.StringUtil;
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
public class NovelService {

    @Autowired
    private NovelDao novelDao;

    @Autowired
    private NovelPageDao novelPageDao;

    @Transactional
    public void saveNovel(Novel novel) {
        novel.setEnableFlag("Y");
        novel.setCreateDate(new Date());
        try {
            novelDao.saveNovel(novel);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw ServiceException.create("NOVEL.ADD.FALL");
        }
        addOrUpdateNovelPage(novel);
    }


    @Transactional
    public void updateNovel(Novel novel) {
        Novel oldNovel = novelDao.findById(novel.getNovelId());
        oldNovel.setTypeCode(novel.getTypeCode());
        oldNovel.setTitle(novel.getTitle());
        try {
            novelDao.updateNovel(novel);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.UPDATE.FAIL");
        }

        addOrUpdateNovelPage(novel);

    }


    public void addOrUpdateNovelPage(Novel novel) {

        if (novel == null || novel.getNovelPages() == null) {
            return;
        }
        for (NovelPage novelPage :novel.getNovelPages()){
            if(novelPage.getNovelId()==null){
                novelPage.setNovelId(novel.getNovelId());
                novelPageDao.saveNovelPage(novelPage);
            }else{
                novelPageDao.updateNovelPage(novelPage);
            }
        }


    }

    public Novel findById(int novelId) {
        Novel novel;
        try {
            novel = novelDao.findById(novelId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.FIND.IS.FALL");
        }
        return novel;
    }

    public Page<Novel> selectNovelTitleOrType(NovelCondition condition) {
        Page<Novel> page = null;
        try {
            int count = novelDao.countByNovel(condition);
            List<Novel> list = novelDao.searchNovel(condition);
            page = Page.<Novel>builder().data(list).total(count).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.SEARCH.FAIL");
        }
        return page;
    }

    public void saveNovelPage(NovelPage novelPage) {
        novelPage.setCreateDate(new Date());
        try {
            novelPageDao.saveNovelPage(novelPage);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.SEARCH.FAIL");
        }
    }

    public void updateEnableFlag(Integer id, String enableFlag) {
        Novel novel = this.novelDao.findById(id);
        if (novel == null) {
            throw ServiceException.create("NOVEL.FIND.IS.FALL");
        }
        try {
            novel.setEnableFlag(enableFlag);
            novelDao.updateNovel(novel);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.UPDATE.FAIL");
        }
    }

    public void deleteNovel(Integer novelId) {
        try {
            novelDao.deleteNovel(novelId);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw ServiceException.create("NOVEL.UPDATE.FAIL");
        }
    }
}
