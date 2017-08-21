package com.app.mvc.spider.bean;

import com.app.mvc.acl.entity.Picture;
import com.app.mvc.spider.Spider;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wenheng on 2017/8/20.
 */
public class SpiderPicture {

    private Picture picture;

    public  SpiderPicture(String url){
        if(getReadUrl(url)){
            picture=new Picture();
            String content= Spider.sendGet(url);
            picture.setName(getFindGroup(content,""));
            picture.setTypeCode(getFindGroup(content,""));
            //匹配图片内容
            Pattern pattern=Pattern.compile("<p><img\\ssrc=\"(.+?)\".+?</p>");
            Matcher matcher=pattern.matcher(content);
            ArrayList<String> listString = Lists.newArrayList();
            boolean isFind=matcher.find();
            while (isFind){
                listString.add(matcher.group(1));
                isFind=matcher.find();
            }
            picture.setImg(Joiner.on(";").join(listString));
        }
    }

    String getFindGroup(String content,String regex){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(content);
        if(matcher.find()){
            return  matcher.group(1);
        }
        return null;
    }


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
