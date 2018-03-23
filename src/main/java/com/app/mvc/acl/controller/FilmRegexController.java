package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.FilmRegexCondition;
import com.app.mvc.acl.po.FilmRegex;
import com.app.mvc.acl.service.FilmRegexService;
import com.app.mvc.beans.JsonData;
import com.app.mvc.beans.Page;
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
@RequestMapping("/resource/FilmRegex")
public class FilmRegexController {

    @Autowired
    FilmRegexService filmRegexService;


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public JsonData saveFilmRegex(@RequestBody FilmRegex regex){
        filmRegexService.saveFilmRegex(regex);
        return JsonData.success(regex);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public JsonData updateFilmRegex(@RequestBody FilmRegex regex){
        filmRegexService.updateFilmRegex(regex);
        return JsonData.success(regex);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public  JsonData findById(Integer id){
        FilmRegex filmRegex=filmRegexService.findById(id);
        return JsonData.success(filmRegex);
    }


    @ResponseBody
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public  JsonData searchFilmRegex(FilmRegexCondition condition){
        Page<FilmRegex> page=filmRegexService.searchFilmRregex(condition);
        return  JsonData.success(page);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public JsonData deleteFilmRegex(Integer id){
        filmRegexService.deleteFilmRegex(id);
        return JsonData.success();
    }



}
