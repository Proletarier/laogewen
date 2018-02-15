package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.config.UtilConfig;
import com.app.mvc.acl.service.StaticHtmlService;
import com.app.mvc.beans.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/1/5.
 */
@Controller
@RequestMapping("/resource/static")
public class StaticHtmlController {

    @Autowired
    private StaticHtmlService staticHtmlService;


    @ResponseBody
    @RequestMapping(value = "home/IndexHtml",method = RequestMethod.GET)
    public JsonData createHomeHtml(HttpServletRequest request){
        staticHtmlService.staticIndexHtml("C:\\Users\\wenheng\\Desktop");
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "film",method = RequestMethod.GET)
    public JsonData createVodHtml(HttpServletRequest request,Integer id){
        staticHtmlService.staticVodHtml(request.getSession().getServletContext().getRealPath("app/vod/"),id);
        return  JsonData.success(null);
    }


    @ResponseBody
    @RequestMapping(value = "picture",method = RequestMethod.GET)
    public JsonData staticPicture(HttpServletRequest request, Integer id){
        staticHtmlService.staticPictureHtml(request.getSession().getServletContext().getRealPath("app/picture/"),id);
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "picturePageHtml",method = RequestMethod.GET)
    public JsonData staticPicturePageHtml(HttpServletRequest request, PictureCondition pictureCondition){
        staticHtmlService.staticPicturePageHtml(UtilConfig.picturePageFile,pictureCondition);
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "novel",method = RequestMethod.GET)
    public JsonData staticNovelHtml(HttpServletRequest request,Integer id){
        staticHtmlService.staticNovelHtml(UtilConfig.picturePageFile,id);
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "novelPageHtml",method = RequestMethod.GET)
    public JsonData staticNovelPageHtml(HttpServletRequest request, NovelCondition condition){
        staticHtmlService.staticNovelPageHtml(UtilConfig.picturePageFile,condition);
        return  JsonData.success(null);
    }





}
