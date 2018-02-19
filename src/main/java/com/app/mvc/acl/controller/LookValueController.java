package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.LookValueCondition;
import com.app.mvc.acl.po.LookValue;
import com.app.mvc.acl.service.LookValueService;
import com.app.mvc.beans.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenheng on 2018/2/19.
 */
@Controller
public class LookValueController {

    @Autowired
    LookValueService lookValueService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public JsonData saveLookValue(LookValue lookValue){
        lookValueService.saveLookValue(lookValue);
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public JsonData updateLookValue(LookValue lookValue){
        lookValueService.updateLookValue(lookValue);
        return  JsonData.success(null);
    }

    @ResponseBody
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public JsonData searchLookValue(LookValueCondition condition){
        return  JsonData.success(lookValueService.searchLookValue(condition));
    }


}
