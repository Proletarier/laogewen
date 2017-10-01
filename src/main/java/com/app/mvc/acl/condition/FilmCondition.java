package com.app.mvc.acl.condition;

import com.app.mvc.beans.PageQuery;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by wenheng on 2017/8/6.
 */

@Getter
@Setter
public class FilmCondition extends PageQuery {

    //电影类型
    private  String filmType;

    //电影名称
    private  String filmName;

    //点击数量
    private  String clickFlag="N";

    private  String startDate;

    private  String endDate;

}
