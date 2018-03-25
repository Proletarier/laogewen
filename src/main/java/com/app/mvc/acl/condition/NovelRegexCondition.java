package com.app.mvc.acl.condition;

import com.app.mvc.beans.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by wenheng on 2018/1/13.
 */
@Getter
@Setter
public class NovelRegexCondition extends PageQuery {

    private String  description;

    private String  startDate;

    private String  endDate;

}