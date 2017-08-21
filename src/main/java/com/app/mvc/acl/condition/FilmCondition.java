package com.app.mvc.acl.condition;

import com.app.mvc.beans.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by wenheng on 2017/8/6.
 */


public class FilmCondition extends PageQuery {

    //电影类型
    @Getter
    @Setter
    private  String filmType;

    //电影名称
    @Getter
    @Setter
    private  String filmName;

    //点击数量
    @Getter
    @Setter
    private  String clickFlag="N";

}
