package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.po.Picture;
import com.app.mvc.acl.service.PictureService;
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
 * Created by wenheng on 2017/8/17.
 */

@Controller
@RequestMapping("/resource/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public JsonData savePicture(@RequestBody Picture picture) {
        pictureService.savePicture(picture);
        return JsonData.success(picture);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public JsonData updatePicture(@RequestBody Picture picture) {
        pictureService.updatePicture(picture);
        return JsonData.success(picture);
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public JsonData findById(Integer id) {
        return JsonData.success(pictureService.findById(id));
    }

    @ResponseBody
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public JsonData queryPicture(PictureCondition pictureCondition) {
        Page<Picture> page=pictureService.queryPicture(pictureCondition);
        return JsonData.success(page.getData(),page.getTotal());
    }

    @ResponseBody
    @RequestMapping(value = "update/enableFlag",method = RequestMethod.PUT)
    public JsonData updateEnableFlag(@RequestBody Map<String,String> map) {
        pictureService.updateEnableFlag(Integer.valueOf(map.get("id")),map.get("enableFlag"));
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public JsonData deletePicture(@RequestBody Map<String,String> map) {
        pictureService.deletePicture(Integer.valueOf(map.get("id")));
        return JsonData.success();
    }


}
