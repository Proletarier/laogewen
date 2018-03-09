package com.app.mvc.acl.controller;

import com.app.mvc.acl.condition.UserCondition;
import com.app.mvc.acl.po.User;
import com.app.mvc.acl.service.UserService;
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
@RequestMapping("/resource/user")
public class UserController {


    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public JsonData saveUser(@RequestBody User user){
        userService.saveUser(user);
        return JsonData.success(user);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public JsonData updateUser(@RequestBody User user){
        userService.updateUser(user);
        return JsonData.success(user);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public JsonData findById(Integer id){
        User user=userService.findById(id);
        return JsonData.success(user);
    }

    @ResponseBody
    @RequestMapping(value="search",method = RequestMethod.GET)
    public JsonData searchUser(UserCondition condition){
        Page<User> page=userService.searchUser(condition);
        return JsonData.success(page);
    }

}
