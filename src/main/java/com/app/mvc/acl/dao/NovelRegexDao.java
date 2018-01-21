package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.NovelRegexCondition;
import com.app.mvc.acl.po.NovelRegex;
import com.app.mvc.common.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wenheng on 2018/1/6.
 */
@DBRepository
public interface NovelRegexDao {

    void saveNovelRegex(NovelRegex novelRegex);

    void updateNovelRegex(NovelRegex novelRegex);

    void  findById(@Param("novelRegexId") Integer novelRegexId);

    List<NovelRegex>  searchNovelRegex(@Param("condition") NovelRegexCondition condition);
}
