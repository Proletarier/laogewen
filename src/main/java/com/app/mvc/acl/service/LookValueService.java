package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.LookValueCondition;
import com.app.mvc.acl.dao.LookValueDao;
import com.app.mvc.acl.po.Film;
import com.app.mvc.acl.po.LookValue;
import com.app.mvc.beans.Page;
import com.app.mvc.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wenheng on 2018/2/19.
 */

@Slf4j
@Service
public class LookValueService {

    @Autowired
    private LookValueDao lookValueDao;


    @Transactional
    public void saveLookValue(LookValue lookValue) {
        try {
            lookValueDao.saveLookValue(lookValue);
        } catch (Exception e) {
            log.error(e.getMessage());
            ServiceException.create("LOOK.ADD.FALL");
        }
    }

    @Transactional
    public void updateLookValue(LookValue lookValue) {
        try {
            lookValueDao.updateLookValue(lookValue);
        } catch (Exception e) {
            log.error(e.getMessage());
            ServiceException.create("LOOK.UPDATE.FAIL");
        }
    }

    public Page<LookValue> searchLookValue(LookValueCondition condition) {
        Page<LookValue> page = null;
        try {
            List<LookValue> lookValues = lookValueDao.searchLookValue(condition);
            if (lookValues.size() > 0) {
                page = Page.<LookValue>builder().total(lookValues.size()).pageNum(condition.getPageNum()).data(lookValues).build();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            ServiceException.create("LOOK.SEARCH.FAIL");
        }
        return page;
    }

    public List<LookValue> searchLookValueList(LookValueCondition condition) {
        List<LookValue> lookValues = null;
        try {
            lookValues = lookValueDao.searchLookValue(condition);
        } catch (Exception e) {
            log.error(e.getMessage());
            ServiceException.create("LOOK.SEARCH.FAIL");
        }
        return lookValues;
    }

    public LookValue findLookValue(LookValueCondition condition) {

        if (condition.getLookType() == null || condition.getLookCode() == null) {
            ServiceException.create("LOOK.IS.NULL");
        }
        List<LookValue> lookValues = null;
        try {
            lookValues = lookValueDao.searchLookValue(condition);
        } catch (Exception e) {
            log.error(e.getMessage());
            ServiceException.create("LOOK.FIND.IS.FALL");
        }
        if (lookValues.size() == 0 || lookValues.size() > 1) {
            ServiceException.create("LOOK.THE.ENTITY.IS.NOT.FOUND");
        }
        return lookValues.get(0);
    }

}
