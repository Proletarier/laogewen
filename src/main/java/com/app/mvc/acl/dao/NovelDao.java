package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.po.Novel;
import com.app.mvc.common.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wenheng on 2017/7/2.
 */
@DBRepository
public interface NovelDao  {

    void  saveNovel(Novel novel);

    void  updateNovel(Novel novel);

    Novel findById(@Param("novelId") int novelId);

    List<Novel> selectNovelTitleOrType(@Param("condition") NovelCondition condition);


}
