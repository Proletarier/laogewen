package com.app.mvc.acl.dao;

import com.app.mvc.acl.condition.SpiderCondition;
import com.app.mvc.acl.po.SpiderData;
import com.app.mvc.common.DBRepository;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * Created by wenheng on 2018/4/7.
 */

@DBRepository
public interface SpiderDao {

    public  void  insertSpider(SpiderData spiderData);

    public  Set<String> searchSpider(@Param("condition") SpiderCondition condition);

}
