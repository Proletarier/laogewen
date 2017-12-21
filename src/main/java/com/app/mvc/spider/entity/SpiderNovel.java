package com.app.mvc.spider.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wenheng on 2017/8/20.
 */
public class SpiderNovel {


    boolean getReadUrl(String url){
        Pattern pattern=Pattern.compile("vod");
        Matcher matcher=pattern.matcher(url);
        if(matcher.find()){
            return  true;
        }else {
            return false;
        }
    }

    @Override
    public String toString(){
        String sql="";
        return sql;
    }
}
