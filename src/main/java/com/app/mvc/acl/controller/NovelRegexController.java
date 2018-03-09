package com.app.mvc.acl.controller;

import com.app.mvc.acl.po.FilmRegex;
import com.app.mvc.acl.po.NovelRegex;
import com.app.mvc.acl.service.NovelRegexService;
import com.app.mvc.beans.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
