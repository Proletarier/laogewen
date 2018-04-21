package com.app.mvc.acl.dto;

import com.app.mvc.acl.config.UtilConfig;
import com.app.mvc.acl.po.Film;
import com.app.mvc.util.HttpUtil;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wenheng on 2017/7/16.
 */
public class SpiderFilm {

    private Film film;

    public SpiderFilm(String url) {
        if (getReadUrl(url)) {
            film = new Film();
            String content = HttpUtil.sendGet(url);
            film.setFilmType(getFindGroup(content, "info.+?<a.+?>(.+?)</a>"));
            film.setFilmName(getFindGroup(content, "info.+?<h1>(.+?)</h1>"));
            film.setTitleImg(getFindGroup(content, "pic.+?src=\"(.+?)\""));
            film.setXfplay(getFindGroup(content, "(xfplay:.+?)\\b\">"));
            // film.setHttp(getFindGroup(content,"(https:.+?)\\b\">"));
            film.setEd2k(getFindGroup(content, "played2k.+?<textarea.+?>(.*?)</textarea>"));
            film.setQqdl(getFindGroup(content, "<a\\s+class=\"d2\".+?(qqdl:.+?)\"{1}\\s+target.+?>"));
            film.setFlashGet(getFindGroup(content, "<a\\s+class=\"d3\".+?(flashget:.+?)\"{1}\\s+target.+?>"));
            film.setThunder(getFindGroup(content, "<a\\s+class=\"d1\".+?(thunder:.+?)\"{1}\\s+target.+?>"));
            //匹配图片内容
            Pattern pattern = Pattern.compile("<p><img\\ssrc=\"(.+?)\".+?</p>");
            Matcher matcher = pattern.matcher(content);
            ArrayList<String> listString = Lists.newArrayList();
            boolean isFind = matcher.find();
            while (isFind) {
                listString.add(matcher.group(1));
                isFind = matcher.find();
            }
            film.setImg(listString.toArray(new String[listString.size()]));
            film.setContentImg(Joiner.on(";").join(film.getImg()));

            film.setMd5("");
            film.setUrl("");
            for (UtilConfig.FilmType type : UtilConfig.FilmType.values()) {
                if (type.getValue().equals(film.getFilmType()))
                    film.setFilmType(type.name());
            }
        }
    }

    String getFindGroup(String content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    //处理url
    boolean getReadUrl(String url) {
        Pattern pattern = Pattern.compile("vod");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            pattern = Pattern.compile("play");
            matcher = pattern.matcher(url);
            if (matcher.find()) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        if (film == null) return null;
        String sql = "INSERT INTO lgw_film(film_type,film_name,title_img,content_img,xfplay,http,ed2k,thunder,qqdl," +
                "flashget) values(" +
                "'" + film.getFilmType() + "','" + film.getFilmName() + "','" + film.getTitleImg() + "'," +
                "'" + film.getContentImg() + "','" + film.getXfplay() + "','" + film.getHttp() + "','" + film.getEd2k() + "','" + film.getThunder() + "'," +
                "'" + film.getQqdl() + "','" + film.getFlashGet() + "');";
        return sql;
    }

}
