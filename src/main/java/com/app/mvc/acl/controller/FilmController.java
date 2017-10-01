package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.FilmCondition;
import com.app.mvc.acl.entity.Film;
import com.app.mvc.acl.service.FilmService;
import com.app.mvc.beans.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public JsonData selectFilmTypeOrName(FilmCondition filmCondition){
        return  JsonData.success(filmService.selectFilmTypeOrName(filmCondition));
    }

    @ResponseBody
    @RequestMapping(value = "/search/home",method = RequestMethod.GET)
    public JsonData searchHome(){
        Map<String,List<Film>> map=filmService.searchHome();
        return  JsonData.success(map);
    }

    @ResponseBody
    @RequestMapping(value = "static/IndexHtml",method = RequestMethod.GET)
    public JsonData createHomeHtml(HttpServletRequest request){
        filmService.staticIndexHtml("C:\\Users\\wenheng\\Desktop");
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "static/VodHtml",method = RequestMethod.GET)
    public JsonData createVodHtml(HttpServletRequest request,Integer id){
        filmService.staticVodHtml(request.getSession().getServletContext().getRealPath("app/vod/"),id);
        return  JsonData.success(null);
    }












}
