package com.app.mvc.acl.service;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.entity.Novel;
import com.app.mvc.beans.Page;

/**
 * Created by wenheng on 2017/7/2.
 */

public interface NovelService {

    void  saveNovel(Novel novel);

    void  updateNovel(Novel novel);

    Novel findById(int novelId);

    Page<Novel> selectNovelTitleOrType(NovelCondition condition);

}
