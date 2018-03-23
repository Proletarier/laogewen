package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.PictureCondition;
import com.app.mvc.acl.po.Picture;
import com.app.mvc.acl.service.PictureService;
import com.app.mvc.beans.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public JsonData updatePicture(Picture picture) {
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
        return JsonData.success(pictureService.queryPicture(pictureCondition));
    }

    @ResponseBody
    @RequestMapping(value = "update/enableFlag",method = RequestMethod.PUT)
    public JsonData updateEnableFlag(Integer id,String enableFlag) {
        pictureService.updateEnableFlag(id,enableFlag);
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public JsonData deletePicture(Integer id) {
        pictureService.deletePicture(id);
        return JsonData.success();
    }


}
