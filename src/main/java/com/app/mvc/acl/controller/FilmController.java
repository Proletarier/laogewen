package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.po.Film;
import com.app.mvc.acl.service.FilmService;
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
 * Created by wenheng on 2017/7/5.
 */

@Controller
@RequestMapping("/resource/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public JsonData saveFilm(@RequestBody Film film){
        filmService.saveFilm(film);
        return JsonData.success(film);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public JsonData updateFilm(@RequestBody Film film){
        filmService.updateFilm(film);
        return JsonData.success(film);
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public JsonData findById(Integer filmId){
        Film film=filmService.findById(filmId);
        return  JsonData.success(film);
    }

    @ResponseBody
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public JsonData selectFilmTypeOrName(FilmCondition filmCondition){
        Page<Film> page=filmService.selectFilmTypeOrName(filmCondition);
        return  JsonData.success(page.getData(),page.getTotal());
    }


    @ResponseBody
    @RequestMapping(value = "update/enableFlag",method = RequestMethod.PUT)
    public JsonData updateEnableFlag(@RequestBody Map<String, String> map){
        filmService.updateEnableFlag(Integer.valueOf(map.get("id")),map.get("enableFlag"));
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public JsonData deleteFilm(@RequestBody Map<String, String> map){
        filmService.deleteFilm(Integer.valueOf(map.get("id")));
        return JsonData.success();
    }



}
