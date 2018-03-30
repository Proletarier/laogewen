package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.NovelCondition;
import com.app.mvc.acl.condition.NovelRegexCondition;
import com.app.mvc.acl.po.NovelRegex;
import com.app.mvc.acl.service.NovelRegexService;
import com.app.mvc.beans.JsonData;
import com.app.mvc.beans.Page;
import org.dom4j.dom.DOMText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/9.
 */
@Controller
@RequestMapping("/resource/NovelRegex")
public class NovelRegexController {

    @Autowired
    NovelRegexService novelRegexService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public JsonData saveNovelRegex(@RequestBody NovelRegex regex){
         novelRegexService.saveNovelRegex(regex);
         return  JsonData.success(regex);
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public JsonData updateNovelRegex(@RequestBody NovelRegex regex){
        novelRegexService.updateNovelRegex(regex);
        return  JsonData.success(regex);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public  JsonData findById(Integer id){
        NovelRegex novelRegex=novelRegexService.findById(id);
        return JsonData.success(novelRegex);
    }


    @ResponseBody
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public  JsonData searchNovelRegex(NovelRegexCondition condition){
        Page<NovelRegex> page= novelRegexService.searchNovelRegex(condition);
        return JsonData.success(page.getData(),page.getTotal());
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public JsonData deleteNovelRegex(@RequestBody Map<String,String> map){
        novelRegexService.deleteNovelRegex(Integer.valueOf(map.get("id")));
        return JsonData.success();
    }

}
