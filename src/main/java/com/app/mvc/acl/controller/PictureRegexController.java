package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.PictureRegexCondition;
import com.app.mvc.acl.po.PictureRegex;
import com.app.mvc.acl.service.PictureRegexService;
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
 * Created by Administrator on 2018/3/10.
 */
@Controller
@RequestMapping("/resource/PictureRegex")
public class PictureRegexController {

    @Autowired
    PictureRegexService  regexService;


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public JsonData savePictureRegex(@RequestBody PictureRegex regex){
         regexService.savePictureRegex(regex);
         return  JsonData.success(regex);
    }

    @ResponseBody
    @RequestMapping(method =   RequestMethod.PUT)
    public  JsonData updatePictureRegex(@RequestBody PictureRegex regex){
        regexService.updatePictureRegex(regex);
        return  JsonData.success(regex);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public  JsonData findById(Integer id){
        PictureRegex regex=regexService.findById(id);
        return  JsonData.success(regex);
    }



    @ResponseBody
    @RequestMapping(value = "search",method =RequestMethod.GET)
    public  JsonData searchPictureRegex(PictureRegexCondition condition){
        Page<PictureRegex> page=regexService.searchPictureRegex(condition);
        return  JsonData.success(page.getData(),page.getTotal());
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public JsonData deletePictureRegex(@RequestBody Map<String,String> map){
        regexService.deletePictureRegex(Integer.valueOf(map.get("id")));
        return JsonData.success();
    }



}
