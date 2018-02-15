package com.app.mvc.acl.condition;

import com.app.mvc.beans.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by wenheng on 2017/8/17.
 */

@Getter
@Setter
public class NovelCondition extends PageQuery {

    private String title;

    private String type;

    private Integer novelId;
}
