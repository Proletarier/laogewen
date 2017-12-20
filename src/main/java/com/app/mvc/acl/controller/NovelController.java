package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.entity.Novel;
import com.app.mvc.acl.service.NovelService;
import com.app.mvc.beans.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        novelService.saveNovel(novel);
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
        return JsonData.success(novelService.selectNovelTitleOrType(condition));
    }


}
