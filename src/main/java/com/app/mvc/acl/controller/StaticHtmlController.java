package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.condition.PictureCondition;
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
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public JsonData staticHomeHtml(HttpServletRequest request){
        staticHtmlService.staticIndexHtml(request.getSession().getServletContext().getRealPath(""));
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "film",method = RequestMethod.GET)
    public JsonData staticVodHtml(HttpServletRequest request,Integer[] id){
        staticHtmlService.staticVodHtml(request.getSession().getServletContext().getRealPath(""),id);
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "filmHome",method = RequestMethod.GET)
    public JsonData staticVodHome(HttpServletRequest request){
        staticHtmlService.staticVodHome(request.getSession().getServletContext().getRealPath(""));
        return  JsonData.success(null);
    }


    @ResponseBody
    @RequestMapping(value = "filmPage",method = RequestMethod.GET)
    public JsonData staticVodPageHtml(HttpServletRequest request,FilmCondition condition){
        staticHtmlService.staticVodPageHtml(request.getSession().getServletContext().getRealPath(""),condition);
        return  JsonData.success(null);
    }


    @ResponseBody
    @RequestMapping(value = "picture",method = RequestMethod.GET)
    public JsonData staticPicture(HttpServletRequest request, Integer id){
        staticHtmlService.staticPictureHtml(request.getSession().getServletContext().getRealPath(""),id);
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "pictureHome",method = RequestMethod.GET)
    public JsonData staticPictureHomeHtml(HttpServletRequest request, Integer id){
        staticHtmlService.staticPictureHomeHtml(request.getSession().getServletContext().getRealPath(""));
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "picturePage",method = RequestMethod.GET)
    public JsonData staticPicturePageHtml(HttpServletRequest request, PictureCondition pictureCondition){
        staticHtmlService.staticPicturePageHtml(request.getSession().getServletContext().getRealPath(""),pictureCondition);
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "novel",method = RequestMethod.GET)
    public JsonData staticNovelHtml(HttpServletRequest request,Integer id){
        staticHtmlService.staticNovelHtml(request.getSession().getServletContext().getRealPath(""),id);
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "novelHome",method = RequestMethod.GET)
    public JsonData staticNovelHomeHtml(HttpServletRequest request){
        staticHtmlService.staticNovelHomeHtml(request.getSession().getServletContext().getRealPath(""));
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "novelPage",method = RequestMethod.GET)
    public JsonData staticNovelPageHtml(HttpServletRequest request, NovelCondition condition){
        staticHtmlService.staticNovelPageHtml(request.getSession().getServletContext().getRealPath(""),condition);
        return  JsonData.success(null);
    }


    @ResponseBody
    @RequestMapping(value = "staticAll",method = RequestMethod.GET)
    public JsonData staticAll(HttpServletRequest request){
        staticHtmlService.staticAll(request.getSession().getServletContext().getRealPath(""));
        return  JsonData.success(null);
    }




}
