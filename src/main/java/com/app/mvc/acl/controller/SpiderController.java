package com.app.mvc.acl.controller;

import com.app.mvc.acl.config.UtilConfig;
import com.app.mvc.acl.service.SpiderService;
import com.app.mvc.beans.JsonData;
import com.app.mvc.spider.entity.SpiderFilm;
import com.app.mvc.spider.entity.SpiderNovel;
import com.app.mvc.spider.entity.SpiderPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenheng on 2018/1/6.
 */
@Controller
@RequestMapping("/resource/spider")
public class SpiderController {

    @Autowired
    private SpiderService spiderService;


    @ResponseBody
    @RequestMapping(value = "vod",method = RequestMethod.GET)
    public JsonData spiderVod(String[] seeds, String[] validate){
        spiderService.captureDate(UtilConfig.CACHE_FILM_KEY, SpiderFilm.class,seeds, validate);
        return JsonData.success(null);
    }


    @ResponseBody
    @RequestMapping(value = "picture",method = RequestMethod.GET)
    public JsonData spiderPicture(String[] seeds, String[] validate){
        spiderService.captureDate(UtilConfig.CACHE_PICTURE_KEY, SpiderPicture.class,seeds, validate);
        return JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "novel",method = RequestMethod.GET)
    public JsonData spiderNovel(String[] seeds, String[] validate){
        spiderService.captureDate(UtilConfig.CACH_NOVEL_KEY, SpiderNovel.class,seeds, validate);
        return JsonData.success(null);
    }


    @ResponseBody
    @RequestMapping(value = "saveVod",method = RequestMethod.PUT)
    public  JsonData flushVod(){
        spiderService.flushNovelToDatabase();
        return JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "savePicture",method = RequestMethod.PUT)
    public  JsonData flushPicture(){
        spiderService.flushNovelToDatabase();
        return JsonData.success(null);
    }


    @ResponseBody
    @RequestMapping(value = "saveNovel",method = RequestMethod.PUT)
    public  JsonData flushNovel(){
        spiderService.flushNovelToDatabase();
        return JsonData.success(null);
    }

}
