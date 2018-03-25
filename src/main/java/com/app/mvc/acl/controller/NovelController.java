package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.po.Novel;
import com.app.mvc.acl.service.NovelService;
import com.app.mvc.beans.JsonData;
import com.app.mvc.beans.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/20.
 */

@Controller
@RequestMapping("/resource/novel")
public class NovelController {

    @Autowired
    private NovelService novelService;

    @ResponseBody
    @RequestMapping(method= RequestMethod.POST)
    public JsonData saveNovel(@RequestBody Novel novel){
        novelService.saveNovel(novel);
        return  JsonData.success(novel);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public JsonData updateNovel(@RequestBody Novel novel){
        novelService.updateNovel(novel);
        return  JsonData.success(novel);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public JsonData findById(Integer  id){
        return  JsonData.success(novelService.findById(id));
    }

    @ResponseBody
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public  JsonData selectNovelTitleOrType(NovelCondition condition){
        Page<Novel> page=novelService.selectNovelTitleOrType(condition);
        return JsonData.success(page.getData(),page.getTotal());
    }

    @ResponseBody
    @RequestMapping(value = "update/enableFlag",method = RequestMethod.PUT)
    public JsonData updateEnableFlag(@RequestBody Map<String,String> map){
        novelService.updateEnableFlag(Integer.valueOf(map.get("id")),map.get("enableFlag"));
        return  JsonData.success();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public JsonData deleteNovel(@RequestBody Map<String,String> map){
        novelService.deleteNovel(Integer.valueOf(map.get("id")));
        return  JsonData.success();
    }


}
