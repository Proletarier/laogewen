package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.LookValueCondition;
import com.app.mvc.acl.po.LookValue;
import com.app.mvc.common.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wenheng on 2018/2/19.
 */
@DBRepository
public interface LookValueDao {

    void saveLookValue(LookValue lookValue);

    void updateLookValue(LookValue lookValue);

    void deleteLookValue(LookValue lookValue);

    List<LookValue> searchLookValue(@Param("condition") LookValueCondition condition);

}
