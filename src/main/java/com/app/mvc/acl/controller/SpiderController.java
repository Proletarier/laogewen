package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.config.UtilConfig;
import com.app.mvc.acl.po.Film;
import com.app.mvc.acl.po.Novel;
import com.app.mvc.acl.po.Picture;
import com.app.mvc.acl.service.SpiderService;
import com.app.mvc.beans.JsonData;
import com.app.mvc.beans.Page;
import com.app.mvc.acl.dto.SpiderFilm;
import com.app.mvc.acl.dto.SpiderNovel;
import com.app.mvc.acl.dto.SpiderPicture;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by wenheng on 2018/1/6.
 */
@Controller
@RequestMapping("/resource/spider")
public class SpiderController {

    @Autowired
    private SpiderService spiderService;


    /**
     * 电影
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "vod",method = RequestMethod.GET)
    public JsonData spiderVod(Integer regexId,String[] seeds, String[] validate,Integer size){
        spiderService.captureDate(UtilConfig.CACHE_FILM_KEY, SpiderFilm.class,seeds, validate,size);
        return JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "saveVod",method = RequestMethod.PUT)
    public  JsonData flushVod(){
        spiderService.flushVodToDatabase();
        return JsonData.success(null);
    }


    @ResponseBody
    @RequestMapping(value = "vod/search",method = RequestMethod.GET)
    public JsonData searchVod(FilmCondition condition){
       Page<Film> page=spiderService.searchVod(condition);
        return JsonData.success(page.getData(),page.getTotal());
    }

    @ResponseBody
    @RequestMapping(value = "vod",method = RequestMethod.PUT)
    public JsonData updateVod(@RequestBody  Film film){
        spiderService.updateFilm(film);
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping(value = "vod",method = RequestMethod.DELETE)
    public JsonData deleteVod(@RequestBody Map<String,Integer> map){
        spiderService.deleteFilm(map.get("id"));
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping(value = "find/vod",method = RequestMethod.GET)
    public JsonData findByVod(Integer id){
       Film film=spiderService.findByVod(id);
        return JsonData.success(film);
    }

    @ResponseBody
    @RequestMapping(value = "/getVod", produces = "text/event-stream;charset=UTF-8")
    public String getSpiderContent(){
        return "data:Testing 1,2,3" + "嘤嘤婴" + "\n\n";
    }

    @ResponseBody
    @RequestMapping(value = "isWork",method = RequestMethod.GET)
    public boolean  isSpiderWorking(String key){
        return spiderService.isSpiderWorking(key);
    }



    /**
     * 图片
     * @param seeds
     * @param validate
     * @param size
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "picture",method = RequestMethod.GET)
    public JsonData spiderPicture(String[] seeds, String[] validate,Integer size){
        spiderService.captureDate(UtilConfig.CACHE_PICTURE_KEY, SpiderPicture.class,seeds, validate,size);
        return JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "savePicture",method = RequestMethod.PUT)
    public  JsonData flushPicture(){
        spiderService.flushPictureToDatabase();
        return JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "pic/search",method = RequestMethod.GET)
    public JsonData searchPic(PictureCondition condition){
        Page<Picture> page=spiderService.searchPic(condition);
        return JsonData.success(page.getData(),page.getTotal());
    }

    @ResponseBody
    @RequestMapping(value = "pic",method = RequestMethod.PUT)
    public JsonData updatePic(@RequestBody  Picture picture){
        spiderService.updatePicture(picture);
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping(value = "pic/search",method = RequestMethod.DELETE)
    public JsonData deletePic(@RequestBody Map<String,Integer> map){
        spiderService.deletePicture(map.get("id"));
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping(value = "find/pic",method = RequestMethod.GET)
    public JsonData findByPic(Integer id){
        Picture picture=spiderService.findByPic(id);
        return JsonData.success(picture);
    }


    /**
     * 小说
     * @param seeds
     * @param validate
     * @param size
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "novel",method = RequestMethod.GET)
    public JsonData spiderNovel(String[] seeds, String[] validate,Integer size){
        spiderService.captureDate(UtilConfig.CACH_NOVEL_KEY, SpiderNovel.class,seeds, validate,size);
        return JsonData.success(null);
    }


    @ResponseBody
    @RequestMapping(value = "saveNovel",method = RequestMethod.PUT)
    public  JsonData flushNovel(){
        spiderService.flushNovelToDatabase();
        return JsonData.success(null);
    }


    @ResponseBody
    @RequestMapping(value = "novel/search",method = RequestMethod.GET)
    public JsonData searchNovel(NovelCondition condition){
        Page<Novel> page=spiderService.searchNovel(condition);
        return JsonData.success(page.getData(),page.getTotal());
    }

    @ResponseBody
    @RequestMapping(value = "novel",method = RequestMethod.DELETE)
    public JsonData deleteNovel(@RequestBody Map<String,Integer> map){
        spiderService.deleteNovel(map.get("id"));
        return JsonData.success();
    }

}
