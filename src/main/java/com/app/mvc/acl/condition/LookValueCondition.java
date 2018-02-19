package com.app.mvc.acl.condition;

import com.app.mvc.beans.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by wenheng on 2018/2/19.
 */

@Getter
@Setter
public class LookValueCondition extends PageQuery {

    private  String lookType;

    private  String lookCode;

}
