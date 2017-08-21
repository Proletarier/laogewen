package com.app.mvc.acl.condition;

import com.app.mvc.beans.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by wenheng on 2017/8/16.
 */
@Getter
@Setter
public class PictureCondition extends PageQuery {

    private String name;

    private String type;

    private String clickFlag="N";
}
