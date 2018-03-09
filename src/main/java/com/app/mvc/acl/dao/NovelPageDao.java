package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.po.NovelPage;
import com.app.mvc.acl.po.NovelRegex;
import com.app.mvc.common.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11.
 */
@DBRepository
public interface NovelPageDao {

    void  saveNovelPage(NovelPage novelPage);

    void  updateNovelPage(NovelPage novelPage);

    NovelRegex findById(@Param("novelPageId") Integer novelPageId);

    List<NovelPage> findByNovelId(@Param("novelId") Integer novelId);

    List<NovelPage> searchNovelPage(@Param("condition") NovelCondition condition);


}
