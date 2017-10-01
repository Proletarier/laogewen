package com.app.mvc.acl.config;

/**
 * Created by wenheng on 2017/8/6.
 */
public enum FilmType {

    YZQS("亚洲情色"),
    ZFSW("制服丝袜"),
    OMXA("欧美性爱"),
    WYZP("网友自拍"),
    JDSJ("经典三级"),
    LLND("乱伦虐待"),
    LLBT("另类变态"),
    CRDM("成人动漫"),
    BZRB("本周热播"),
    CNXH("猜您喜欢"),
    JRGX("今日更新"),
    GXSL("更新数量");

    private String value;
    private FilmType(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }



}
