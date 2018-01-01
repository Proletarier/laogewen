package com.app.mvc.spider.entity;

import com.app.mvc.acl.config.utilConfig;
import com.app.mvc.acl.entity.Picture;
import com.app.mvc.util.HttpUtil;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wenheng on 2017/8/20.
 */
public class SpiderPicture {

    @Getter
    @Setter
    private Picture picture;

    public  SpiderPicture(String url){
        if(getReadUrl(url)){
            picture=new Picture();
            String content= HttpUtil.sendGet(url);
            picture.setName(getFindGroup(content,"<a href=\"/html/tupian/.+?/\">.+</a>(.+?)</h2>"));
            picture.setTypeCode(getFindGroup(content,"<a href=\"/html/tupian/\\w+?/\">(.+?)</a>"));
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
           // picture.setTypeCode(utilConfig.PictureType.);

            for (utilConfig.PictureType type : utilConfig.PictureType.values()){
                 if(type.getValue().equals(picture.getTypeCode()))
                     picture.setTypeCode(type.name());
            }

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
        Pattern pattern=Pattern.compile("/tupian/.+?/2017");
        Matcher matcher=pattern.matcher(url);
        if(matcher.find()){
            return  true;
        }else {
            return false;
        }
    }

    @Override
    public String toString(){
        if(picture == null) return null;
        String sql="INSERT INTO lgw_picture(NAME,TYPE_CODE,IMG) VALUES('"+picture.getName().trim()+"'," +
                "'"+picture.getTypeCode()+"','"+picture.getImg()+"');";
        return sql;
    }

}
