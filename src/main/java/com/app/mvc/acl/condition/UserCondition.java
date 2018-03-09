package com.app.mvc.acl.condition;

import com.app.mvc.beans.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2018/3/9.
 */

@Getter
@Setter
public class UserCondition  extends PageQuery {

    private  String userName;
}
