package com.app.mvc.acl.controller;

import com.app.mvc.acl.po.User;
import com.app.mvc.acl.service.LoginService;
import com.app.mvc.beans.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/4/9.
 */

@Controller
@RequestMapping("/resource/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public JsonData login(HttpServletRequest request, HttpServletResponse response, @RequestBody User user){
        User sysUser=loginService.lgoin(request,response,user);
        return JsonData.success(sysUser);
    }


    @ResponseBody
    @RequestMapping(value = "captcha",method = RequestMethod.GET)
    public  void validateCode(HttpServletRequest request,HttpServletResponse response){
        loginService.generate(request,response);
    }


}
